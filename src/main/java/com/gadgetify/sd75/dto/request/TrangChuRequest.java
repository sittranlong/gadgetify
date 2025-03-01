package com.gadgetify.sd75.dto.request;


import lombok.Data;

@Data
public class TrangChuRequest {
    private int gioiHanSanPhamMoi; // Giới hạn số lượng sản phẩm mới
    private int gioiHanKhuyenMai;  // Giới hạn số lượng khuyến mãi
}