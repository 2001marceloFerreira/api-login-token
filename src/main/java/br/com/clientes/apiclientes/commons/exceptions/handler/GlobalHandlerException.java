package br.com.clientes.apiclientes.commons.exceptions.handler;

import br.com.clientes.apiclientes.commons.exceptions.*;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handlerNotFoundException(
            NotFoundException notFoundException) {
        return createProblemDetail(notFoundException, NOT_FOUND, null,
                "Não encontrado", null,
                Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(TooManyRequestsException.class)
    public ProblemDetail handlerTooManyRequestsException(
            TooManyRequestsException tooManyRequestsException) {
        return createProblemDetail(tooManyRequestsException, TOO_MANY_REQUESTS,
                null, "Muitas solicitações", null,
                Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handlerBadRequestException(
            BadRequestException badRequestException) {
        return createProblemDetail(badRequestException, BAD_REQUEST, null,
                "Corpo de requisição inválido", null,
                Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(ForbiddenException.class)
    public ProblemDetail handlerForbiddenException(
            ForbiddenException forbiddenException) {
        return createProblemDetail(forbiddenException, FORBIDDEN, null,
                "Service Unavailable", null,
                Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ProblemDetail handlerUnauthorizedException(
            UnauthorizedException unauthorizedException) {
        return createProblemDetail(unauthorizedException, UNAUTHORIZED, null,
                "Service Unavailable", null,
                Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(ClienteException.class)
    public ProblemDetail handlerClienteException(
            ClienteException jornadaException) {
        return createProblemDetail(jornadaException, SERVICE_UNAVAILABLE, null,
                "Service Unavailable", null,
                Map.of("timestamp", LocalDateTime.now()));
    }


    private ProblemDetail createProblemDetail(Throwable exception,
                                              HttpStatus status,
                                              @Nullable URI type,
                                              @Nullable String title,
                                              @Nullable URI instance, @Nullable
                                              Map<String, Object> properties) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,
                exception.getMessage());
        if (title != null)
            problemDetail.setTitle(title);
        if (type != null)
            problemDetail.setType(type);
        if (instance != null)
            problemDetail.setInstance(instance);
        if (properties != null && !properties.isEmpty()) {
            properties.forEach(problemDetail::setProperty);
        }
        return problemDetail;
    }

}
