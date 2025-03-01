package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    // Tìm giỏ hàng theo khách hàng (hỗ trợ quản lý giỏ hàng)
    Optional<GioHang> findByKhachHang_MaNguoiDung(UUID maKhachHang);

    // Tìm giỏ hàng theo sessionId (hỗ trợ khách chưa đăng nhập)
    Optional<GioHang> findBySessionId(String sessionId);
}