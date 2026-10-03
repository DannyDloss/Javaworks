public class CalculatorConundrum {

    // 1. Calcula el resultado y devuelve el texto formateado, ej: "16 + 51 = 67"
    public String calculate(int operand1, int operand2, String operation) {

        // 2. Validaciones de operación inválida
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int result;

        switch (operation) {
            case "+":
                result = add(operand1, operand2);
                break;

            case "*":
                result = multiply(operand1, operand2);
                break;

            case "/":
                // 3. Manejamos la división por cero aquí mismo
                try {
                    result = divide(operand1, operand2);
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
                break;

            default:
                // Cualquier otra operación que no sea +, * o /
                throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return operand1 + " " + operation + " " + operand2 + " = " + result;
    }

    // Métodos básicos de cálculo (como indica el enunciado, "provided")
    private int add(int a, int b) {
        return a + b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b; // esto lanza ArithmeticException si b == 0
    }

    public static void main(String[] args) {
        CalculatorConundrum calculator = new CalculatorConundrum();

        // Casos normales
        System.out.println(calculator.calculate(16, 51, "+")); 
        System.out.println(calculator.calculate(32, 6, "*"));  
        System.out.println(calculator.calculate(512, 4, "/")); 

        // Operación null
        try {
            calculator.calculate(10, 1, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage()); // Operation cannot be null
        }

        // Operación vacía
        try {
            calculator.calculate(10, 1, "");
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage()); // Operation cannot be empty
        }

        // Operación que no existe
        try {
            calculator.calculate(10, 1, "-");
        } catch (IllegalOperationException e) {
            System.out.println("Error esperado: " + e.getMessage()); // Operation '-' does not exist
        }

        //División por cero 
        try {
            calculator.calculate(512, 0, "/");
        } catch (IllegalOperationException e) {
            System.out.println("Error esperado: " + e.getMessage()); // Division by zero is not allowed
            System.out.println("Causa original: " + e.getCause()); // java.lang.ArithmeticException: / by zero
        }
    }
}
