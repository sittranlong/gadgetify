package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "NguoiDung")
@Data
public class NguoiDung {
    @Id
    @GeneratedValue
    @Column(name = "MaNguoiDung", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maNguoiDung;

    @Column(name = "TenNguoiDung", length = 100)
    private String tenNguoiDung;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "MatKhau", length = 255)
    private String matKhau;

    @Column(name = "SoDienThoai", length = 20)
    private String soDienThoai;

    @Column(name = "DiaChi", length = 255)
    private String diaChi;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "Provider", length = 50)
    private String provider;

    @Column(name = "ProviderId", length = 100)
    private String providerId;


    @ManyToOne
    @JoinColumn(name = "MaVaiTro", nullable = false)
    private VaiTro vaiTro;

    @Column(name = "MaXacMinh", length = 6)
    private String maXacMinh;

    @Column(name = "LoaiMaXacMinh", length = 20)
    private String loaiMaXacMinh;

    @Column(name = "ThoiGianHetHanMaXacMinh")
    private LocalDateTime thoiGianHetHanMaXacMinh;
}