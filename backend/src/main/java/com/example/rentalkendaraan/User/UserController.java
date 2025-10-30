package com.example.rentalkendaraan.User;

import com.example.rentalkendaraan.DTO.LoginRequestDTO;
import com.example.rentalkendaraan.DTO.UserLoginDTO;
import com.example.rentalkendaraan.config.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//Menangani permintaan (request) dari client (biasanya HTTP request), dan mengembalikan respons.
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request, HttpServletResponse response) {
        UserLoginDTO dto = userService.login(request);

        if (dto == null) {
            Map<String, String> error = new HashMap<>();
            error.put("input", "email");
            error.put("message", "Login gagal, periksa email/password.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }

        // Simulasi token, bisa diganti dengan JWT atau session ID
        String token = "secure-session-token-" + dto.getId();

        // Tambahkan cookie HttpOnly
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .httpOnly(true)
                .secure(false) // true jika pakai HTTPS
                .path("/")
                .maxAge(3600)
                .sameSite("Strict")
                .build();

        response.addHeader("Set-Cookie", cookie.toString());

        ApiResponse<UserLoginDTO> result = new ApiResponse<>("Login Berhasil", dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/user-logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        // Menghapus cookie dengan mengganti isinya dan mengatur maxAge ke 0
        ResponseCookie cookie = ResponseCookie.from("token", "")
                .httpOnly(true)
                .secure(false) 
                .path("/")
                .maxAge(0) 
                .sameSite("Strict")
                .build();

        response.addHeader("Set-Cookie", cookie.toString());

        Map<String, String> result = new HashMap<>();
        result.put("message", "Logout Berhasil");

        return ResponseEntity.ok(result);
    }
}
