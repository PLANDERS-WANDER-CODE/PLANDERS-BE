package planders.backend.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(final BadRequestException e) {
        log.warn(e.getMessage());

        return createErrorResponse(e.getErrorCode());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> unauthorizedExceptionHandler(final UnauthorizedException e) {
        log.warn(e.getMessage());

        return createErrorResponse(e.getErrorCode());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> forbiddenExceptionHandler(final UnauthorizedException e) {
        log.warn(e.getMessage());

        return createErrorResponse(e.getErrorCode());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> unhandledExceptionHandler(final Exception e) {
        log.error("Unhandled exception occurred: {}", e.getMessage(), e);

        return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse("Internal server error. Please try again later."));
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ErrorResponse(errorCode));
    }
}
