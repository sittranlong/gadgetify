package com.gadgetify.sd75.enums;

public enum ResponseCode {
    SUCCESS(200, "Thành công"),
    BAD_REQUEST(400, "Yêu cầu không hợp lệ"),
    NOT_FOUND(404, "Không tìm thấy"),
    INTERNAL_SERVER_ERROR(500, "Lỗi máy chủ"),
    FORBIDDEN(403,"Không có quyền truy cập");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

