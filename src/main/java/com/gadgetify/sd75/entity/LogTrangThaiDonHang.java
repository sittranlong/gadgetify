package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "LogTrangThaiDonHang")
@Data
public class LogTrangThaiDonHang {
    @Id
    @GeneratedValue
    @Column(name = "MaLog", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maLog;

    @ManyToOne
    @JoinColumn(name = "MaDonHang")
    private DonHang donHang;

    @Column(name = "TrangThaiCu", length = 50)
    private String trangThaiCu;

    @Column(name = "TrangThaiMoi", length = 50)
    private String trangThaiMoi;

    @Column(name = "NgayThayDoi")
    private LocalDateTime ngayThayDoi;

    @Column(name = "GhiChu", columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;
}