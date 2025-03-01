package com.gadgetify.sd75.dto.response;


import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class KhuyenMaiResponse {
    private UUID maKhuyenMai;
    private String tenKhuyenMai;
    private String moTa;
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
    private Boolean trangThai;
}