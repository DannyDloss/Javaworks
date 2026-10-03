public class JedliksToyCar {

    // Cuánto avanza el carro en cada manejada (en metros)
    private static final int METERS_PER_DRIVE = 20;

    // Cuánta batería gasta el carro en cada manejada (en porcentaje)
    private static final int BATTERY_DRAIN_PER_DRIVE = 1;

    private int distanceDriven;
    private int batteryPercentage;

    // Constructor privado: el carro solo se crea a través de buy()
    private JedliksToyCar() {
        distanceDriven = 0;
        batteryPercentage = 100;
    }

    // 1. "Compra" un carro nuevo, con batería llena y 0 metros recorridos
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    // 2. Muestra la distancia recorrida
    public String distanceDisplay() {
        return "Driven " + distanceDriven + " meters";
    }

    // 3. Muestra el porcentaje de batería (o "Battery empty" si está en 0)
    public String batteryDisplay() {
        if (batteryPercentage == 0) {
            return "Battery empty";
        }
        return "Battery at " + batteryPercentage + "%";
    }

    // 4, 5 y 6. Actualiza distancia y batería, solo si hay batería disponible
    public void drive() {
        if (batteryPercentage > 0) {
            distanceDriven = distanceDriven + METERS_PER_DRIVE;
            batteryPercentage = batteryPercentage - BATTERY_DRAIN_PER_DRIVE;
        }
        // Si la batería está en 0, no pasa nada: no avanza ni gasta más batería
    }

    public static void main(String[] args) {
        JedliksToyCar car = JedliksToyCar.buy();

        System.out.println(car.distanceDisplay()); // Driven 0 meters
        System.out.println(car.batteryDisplay());  // Battery at 100%

        car.drive();
        car.drive();
        System.out.println(car.distanceDisplay()); // Driven 40 meters
        System.out.println(car.batteryDisplay());  // Battery at 98%

        // Drenamos la batería manejando hasta llegar a 0%
        for (int i = 0; i < 98; i++) {
            car.drive();
        }

        System.out.println(car.distanceDisplay()); // Driven 2000 meters
        System.out.println(car.batteryDisplay());  // Battery empty

        // Intentamos manejar con la batería vacía: no debería cambiar nada
        car.drive();
        System.out.println(car.distanceDisplay()); // Driven 2000 meters (sin cambios)
        System.out.println(car.batteryDisplay());  // Battery empty
    }
}
