package com.gadgetify.sd75.mapper;

import com.gadgetify.sd75.dto.response.*;
import com.gadgetify.sd75.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring")
public interface GadgetifyMapper {
    // SanPham -> ChiTietSanPhamResponse
    @Mapping(source = "maSanPham", target = "maSanPham")
    @Mapping(source = "tenSanPham", target = "tenSanPham")
    @Mapping(source = "moTa", target = "moTa")
    @Mapping(source = "hinhAnh", target = "hinhAnh")
    ChiTietSanPhamResponse toChiTietSanPhamResponse(SanPham sanPham);

    List<ChiTietSanPhamResponse> toDsChiTietSanPhamResponse(List<SanPham> dsSanPham);

    // BienTheSanPham -> BienTheSanPhamResponse
    @Mapping(source = "maBienThe", target = "maBienThe")
    @Mapping(source = "mauSac", target = "mauSac")
    @Mapping(source = "kichCo", target = "kichCo")
    @Mapping(source = "nguonGoc", target = "nguonGoc")
    @Mapping(source = "gia", target = "gia")
    @Mapping(source = "soLuongTonKho", target = "soLuongTonKho")
    @Mapping(source = "hinhAnh", target = "hinhAnh")
    @Mapping(source = "trangThai", target = "trangThai")
    BienTheSanPhamResponse toBienTheSanPhamResponse(BienTheSanPham bienTheSanPham);

    List<BienTheSanPhamResponse> toDsBienTheSanPhamResponse(List<BienTheSanPham> dsBienTheSanPham);

    // DanhMuc -> DanhMucResponse
    @Mapping(source = "maDanhMuc", target = "maDanhMuc")
    @Mapping(source = "tenDanhMuc", target = "tenDanhMuc")
    @Mapping(source = "moTa", target = "moTa")
    @Mapping(source = "trangThai", target = "trangThai")
    DanhMucResponse toDanhMucResponse(DanhMuc danhMuc);

    List<DanhMucResponse> toDsDanhMucResponse(List<DanhMuc> dsDanhMuc);

    // KhuyenMai -> KhuyenMaiResponse
    @Mapping(source = "maKhuyenMai", target = "maKhuyenMai")
    @Mapping(source = "tenKhuyenMai", target = "tenKhuyenMai")
    @Mapping(source = "moTa", target = "moTa")
    @Mapping(source = "ngayBatDau", target = "ngayBatDau")
    @Mapping(source = "ngayKetThuc", target = "ngayKetThuc")
    @Mapping(source = "trangThai", target = "trangThai")
    KhuyenMaiResponse toKhuyenMaiResponse(KhuyenMai khuyenMai);

    List<KhuyenMaiResponse> toDsKhuyenMaiResponse(List<KhuyenMai> dsKhuyenMai);

    // GioHang -> GioHangResponse
    @Mapping(source = "maGioHang", target = "maGioHang")
    GioHangResponse toGioHangResponse(GioHang gioHang);

    // ChiTietGioHang -> ChiTietGioHangResponse
    @Mapping(source = "maChiTietGioHang", target = "maChiTietGioHang")
    @Mapping(source = "bienTheSanPham", target = "bienTheSanPham")
    @Mapping(source = "soLuong", target = "soLuong")
    ChiTietGioHangResponse toChiTietGioHangResponse(ChiTietGioHang chiTietGioHang);

    List<ChiTietGioHangResponse> toDsChiTietGioHangResponse(List<ChiTietGioHang> dsChiTietGioHang);

    // NguoiDung -> DangKyResponse
    @Mapping(source = "maNguoiDung", target = "maNguoiDung")
    @Mapping(source = "email", target = "email")
    DangKyResponse toDangKyResponse(NguoiDung nguoiDung);

    // NguoiDung -> DangNhapResponse
    @Mapping(source = "maNguoiDung", target = "maNguoiDung")
    @Mapping(source = "tenNguoiDung", target = "tenNguoiDung")
    @Mapping(source = "vaiTro", target = "vaiTro")
    DangNhapResponse toDangNhapResponse(NguoiDung nguoiDung);

    // DonHang -> DonHangResponse
    @Mapping(source = "maDonHang", target = "maDonHang")
    @Mapping(source = "ngayDatHang", target = "ngayDatHang")
    @Mapping(source = "tongTien", target = "tongTien")
    @Mapping(source = "phuongThucThanhToan", target = "phuongThucThanhToan")
    @Mapping(source = "trangThai", target = "trangThai")
    @Mapping(source = "diaChiGiaoHang", target = "diaChiGiaoHang")
    @Mapping(source = "phiVanChuyen", target = "phiVanChuyen")
    @Mapping(source = "ghiChu", target = "ghiChu")
    @Mapping(source = "maVanChuyen", target = "maVanChuyen")
    DonHangResponse toDonHangResponse(DonHang donHang);

    List<DonHangResponse> toDsDonHangResponse(List<DonHang> dsDonHang);

    // ChiTietDonHang -> ChiTietDonHangResponse
    @Mapping(source = "maChiTietDonHang", target = "maChiTietDonHang")
    @Mapping(source = "bienTheSanPham", target = "bienTheSanPham")
    @Mapping(source = "soLuong", target = "soLuong")
    @Mapping(source = "gia", target = "gia")
    @Mapping(source = "thanhTien", target = "thanhTien")
    ChiTietDonHangResponse toChiTietDonHangResponse(ChiTietDonHang chiTietDonHang);

    List<ChiTietDonHangResponse> toDsChiTietDonHangResponse(List<ChiTietDonHang> dsChiTietDonHang);
}

