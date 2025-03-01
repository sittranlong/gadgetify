package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DanhMuc")
@Data
public class DanhMuc {
    @Id
    @GeneratedValue
    @Column(name = "MaDanhMuc", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maDanhMuc;

    @Column(name = "TenDanhMuc", length = 100)
    private String tenDanhMuc;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;
}