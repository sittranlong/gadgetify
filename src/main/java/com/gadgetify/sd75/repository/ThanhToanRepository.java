package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.ThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ThanhToanRepository extends JpaRepository<ThanhToan, UUID> {
    // Tìm thanh toán theo đơn hàng (hỗ trợ quản lý thanh toán)
    Optional<ThanhToan> findByDonHang_MaDonHang(UUID maDonHang);
}