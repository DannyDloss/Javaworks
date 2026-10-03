public class LogLine {

    // Enum con los niveles de log, cada uno con su código de 3 letras
    // y su valor codificado (usado en el formato corto)
    public enum LogLevel {
        TRACE("TRC", 1),
        DEBUG("DBG", 2),
        INFO("INF", 4),
        WARNING("WRN", 5),
        ERROR("ERR", 6),
        FATAL("FTL", 42),
        UNKNOWN("", 0); // se usa cuando no reconocemos el código

        private final String code;
        private final int encodedValue;

        LogLevel(String code, int encodedValue) {
            this.code = code;
            this.encodedValue = encodedValue;
        }

        public int getEncodedValue() {
            return encodedValue;
        }

        // Busca el LogLevel que corresponde a un código de 3 letras (ej. "INF")
        // Si no lo encuentra, devuelve UNKNOWN
        public static LogLevel fromCode(String code) {
            for (LogLevel level : LogLevel.values()) {
                if (level.code.equals(code)) {
                    return level;
                }
            }
            return UNKNOWN;
        }
    }

    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    // Extrae el código de nivel (ej. "INF") de dentro de los corchetes
    private String extractLevelCode() {
        String[] parts = logLine.split(":", 2); // ["[INF]", " File deleted"]
        String levelPart = parts[0];
        return levelPart.replace("[", "").replace("]", "");
    }

    // Extrae el mensaje, sin espacios extra al inicio/final
    private String extractMessage() {
        String[] parts = logLine.split(":", 2);
        return parts[1].trim();
    }

    // 1 y 2. Devuelve el LogLevel de la línea (o UNKNOWN si no se reconoce)
    public LogLevel getLogLevel() {
        String code = extractLevelCode();
        return LogLevel.fromCode(code);
    }

    // 3. Devuelve la línea en formato corto: "<ENCODED_LEVEL>:<MENSAJE>"
    public String getOutputForShortLog() {
        int encodedValue = getLogLevel().getEncodedValue();
        String message = extractMessage();
        return encodedValue + ":" + message;
    }

    public static void main(String[] args) {
        LogLine logLine1 = new LogLine("[INF]: File deleted");
        System.out.println("getLogLevel(): " + logLine1.getLogLevel()); // INFO

        LogLine logLine2 = new LogLine("[XYZ]: Overly specific, out of context message");
        System.out.println("getLogLevel() desconocido: " + logLine2.getLogLevel()); // UNKNOWN

        LogLine logLine3 = new LogLine("[ERR]: Stack Overflow");
        System.out.println("getOutputForShortLog(): " + logLine3.getOutputForShortLog()); // 6:Stack Overflow

        LogLine logLine4 = new LogLine("[FTL]: System crashed");
        System.out.println("getOutputForShortLog() FATAL: " + logLine4.getOutputForShortLog()); // 42:System crashed
    }
}
