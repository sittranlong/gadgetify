package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.DanhGiaSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhGiaSanPhamRepository extends JpaRepository<DanhGiaSanPham, UUID> {
    // Tìm đánh giá theo sản phẩm (hỗ trợ hiển thị chi tiết sản phẩm)
    List<DanhGiaSanPham> findBySanPham_MaSanPham(UUID maSanPham);
}