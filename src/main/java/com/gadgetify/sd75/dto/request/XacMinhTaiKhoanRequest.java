package com.gadgetify.sd75.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class XacMinhTaiKhoanRequest {
    private UUID maNguoiDung;
    private String maXacMinh; // Mã xác minh gửi qua email
}
