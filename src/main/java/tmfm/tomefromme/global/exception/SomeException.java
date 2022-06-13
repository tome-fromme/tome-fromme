package tmfm.tomefromme.global.exception;

import lombok.Getter;

@Getter
public class SomeException extends RuntimeException {
    
    private final String errorMessage;
    private final Integer errorCode;

    public SomeException(String errorMessage, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
    
}
