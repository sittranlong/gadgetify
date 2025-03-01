package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ChiTietGioHangResponse {
    private UUID maChiTietGioHang;
    private BienTheSanPhamResponse bienTheSanPham;
    private int soLuong;
    private BigDecimal thanhTien; // Giá của biến thể * số lượng
}
