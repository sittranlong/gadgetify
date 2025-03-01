package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietDonHang")
@Data
public class ChiTietDonHang {
    @Id
    @GeneratedValue
    @Column(name = "MaChiTietDonHang", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maChiTietDonHang;

    @ManyToOne
    @JoinColumn(name = "MaDonHang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "MaBienThe")
    private BienTheSanPham bienTheSanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "Gia", precision = 18, scale = 2)
    private BigDecimal gia;

    @Column(name = "ThanhTien", precision = 18, scale = 2)
    private BigDecimal thanhTien;
}