package com.example.rentalkendaraan.User;


import com.example.rentalkendaraan.DTO.LoginRequestDTO;
import com.example.rentalkendaraan.DTO.UserLoginDTO;
import com.example.rentalkendaraan.Exception.FormValidationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Menyimpan logika bisnis dari aplikasi.
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserLoginDTO mapToDTO(User user) {
        UserLoginDTO dto = new UserLoginDTO();
        dto.setId(user.getId());
        dto.setNama(user.getNama());
        dto.setAlamat(user.getAlamat());
        dto.setTelp(user.getTelp());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public UserLoginDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new FormValidationException("email", "Email tidak ditemukan"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new FormValidationException("password", "Password salah");
        }

        return mapToDTO(user);
    }
}
