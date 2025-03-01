package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ThongBao")
@Data
public class ThongBao {
    @Id
    @GeneratedValue
    @Column(name = "MaThongBao", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maThongBao;

    @Column(name = "TieuDe", length = 255)
    private String tieuDe;

    @Column(name = "NoiDung", columnDefinition = "NVARCHAR(MAX)")
    private String noiDung;

    @Column(name = "NgayGui")
    private LocalDateTime ngayGui;

    @ManyToOne
    @JoinColumn(name = "NguoiNhan")
    private NguoiDung nguoiNhan;
}