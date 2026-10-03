import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestTrack {

    // 3. Hace que cualquier tipo de carro (que implemente la interfaz) recorra la pista
    public static void race(RemoteControlCar car) {
        car.drive();
    }

    // 4. Devuelve los carros de producción ordenados de más a menos victorias
    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        // Hacemos una copia para no modificar la lista original
        List<ProductionRemoteControlCar> rankedCars = new ArrayList<>(cars);

        // Usa el compareTo() que definimos en ProductionRemoteControlCar
        Collections.sort(rankedCars);

        return rankedCars;
    }

    public static void main(String[] args) {

        // --- Prueba de drive() y getDistanceTravelled() ---
        ProductionRemoteControlCar prod = new ProductionRemoteControlCar();
        prod.drive();
        System.out.println("prod.getDistanceTravelled(): " + prod.getDistanceTravelled()); // 10

        ExperimentalRemoteControlCar exp = new ExperimentalRemoteControlCar();
        exp.drive();
        System.out.println("exp.getDistanceTravelled(): " + exp.getDistanceTravelled()); // 20

        // --- Prueba de race() ---
        TestTrack.race(new ProductionRemoteControlCar());
        TestTrack.race(new ExperimentalRemoteControlCar());
        System.out.println("race() ejecutado sin errores para ambos tipos de carro");

        // --- Prueba de getRankedCars() ---
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(2);
        prc2.setNumberOfVictories(3);

        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
        unsortedCars.add(prc1);
        unsortedCars.add(prc2);

        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);

        System.out.println("rankings.get(0) victorias: " + rankings.get(0).getNumberOfVictories()); // 3 (prc2)
        System.out.println("rankings.get(1) victorias: " + rankings.get(1).getNumberOfVictories()); // 2 (prc1)
    }
}
