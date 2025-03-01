package com.gadgetify.sd75.dto.request;


import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TimKiemLocRequest {
    private String tuKhoa;         // Từ khóa tìm kiếm
    private UUID maDanhMuc;       // ID danh mục
    private BigDecimal giaToiThieu; // Giá tối thiểu
    private BigDecimal giaToiDa;    // Giá tối đa
    private String mauSac;         // Màu sắc
    private String kichCo;         // Kích cỡ
}