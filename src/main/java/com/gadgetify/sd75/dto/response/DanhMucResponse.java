package com.gadgetify.sd75.dto.response;

import lombok.Data;
import java.util.UUID;

@Data
public class DanhMucResponse {
    private UUID maDanhMuc;
    private String tenDanhMuc;
    private String moTa;
    private Boolean trangThai;
}