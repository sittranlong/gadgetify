package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DonHang")
@Data
public class DonHang {
    @Id
    @GeneratedValue
    @Column(name = "MaDonHang", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maDonHang;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private NguoiDung khachHang;

    @Column(name = "NgayDatHang")
    private LocalDateTime ngayDatHang;

    @Column(name = "TongTien", precision = 18, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "PhuongThucThanhToan", length = 50)
    private String phuongThucThanhToan;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "DiaChiGiaoHang", length = 255)
    private String diaChiGiaoHang;

    @Column(name = "PhiVanChuyen", precision = 18, scale = 2)
    private BigDecimal phiVanChuyen;

    @Column(name = "GhiChu", columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "MaVanChuyen", length = 50)
    private String maVanChuyen;
}
