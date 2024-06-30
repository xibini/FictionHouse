package io.github.xbn.noval.core.common.exception;

import io.github.xbn.noval.core.common.constant.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义业务异常，用于处理用户请求时，业务错误是抛出
 * @Author:向丙宁
 * @Package:io.github.xbn.noval.core.common.exception
 * @Project:noval
 * @Date:2024/6/30 20:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{
    private final ErrorCodeEnum errorCodeEnum;

    public BusinessException(ErrorCodeEnum errorCodeEnum){
        // 不调用父类 Throwable的fillInstackTrace() 方法生成栈追踪信息，提高应用性能
        // 构造器之间的调用必须在第一行
        super(errorCodeEnum.getMessage(), null, false, false);
        this.errorCodeEnum = errorCodeEnum;
    }
}
