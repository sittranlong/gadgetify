package com.gadgetify.sd75.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CapNhatGioHangRequest {
    private UUID maChiTietGioHang; // ID chi tiết giỏ hàng cần cập nhật
    private int soLuong;           // Số lượng mới
}
