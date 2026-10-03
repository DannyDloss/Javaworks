// Excepción personalizada para operaciones inválidas en la calculadora.
// Extiende RuntimeException, así que es una excepción "unchecked":
// no es obligatorio declararla con "throws" en la firma del método.
public class IllegalOperationException extends RuntimeException {

    // Constructor simple: solo con mensaje
    public IllegalOperationException (String message) {
        super(message);
    }

    // Constructor con mensaje y causa (para el caso de división por cero)
    public IllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
