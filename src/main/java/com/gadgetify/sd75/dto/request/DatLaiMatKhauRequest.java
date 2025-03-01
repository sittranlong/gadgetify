package com.gadgetify.sd75.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class DatLaiMatKhauRequest {
    private UUID maNguoiDung;
    private String maXacMinh; // Mã gửi qua email để reset
    private String matKhauMoi;
}
