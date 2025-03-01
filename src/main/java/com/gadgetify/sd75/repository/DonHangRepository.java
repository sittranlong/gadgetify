package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, UUID> {

    Page<DonHang> findByKhachHang_MaNguoiDung(UUID maKhachHang, Pageable pageable);

    // Tìm đơn hàng theo trạng thái (hỗ trợ nhân viên bán hàng/quản trị)
    List<DonHang> findByTrangThai(String trangThai);

    // Tìm đơn hàng theo mã vận chuyển (hỗ trợ tích hợp API GHTK)
    Optional<DonHang> findByMaVanChuyen(String maVanChuyen);
}