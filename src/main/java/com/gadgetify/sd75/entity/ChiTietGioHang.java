package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "ChiTietGioHang")
@Data
public class ChiTietGioHang {
    @Id
    @GeneratedValue
    @Column(name = "MaChiTietGioHang", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maChiTietGioHang;

    @ManyToOne
    @JoinColumn(name = "MaGioHang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "MaBienThe")
    private BienTheSanPham bienTheSanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;
}