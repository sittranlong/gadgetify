package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.NguoiDung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, UUID> {
    // Tìm người dùng theo email (hỗ trợ đăng nhập, khôi phục mật khẩu)
    Optional<NguoiDung> findByEmail(String email);

    // Tìm người dùng theo Provider và ProviderId (hỗ trợ OAuth2)
    Optional<NguoiDung> findByProviderAndProviderId(String provider, String providerId);

}