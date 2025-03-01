package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.LichSuHoatDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LichSuHoatDongRepository extends JpaRepository<LichSuHoatDong, UUID> {
    // Tìm lịch sử hoạt động theo khách hàng (hỗ trợ AI đề xuất sản phẩm)
    List<LichSuHoatDong> findByKhachHang_MaNguoiDung(UUID maKhachHang);
}