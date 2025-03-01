package com.gadgetify.sd75.controller;

import com.gadgetify.sd75.dto.request.DangKyRequest;
import com.gadgetify.sd75.dto.response.BaseResponse;
import com.gadgetify.sd75.dto.response.DangKyResponse;
import com.gadgetify.sd75.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private KhachHangService khachHangService;

    @PostMapping("/register")
    public ResponseEntity<DangKyResponse> registerUser(@RequestBody DangKyRequest request) {
        DangKyResponse response = khachHangService.dangKy(request);
        return ResponseEntity.ok(response);
    }
}
