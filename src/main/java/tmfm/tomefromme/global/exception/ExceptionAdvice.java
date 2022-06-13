package tmfm.tomefromme.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(SomeException.class)
    public ResponseEntity exHandle(SomeException ex) {
        SomethingResult se = SomethingResult.builder()
                .errorCode(ex.getErrorCode())
                .errorMessage(ex.getErrorMessage())
                .build();
        
        return ResponseEntity.status(ex.getHttpStatus()).body(se);
    }

    @ExceptionHandler(Exception.class)
    public void exHandle2(Exception ex) {
        //체크 예외는 즉시 핸들링 하기
    }

}
