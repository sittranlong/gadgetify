package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class DangKyResponse {
    private UUID maNguoiDung;
    private String email;
    private String thongBao; // Ví dụ: "Vui lòng kiểm tra email để xác minh tài khoản"
}
