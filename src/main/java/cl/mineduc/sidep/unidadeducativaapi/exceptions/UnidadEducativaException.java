package cl.mineduc.sidep.unidadeducativaapi.exceptions;

public class UnidadEducativaException extends RuntimeException {

    public UnidadEducativaException() {
        super();
    }

    public UnidadEducativaException(String message) {
        super(message);
    }

    public UnidadEducativaException(String message, Throwable cause) {
        super(message, cause);
    }

}
