package com.gadgetify.sd75.dto.response;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class ChiTietSanPhamResponse {
    private UUID maSanPham;
    private String tenSanPham;
    private String moTa;
    private String hinhAnh;
    private List<BienTheSanPhamResponse> dsBienThe;
}

