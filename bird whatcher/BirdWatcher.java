public class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    // 1. Devuelve los conteos de la semana pasada (valores fijos)
    public static int[] getLastWeek() {
        return new int[] { 0, 2, 5, 3, 7, 8, 4 };
    }

    // 2. Devuelve cuántos pájaros visitaron hoy (el último elemento del arreglo)
    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    // 3. Incrementa en 1 el conteo de hoy
    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    // 4. Revisa si hubo algún día sin pájaros
    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay) {
            if (birds == 0) {
                return true;
            }
        }
        return false;
    }

    // 5. Suma los pájaros de los primeros "numberOfDays" días
    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;

        for (int i = 0; i < numberOfDays; i++) {
            total = total + birdsPerDay[i];
        }

        return total;
    }

    // 6. Cuenta cuántos días fueron "ocupados" (5 o más pájaros)
    public int getBusyDays() {
        int busyDaysCount = 0;

        for (int birds : birdsPerDay) {
            if (birds >= 5) {
                busyDaysCount++;
            }
        }

        return busyDaysCount;
    }

    public static void main(String[] args) {
        System.out.println("getLastWeek(): " + arrayToString(getLastWeek()));
        // [0, 2, 5, 3, 7, 8, 4]

        int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
        BirdWatcher birdCount = new BirdWatcher(birdsPerDay);

        System.out.println("getToday(): " + birdCount.getToday()); // 1

        birdCount.incrementTodaysCount();
        System.out.println("getToday() después de incrementar: " + birdCount.getToday()); // 2

        System.out.println("hasDayWithoutBirds(): " + birdCount.hasDayWithoutBirds()); // true

        System.out.println("getCountForFirstDays(4): " + birdCount.getCountForFirstDays(4)); // 14

        System.out.println("getBusyDays(): " + birdCount.getBusyDays()); // 2
    }

    // Método auxiliar solo para imprimir el arreglo de forma legible en consola
    private static String arrayToString(int[] array) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
