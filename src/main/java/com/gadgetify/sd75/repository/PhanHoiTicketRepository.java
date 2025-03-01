package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.PhanHoiTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhanHoiTicketRepository extends JpaRepository<PhanHoiTicket, UUID> {
    // Tìm phản hồi theo ticket (hỗ trợ CSKH)
    List<PhanHoiTicket> findByTicket_MaTicket(UUID maTicket);
}