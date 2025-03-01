package com.gadgetify.sd75.dto.request;

import lombok.Data;
import java.util.UUID;

@Data
public class ThemVaoGioHangRequest {
    private UUID maBienTheSanPham; // ID biến thể sản phẩm
    private int soLuong;           // Số lượng
    private UUID maNguoiDung;      // ID người dùng (nếu đăng nhập)
    private String sessionId;      // Session ID (nếu chưa đăng nhập)
}