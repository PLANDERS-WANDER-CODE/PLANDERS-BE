package planders.backend.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final HttpStatus status;
    private final String code;
    private final String message;


    public ErrorResponse(ErrorCode errorCode) {
        this(errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage());
    }

    public ErrorResponse(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "UNKNOWN_ERROR", message);
    }
}
