package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "YeuCauDoiTra")
@Data
public class YeuCauDoiTra {
    @Id
    @GeneratedValue
    @Column(name = "MaYeuCau", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maYeuCau;

    @ManyToOne
    @JoinColumn(name = "MaDonHang")
    private DonHang donHang;

    @Column(name = "LyDo", columnDefinition = "NVARCHAR(MAX)")
    private String lyDo;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "NgayYeuCau")
    private LocalDateTime ngayYeuCau;

    @Column(name = "NgayXuLy")
    private LocalDateTime ngayXuLy;

    @Column(name = "GhiChu", columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;
}