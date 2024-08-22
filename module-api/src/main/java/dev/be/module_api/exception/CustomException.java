package dev.be.module_api.exception;

import dev.be.module_common.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private String returnCode;
    private String returnMessage;

    public CustomException(CodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.returnCode = codeEnum.getCode();
        this.returnMessage = codeEnum.getMessage();
    }

}
