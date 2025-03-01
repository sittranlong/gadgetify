package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TicketHoTro")
@Data
public class TicketHoTro {
    @Id
    @GeneratedValue
    @Column(name = "MaTicket", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maTicket;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private NguoiDung khachHang;

    @Column(name = "TieuDe", length = 255)
    private String tieuDe;

    @Column(name = "NoiDung", columnDefinition = "NVARCHAR(MAX)")
    private String noiDung;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;
}