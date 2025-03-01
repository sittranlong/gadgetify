package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ThanhToan")
@Data
public class ThanhToan {
    @Id
    @GeneratedValue
    @Column(name = "MaThanhToan", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maThanhToan;

    @ManyToOne
    @JoinColumn(name = "MaDonHang")
    private DonHang donHang;

    @Column(name = "PhuongThucThanhToan", length = 50)
    private String phuongThucThanhToan;

    @Column(name = "SoTien", precision = 18, scale = 2)
    private BigDecimal soTien;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "NgayThanhToan")
    private LocalDateTime ngayThanhToan;
}