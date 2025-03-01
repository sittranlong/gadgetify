package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietKhuyenMai")
@Data
public class ChiTietKhuyenMai {
    @Id
    @GeneratedValue
    @Column(name = "MaChiTietKhuyenMai", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maChiTietKhuyenMai;

    @ManyToOne
    @JoinColumn(name = "MaKhuyenMai")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanPham;

    @Column(name = "GiamGia", precision = 18, scale = 2)
    private BigDecimal giamGia;
}