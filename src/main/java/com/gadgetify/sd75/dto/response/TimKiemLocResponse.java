package com.gadgetify.sd75.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class TimKiemLocResponse {
    private List<BienTheSanPhamResponse> dsSanPham;
}