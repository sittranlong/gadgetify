package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Data
public class HoaDon {
    @Id
    @GeneratedValue
    @Column(name = "MaHoaDon", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maHoaDon;

    @ManyToOne
    @JoinColumn(name = "MaDonHang")
    private DonHang donHang;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "TongTien", precision = 18, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;
}