package com.gadgetify.sd75.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class LichSuMuaHangResponse {

        private List<DonHangResponse> dsDonHang;
        private int trangHienTai;    // Trang hiện tại
        private int tongSoTrang;     // Tổng số trang
        private long tongSoPhanTu;   // Tổng số đơn hàng
        private int kichThuocTrang;  // Số phần tử trên mỗi trang

}
