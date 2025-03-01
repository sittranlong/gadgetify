package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BienTheSanPhamResponse {
    private UUID maBienThe;
    private String mauSac;
    private String kichCo;
    private String nguonGoc;
    private BigDecimal gia;
    private int soLuongTonKho;
    private String hinhAnh;
    private Boolean trangThai;
}
