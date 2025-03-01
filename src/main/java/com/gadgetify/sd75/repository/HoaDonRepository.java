package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    // Tìm hóa đơn theo đơn hàng (hỗ trợ xuất hóa đơn)
    Optional<HoaDon> findByDonHang_MaDonHang(UUID maDonHang);
}