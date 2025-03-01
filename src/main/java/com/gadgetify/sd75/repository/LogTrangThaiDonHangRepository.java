package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.LogTrangThaiDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LogTrangThaiDonHangRepository extends JpaRepository<LogTrangThaiDonHang, UUID> {
    // Tìm log trạng thái theo đơn hàng (hỗ trợ quản lý trạng thái đơn hàng)
    List<LogTrangThaiDonHang> findByDonHang_MaDonHang(UUID maDonHang);
}