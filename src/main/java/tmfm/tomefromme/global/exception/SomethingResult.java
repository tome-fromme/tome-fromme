package tmfm.tomefromme.global.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SomethingResult {
    
    private final Integer errorCode;
    private final String errorMessage;

    @Builder
    public SomethingResult(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
