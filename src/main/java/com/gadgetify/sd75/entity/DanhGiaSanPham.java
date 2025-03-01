package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DanhGiaSanPham")
@Data
public class DanhGiaSanPham {
    @Id
    @GeneratedValue
    @Column(name = "MaDanhGia", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maDanhGia;

    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private NguoiDung khachHang;

    @Column(name = "DiemDanhGia")
    private Integer diemDanhGia;

    @Column(name = "NhanXet", columnDefinition = "NVARCHAR(MAX)")
    private String nhanXet;

    @Column(name = "NgayDanhGia")
    private LocalDateTime ngayDanhGia;
}