package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "BaoCaoNhanVien")
@Data
public class BaoCaoNhanVien {
    @Id
    @GeneratedValue
    @Column(name = "MaBaoCao", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maBaoCao;

    @ManyToOne
    @JoinColumn(name = "MaNhanVien")
    private NguoiDung nhanVien;

    @Column(name = "NgayBaoCao")
    private LocalDate ngayBaoCao;

    @Column(name = "DoanhThu", precision = 18, scale = 2)
    private BigDecimal doanhThu;

    @Column(name = "SoLuongSanPham")
    private Integer soLuongSanPham;
}