package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "MaGiamGia")
@Data
public class MaGiamGia {
    @Id
    @GeneratedValue
    @Column(name = "MaGiamGia", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maGiamGia;

    @Column(name = "TenMaGiamGia", length = 100)
    private String tenMaGiamGia;

    @Column(name = "GiaTriGiam", precision = 18, scale = 2)
    private BigDecimal giaTriGiam;

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