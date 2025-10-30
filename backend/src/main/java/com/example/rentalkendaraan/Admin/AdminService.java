package com.example.rentalkendaraan.Admin;

import com.example.rentalkendaraan.DTO.AdminDTO;
import com.example.rentalkendaraan.Interface.UserInterface;
import com.example.rentalkendaraan.User.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserInterface<Admin> {
    public final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;


    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AdminDTO mapToDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setNama(admin.getNama());
        dto.setAlamat(admin.getAlamat());
        dto.setTelp(admin.getTelp());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        dto.setTanggal_bekerja(admin.getTanggal_bekerja());
        return dto;
    }

    @Override
    public Admin register(User user) {
        if (!(user instanceof Admin admin)) {
            throw new IllegalArgumentException("User harus instance dari Admin");
        }

        admin.setRole(User.Role.admin);

        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email sudah terdaftar!");
        }

        String hashedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(hashedPassword);

        return adminRepository.save(admin);
    }
}
