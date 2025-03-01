package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class DangNhapResponse {
    private String token; // JWT token
    private UUID maNguoiDung;
    private String tenNguoiDung;
    private String vaiTro;
}
