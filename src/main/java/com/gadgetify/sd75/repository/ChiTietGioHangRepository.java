package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, UUID> {
    // Tìm chi tiết giỏ hàng theo giỏ hàng
    List<ChiTietGioHang> findByGioHang_MaGioHang(UUID maGioHang);
}