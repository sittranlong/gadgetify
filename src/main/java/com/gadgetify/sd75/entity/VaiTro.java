package com.gadgetify.sd75.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "VaiTro")
@Data
public class VaiTro {
    @Id
    @GeneratedValue
    @Column(name = "MaVaiTro", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID maVaiTro;

    @Column(name = "TenVaiTro", length = 50, unique = true)
    private String tenVaiTro;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @OneToMany(mappedBy = "vaiTro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NguoiDung> nguoidung;
}
