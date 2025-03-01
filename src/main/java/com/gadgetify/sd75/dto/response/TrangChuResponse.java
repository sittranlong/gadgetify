package com.gadgetify.sd75.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class TrangChuResponse {
    private List<ChiTietSanPhamResponse> dsSanPhamMoi;
    private List<KhuyenMaiResponse> dsKhuyenMai;
}