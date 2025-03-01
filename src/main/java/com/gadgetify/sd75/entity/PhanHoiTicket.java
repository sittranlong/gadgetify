package com.gadgetify.sd75.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PhanHoiTicket")
@Data
public class PhanHoiTicket {
    @Id
    @GeneratedValue
    @Column(name = "MaPhanHoi", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maPhanHoi;

    @ManyToOne
    @JoinColumn(name = "MaTicket")
    private TicketHoTro ticket;

    @Column(name = "NoiDungPhanHoi", columnDefinition = "NVARCHAR(MAX)")
    private String noiDungPhanHoi;

    @ManyToOne
    @JoinColumn(name = "NguoiPhanHoi")
    private NguoiDung nguoiPhanHoi;

    @Column(name = "NgayPhanHoi")
    private LocalDateTime ngayPhanHoi;
}