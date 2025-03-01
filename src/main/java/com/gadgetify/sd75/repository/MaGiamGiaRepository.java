package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.MaGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia, UUID> {
    // Tìm mã giảm giá theo tên (hỗ trợ quản lý mã giảm giá)
    Optional<MaGiamGia> findByTenMaGiamGia(String tenMaGiamGia);
}