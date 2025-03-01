package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, UUID> {
    // Tìm chi tiết đơn hàng theo đơn hàng
    List<ChiTietDonHang> findByDonHang_MaDonHang(UUID maDonHang);
}