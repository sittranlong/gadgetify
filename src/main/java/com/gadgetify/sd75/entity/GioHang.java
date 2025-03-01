package com.gadgetify.sd75.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
@Data
public class GioHang {
    @Id
    @GeneratedValue
    @Column(name = "MaGioHang", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maGioHang;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private NguoiDung khachHang;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "SessionId", length = 100)
    private String sessionId;
}