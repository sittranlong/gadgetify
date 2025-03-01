package com.gadgetify.sd75.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ChiTietDonHangResponse {
    private UUID maChiTietDonHang;
    private BienTheSanPhamResponse bienTheSanPham;
    private int soLuong;
    private BigDecimal gia;
    private BigDecimal thanhTien;
}
