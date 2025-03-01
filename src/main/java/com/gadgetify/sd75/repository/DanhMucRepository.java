package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, UUID> {
    // Tìm danh mục theo tên (hỗ trợ hiển thị danh mục sản phẩm)
    List<DanhMuc> findByTenDanhMucContainingIgnoreCase(String tenDanhMuc);
}