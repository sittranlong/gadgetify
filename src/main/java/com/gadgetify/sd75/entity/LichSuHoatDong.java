package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "LichSuHoatDong")
@Data
public class LichSuHoatDong {
    @Id
    @GeneratedValue
    @Column(name = "MaHoatDong", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maHoatDong;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private NguoiDung khachHang;

    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanPham;

    @Column(name = "LoaiHoatDong", length = 50)
    private String loaiHoatDong;

    @Column(name = "NgayHoatDong")
    private LocalDateTime ngayHoatDong;
}