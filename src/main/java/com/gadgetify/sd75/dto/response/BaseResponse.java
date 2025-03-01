package com.gadgetify.sd75.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private int trangThai;
    private String thongBao;
    private T duLieu;
}
