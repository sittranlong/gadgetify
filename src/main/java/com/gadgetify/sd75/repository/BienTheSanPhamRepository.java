package com.gadgetify.sd75.repository;


import com.gadgetify.sd75.entity.BienTheSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface BienTheSanPhamRepository extends JpaRepository<BienTheSanPham, UUID> {
    // Tìm biến thể theo sản phẩm
    List<BienTheSanPham> findBySanPham_MaSanPham(UUID maSanPham);

    // Lọc biến thể theo màu sắc, kích cỡ, giá (hỗ trợ tìm kiếm/lọc)
    @Query("SELECT b FROM BienTheSanPham b WHERE " +
            "(:mauSac IS NULL OR b.mauSac = :mauSac) AND " +
            "(:kichCo IS NULL OR b.kichCo = :kichCo) AND " +
            "(:giaMin IS NULL OR b.gia >= :giaMin) AND " +
            "(:giaMax IS NULL OR b.gia <= :giaMax)")
    List<BienTheSanPham> filterBienTheSanPham(String mauSac, String kichCo, BigDecimal giaMin, BigDecimal giaMax);
}