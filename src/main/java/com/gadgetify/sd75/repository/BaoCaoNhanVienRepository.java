package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.BaoCaoNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface BaoCaoNhanVienRepository extends JpaRepository<BaoCaoNhanVien, UUID> {
    // Tìm báo cáo theo nhân viên và ngày (hỗ trợ báo cáo bán hàng cá nhân)
    List<BaoCaoNhanVien> findByNhanVien_MaNguoiDungAndNgayBaoCao(UUID maNhanVien, LocalDate ngayBaoCao);

    // Thống kê doanh thu theo khoảng thời gian (hỗ trợ báo cáo nâng cao)
    @Query("SELECT b FROM BaoCaoNhanVien b WHERE b.ngayBaoCao BETWEEN :startDate AND :endDate")
    List<BaoCaoNhanVien> findByNgayBaoCaoBetween(LocalDate startDate, LocalDate endDate);
}