package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.TicketHoTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketHoTroRepository extends JpaRepository<TicketHoTro, UUID> {
    // Tìm ticket theo khách hàng (hỗ trợ CSKH)
    List<TicketHoTro> findByKhachHang_MaNguoiDung(UUID maKhachHang);
}