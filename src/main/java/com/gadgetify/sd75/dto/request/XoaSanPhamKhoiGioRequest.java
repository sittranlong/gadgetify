package com.gadgetify.sd75.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class XoaSanPhamKhoiGioRequest {
    private UUID maChiTietGioHang; // ID chi tiết giỏ hàng cần xóa
}
