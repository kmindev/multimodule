package dev.be.module_api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.module_common.enums.CodeEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommonResponse<T>(
        String returnCode,
        String returnMessage,
        T info
) {

    public static CommonResponse<Void> of(CodeEnum codeEnum) {
        return new CommonResponse<>(
                codeEnum.getCode(),
                codeEnum.getMessage(),
                null
        );
    }

    public static CommonResponse<Void> of(String returnCode, String returnMessage) {
        return new CommonResponse<>(
                returnCode,
                returnMessage,
                null
        );
    }

    public static <T> CommonResponse<T> of(T info) {
        return new CommonResponse<>(
                CodeEnum.SUCCESS.getCode(),
                CodeEnum.SUCCESS.getMessage(),
                info
        );
    }

}
