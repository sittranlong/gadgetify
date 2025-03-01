package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "BienTheSanPham")
@Data
public class BienTheSanPham {
    @Id
    @GeneratedValue
    @Column(name = "MaBienThe", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maBienThe;

    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanPham;

    @Column(name = "MauSac", length = 50)
    private String mauSac;

    @Column(name = "KichCo", length = 50)
    private String kichCo;

    @Column(name = "NguonGoc", length = 100)
    private String nguonGoc;

    @Column(name = "Gia", precision = 18, scale = 2)
    private BigDecimal gia;

    @Column(name = "SoLuongTonKho")
    private Integer soLuongTonKho;

    @Column(name = "HinhAnh", length = 255)
    private String hinhAnh;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;
}