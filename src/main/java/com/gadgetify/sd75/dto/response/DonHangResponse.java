package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class DonHangResponse {
    private UUID maDonHang;
    private LocalDateTime ngayDatHang;
    private BigDecimal tongTien;
    private String phuongThucThanhToan;
    private String trangThai;
    private String diaChiGiaoHang;
    private BigDecimal phiVanChuyen;
    private String ghiChu;
    private String maVanChuyen;
    private List<ChiTietDonHangResponse> dsChiTietDonHang;
}
