package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class GioHangResponse {
    private UUID maGioHang;
    private List<ChiTietGioHangResponse> dsChiTietGioHang;
    private BigDecimal tongGiaTri;
}
