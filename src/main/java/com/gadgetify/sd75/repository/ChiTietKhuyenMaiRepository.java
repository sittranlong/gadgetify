package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.ChiTietKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietKhuyenMaiRepository extends JpaRepository<ChiTietKhuyenMai, UUID> {
    // Tìm chi tiết khuyến mãi theo khuyến mãi (hỗ trợ quản lý khuyến mãi)
    List<ChiTietKhuyenMai> findByKhuyenMai_MaKhuyenMai(UUID maKhuyenMai);
}