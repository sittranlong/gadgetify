package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, UUID> {
    // Tìm khuyến mãi theo trạng thái (hỗ trợ trang chủ)
    List<KhuyenMai> findByTrangThai(Boolean trangThai);
}