public class Lasagna {

    // Tiempo esperado en el horno (en minutos), según el libro de cocina
    private static final int EXPECTED_MINUTES_IN_OVEN = 40;

    // Tiempo que toma preparar cada capa de la lasaña (en minutos)
    private static final int PREPARATION_TIME_PER_LAYER = 2;

    // 1. Devuelve el tiempo esperado en el horno
    public int expectedMinutesInOven() {
        return EXPECTED_MINUTES_IN_OVEN;
    }

    // 2. Calcula cuántos minutos le faltan a la lasaña en el horno
    public int remainingMinutesInOven(int actualMinutesInOven) {
        return expectedMinutesInOven() - actualMinutesInOven;
    }

    // 3. Calcula el tiempo de preparación según el número de capas
    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * PREPARATION_TIME_PER_LAYER;
    }

    // 4. Calcula el tiempo total trabajado (preparación + tiempo en horno)
    public int totalTimeInMinutes(int numberOfLayers, int actualMinutesInOven) {
        return preparationTimeInMinutes(numberOfLayers) + actualMinutesInOven;
    }

    public static void main(String[] args) {
        Lasagna lasagna = new Lasagna();

        System.out.println("expectedMinutesInOven: " + lasagna.expectedMinutesInOven()); // 40
        System.out.println("remainingMinutesInOven(30): " + lasagna.remainingMinutesInOven(30)); // 10
        System.out.println("preparationTimeInMinutes(2): " + lasagna.preparationTimeInMinutes(2)); // 4
        System.out.println("totalTimeInMinutes(3, 20): " + lasagna.totalTimeInMinutes(3, 20)); // 26
    }
}
