package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Data
public class SanPham {
    @Id
    @GeneratedValue
    @Column(name = "MaSanPham", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maSanPham;

    @Column(name = "TenSanPham", length = 255)
    private String tenSanPham;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "MaDanhMuc")
    private DanhMuc danhMuc;

    @Column(name = "HinhAnh", length = 255)
    private String hinhAnh;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;
}