package cn.yinjiahui.group_purchase.common;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum SystemErrorType implements ErrorType {

    SUCCESS(0, "成功"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    SYSTEM_ERROR(10001, "系统异常");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
