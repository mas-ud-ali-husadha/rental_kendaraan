package com.example.rentalkendaraan.Admin;

import com.example.rentalkendaraan.DTO.AdminDTO;
import com.example.rentalkendaraan.DTO.PengembalianRequestDTO;
import com.example.rentalkendaraan.DTO.RiwayatDetailDTO;
import com.example.rentalkendaraan.Kendaraan.Kendaraan;
import com.example.rentalkendaraan.Mobil.Mobil;
import com.example.rentalkendaraan.Mobil.MobilService;
import com.example.rentalkendaraan.Motor.Motor;
import com.example.rentalkendaraan.Motor.MotorService;
import com.example.rentalkendaraan.Pemesanan.PemesananService;
import com.example.rentalkendaraan.Pengembalian.Pengembalian;
import com.example.rentalkendaraan.Pengembalian.PengembalianService;
import com.example.rentalkendaraan.config.ApiResponse;
import com.example.rentalkendaraan.config.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final MobilService mobilService;
    private final MotorService motorService;
    private final AdminService adminService;
    private final PemesananService pemesananService;
    private final PengembalianService pengembalianService;

    public AdminController(MobilService mobilService, MotorService motorService, AdminService adminService, PemesananService pemesananService, PengembalianService pengembalianService) {
        this.mobilService = mobilService;
        this.motorService = motorService;
        this.adminService = adminService;
        this.pemesananService = pemesananService;
        this.pengembalianService = pengembalianService;
    }

    private String saveImage(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null || originalFileName.isBlank()) {
            throw new IllegalArgumentException("Nama file tidak valid");
        }

        String fileName = UUID.randomUUID() + "_" + originalFileName.replaceAll("\\s+", "_");

        String uploadDir = new File("src/main/resources/static/uploads").getAbsolutePath();
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            boolean created = uploadPath.mkdirs();
            if (!created) {
                throw new IOException("Gagal membuat direktori upload: " + uploadPath.getAbsolutePath());
            }
        }

        File dest = new File(uploadPath, fileName);
        file.transferTo(dest);
        return fileName;
    }

    // === Endpoint Mobil ===
    @GetMapping("/kendaraan/mobil")
    public ResponseEntity<?> listMobil() {
        try {
            List<Mobil> mobilList = mobilService.getAll();
            ApiResponse<List<Mobil>> response = new ApiResponse<>("Data mobil ditemukan", mobilList);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/kendaraan/mobil/{id}")
    public ResponseEntity<?>  getMobil(@PathVariable Integer id) {
        try {
            Mobil mobil = mobilService.getById(id);
            ApiResponse<Mobil> response = new ApiResponse<>("Data mobil ditemukan", mobil);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping(value = "/kendaraan/mobil", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> tambahMobil(
            @RequestPart("mobil") Mobil mobil,
            @RequestPart(value = "image", required = false) MultipartFile file) {
        try {
            mobil.setTipe(Kendaraan.Tipe.mobil);

            if (file != null && !file.isEmpty()) {
                String fileName = saveImage(file); // Simpan file & dapatkan nama file
                mobil.setImage(fileName);
            }

            Mobil created = mobilService.create(mobil);
            return ResponseEntity.ok(new ApiResponse<>("Berhasil menambahkan mobil", created));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Gagal menambahkan mobil: " + e.getMessage()));
        }
    }

    @PutMapping(value = "/kendaraan/mobil/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateMobil(
            @PathVariable Integer id,
            @RequestPart("mobil") Mobil mobil,
            @RequestPart(value = "image", required = false) MultipartFile file) {
        try {
            mobil.setTipe(Kendaraan.Tipe.mobil);

            if (file != null && !file.isEmpty()) {
                String fileName = saveImage(file);  // simpan file
                mobil.setImage(fileName);
            }

            Mobil updated = mobilService.update(id, mobil);
            return ResponseEntity.ok(new ApiResponse<>("Berhasil update mobil", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Gagal update mobil: " + e.getMessage()));
        }
    }

    @DeleteMapping("/kendaraan/mobil/{id}")
    public ResponseEntity<?> hapusMobil(@PathVariable Integer id) {
        try {
            mobilService.delete(id);
            return ResponseEntity.ok(new ApiResponse<>("Berhasil menghapus mobil", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Gagal menghapus mobil: " + e.getMessage()));
        }
    }

    // === Endpoint Motor ===
    @GetMapping("/kendaraan/motor")
    public ResponseEntity<?> listMotor() {
        try {
            List<Motor> mobilList = motorService.getAll();
            ApiResponse<List<Motor>> response = new ApiResponse<>("Data motor ditemukan", mobilList);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/kendaraan/motor/{id}")
    public ResponseEntity<?> getMotor(@PathVariable Integer id) {
        try {
            Motor mobilList = motorService.getById(id);
            ApiResponse<Motor> response = new ApiResponse<>("Data motor ditemukan", mobilList);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping(value = "/kendaraan/motor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> tambahMotor(
            @RequestPart("motor") Motor motor,
            @RequestPart(value = "image", required = false) MultipartFile file
    ) {
        try {
            motor.setTipe(Kendaraan.Tipe.motor);

            if (file != null && !file.isEmpty()) {
                String fileName = saveImage(file); // Simpan file & dapatkan nama file
                motor.setImage(fileName);
            }

            Motor created = motorService.create(motor);
            return ResponseEntity.ok(new ApiResponse<>("Berhasil menambahkan motor", created));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Gagal menambahkan motor: " + e.getMessage()));
        }
    }

    @PutMapping(value = "/kendaraan/motor/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateMotor(
            @PathVariable Integer id,
            @RequestPart("motor") Motor motor,
            @RequestPart(value = "image", required = false) MultipartFile file
    ) {
        try {
            motor.setTipe(Kendaraan.Tipe.motor);

            if (file != null && !file.isEmpty()) {
                String fileName = saveImage(file);
                motor.setImage(fileName);
            }

            Motor updated = motorService.update(id, motor);
            return ResponseEntity.ok(new ApiResponse<>("Berhasil update motor", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Gagal update motor: " + e.getMessage()));
        }
    }

    @DeleteMapping("/kendaraan/motor/{id}")
    public ResponseEntity<?> hapusMotor(@PathVariable Integer id) {
        try {
            motorService.delete(id);
            return ResponseEntity.ok(new ApiResponse<>("Berhasil menghapus motor", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Gagal menghapus motor: " + e.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        try {
            Admin saved = adminService.register(admin);
            AdminDTO response = adminService.mapToDTO(saved);
            ApiResponse<AdminDTO> result = new ApiResponse<>("Register Admin Berhasil", response);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping("/pengembalian")
    public ResponseEntity<?> buatPengembalian(@RequestBody PengembalianRequestDTO request) {
        try {
            Pengembalian pengembalian = pengembalianService.createPengembalian(
                    request.pemesananId,
                    request.tanggalPengembalian,
                    request.keterangan,
                    request.denda,
                    request.totalBiaya,
                    request.totalDibayarkan
            );
            ApiResponse<Pengembalian> response = new ApiResponse<>("Pengembalian berhasil disimpan", pengembalian);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/status-sewa-by-code/{kodePemesanan}")
    public ResponseEntity<?> StatusSewaByKode(@PathVariable String kodePemesanan) {
        try {
            RiwayatDetailDTO status = pemesananService.getDetailRiwayatByKode(kodePemesanan);
            return ResponseEntity.ok(new ApiResponse<>("Status pemesanan ditemukan", status));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}
