package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.YeuCauDoiTra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface YeuCauDoiTraRepository extends JpaRepository<YeuCauDoiTra, UUID> {
    // Tìm yêu cầu đổi trả theo đơn hàng (hỗ trợ xử lý đổi trả)
    List<YeuCauDoiTra> findByDonHang_MaDonHang(UUID maDonHang);
}