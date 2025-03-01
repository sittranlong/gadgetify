package com.gadgetify.sd75.service;


import com.gadgetify.sd75.dto.request.*;
import com.gadgetify.sd75.dto.response.*;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    TrangChuResponse layTrangChu(TrangChuRequest request);
    TimKiemLocResponse timKiemVaLocSanPham(TimKiemLocRequest request);
    List<DanhMucResponse> layTatCaDanhMuc();
    ChiTietSanPhamResponse layChiTietSanPham(UUID maSanPham);
    void themVaoGioHang(ThemVaoGioHangRequest request);
    GioHangResponse layGioHang(UUID maNguoiDung, String sessionId);
    void capNhatGioHang(CapNhatGioHangRequest request);
    void xoaSanPhamKhoiGio(XoaSanPhamKhoiGioRequest request);
    void xoaGioHangHetHan();

    DangKyResponse dangKy(DangKyRequest request);
    void xacMinhTaiKhoan(XacMinhTaiKhoanRequest request);
    DangNhapResponse dangNhap(DangNhapRequest request);
    void dangXuat(String token); // Đơn giản hóa: không cần logic phức tạp
    void khoiPhucMatKhau(KhoiPhucMatKhauRequest request);
    void datLaiMatKhau(DatLaiMatKhauRequest request);

    LichSuMuaHangResponse xemLichSuMuaHang(LichSuMuaHangRequest request);
}