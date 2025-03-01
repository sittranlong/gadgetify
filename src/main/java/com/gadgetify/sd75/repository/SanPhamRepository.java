package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    // Tìm sản phẩm theo tên (hỗ trợ tìm kiếm)
    List<SanPham> findByTenSanPhamContainingIgnoreCase(String tenSanPham);

    // Tìm sản phẩm theo danh mục (hỗ trợ lọc sản phẩm)
    List<SanPham> findByDanhMuc_MaDanhMuc(UUID maDanhMuc);

    // Tìm sản phẩm mới nhất (hỗ trợ trang chủ)
    @Query("SELECT s FROM SanPham s ORDER BY s.ngayTao DESC")
    List<SanPham> findTopNewProducts();
}