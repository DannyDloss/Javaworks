public class CarsAssemble {

    // Cantidad de carros producidos por hora a velocidad 1 (100% de éxito)
    private static final double CARS_PER_HOUR_AT_SPEED_1 = 221;

    // 1. Calcula la producción por hora, tomando en cuenta la tasa de éxito
    public static double productionRatePerHour(int speed) {
        double successRate = getSuccessRate(speed);
        double basicProductionRate = speed * CARS_PER_HOUR_AT_SPEED_1;

        return basicProductionRate * successRate;
    }

    // 2. Calcula cuántos carros SIN fallas se producen por minuto
    public static int workingItemsPerMinute(int speed) {
        double perHour = productionRatePerHour(speed);
        double perMinute = perHour / 60;

        return (int) perMinute; // conversión explícita: se descartan los decimales
    }

    // Método auxiliar: devuelve la tasa de éxito según la velocidad
    private static double getSuccessRate(int speed) {
        if (speed >= 1 && speed <= 4) {
            return 1.0; // 100%
        } else if (speed >= 5 && speed <= 8) {
            return 0.9; // 90%
        } else if (speed == 9) {
            return 0.8; // 80%
        } else if (speed == 10) {
            return 0.77; // 77%
        } else {
            return 0.0; // velocidad 0 (apagado) u otro valor inválido
        }
    }

    public static void main(String[] args) {
        System.out.println("productionRatePerHour(6): " + productionRatePerHour(6)); // 1193.4
        System.out.println("workingItemsPerMinute(6): " + workingItemsPerMinute(6)); // 19
    }
}
