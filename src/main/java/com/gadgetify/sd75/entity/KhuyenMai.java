package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "KhuyenMai")
@Data
public class KhuyenMai {
    @Id
    @GeneratedValue
    @Column(name = "MaKhuyenMai", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maKhuyenMai;

    @Column(name = "TenKhuyenMai", length = 100)
    private String tenKhuyenMai;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(name = "NgayBatDau")
    private LocalDateTime ngayBatDau;

    @Column(name = "NgayKetThuc")
    private LocalDateTime ngayKetThuc;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;
}