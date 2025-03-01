package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.ThongBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao, UUID> {
    // Tìm thông báo theo người nhận (hỗ trợ CSKH)
    List<ThongBao> findByNguoiNhan_MaNguoiDung(UUID maNguoiNhan);
}