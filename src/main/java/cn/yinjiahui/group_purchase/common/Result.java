package cn.yinjiahui.group_purchase.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static cn.yinjiahui.group_purchase.common.SystemErrorType.SUCCESS;


@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
@NoArgsConstructor
public class Result<T> {

    @ApiModelProperty(value = "code", required = true)
    private Integer code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String msg;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.msg = errorType.getMsg();
    }

    public Result(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, data);
    }

    public static <T> Result<T> success() {
        return new Result<>(SUCCESS);
    }


    public static <T> Result<T> fail() {
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }

    public static <T> Result<T> fail(BaseException baseException) {
        return fail(baseException, null);
    }


    public static <T> Result<T> fail(BaseException baseException, T data) {
        return new Result<>(baseException.getErrorType(), data);
    }

    public static <T> Result<T> fail(ErrorType errorType, T data) {
        return new Result<>(errorType, data);
    }


    public static <T> Result<T> fail(ErrorType errorType) {
        return Result.fail(errorType, null);
    }


    public static <T> Result<T> fail(T data) {
        return new Result<>(SystemErrorType.SYSTEM_ERROR, data);
    }

    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(SystemErrorType.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(SystemErrorType.UNAUTHORIZED.getCode(), SystemErrorType.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(SystemErrorType.FORBIDDEN.getCode(), SystemErrorType.FORBIDDEN.getMsg(), data);
    }
}
