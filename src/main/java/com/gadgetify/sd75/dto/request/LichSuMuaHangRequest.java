package com.gadgetify.sd75.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class LichSuMuaHangRequest {
    private UUID maNguoiDung; // ID người dùng để lấy lịch sử mua hàng
    private int page;         // Số trang (bắt đầu từ 0)
    private int size;         // Kích thước trang
}