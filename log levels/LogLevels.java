public class LogLevels {

    // 1. Obtiene el mensaje de la línea de log (sin espacios extra)
    public static String message(String logLine) {
        String[] parts = logLine.split(":", 2); // separa en 2 partes: "[LEVEL]" y " mensaje"
        String messagePart = parts[1];
        return messagePart.trim(); // quita espacios y saltos de línea al inicio/final
    }

    // 2. Obtiene el nivel del log en minúscula
    public static String logLevel(String logLine) {
        String[] parts = logLine.split(":", 2);
        String levelPart = parts[0]; // ejemplo: "[ERROR]"

        // quitamos los corchetes [ ]
        String levelWithoutBrackets = levelPart.replace("[", "").replace("]", "");

        return levelWithoutBrackets.toLowerCase();
    }

    // 3. Reformatea la línea: "mensaje (nivel)"
    public static String reformat(String logLine) {
        String msg = message(logLine);
        String level = logLevel(logLine);

        return msg + " (" + level + ")";
    }

    public static void main(String[] args) {
        System.out.println("message: " + message("[ERROR]: Invalid operation")); // Invalid operation

        System.out.println("message con espacios: ["
                + message("[WARNING]:  Disk almost full\r\n") + "]"); // Disk almost full

        System.out.println("logLevel: " + logLevel("[ERROR]: Invalid operation")); // error

        System.out.println("reformat: " + reformat("[INFO]: Operation completed")); // Operation completed (info)
    }
}
