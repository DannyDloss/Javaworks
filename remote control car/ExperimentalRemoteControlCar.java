public class ExperimentalRemoteControlCar implements RemoteControlCar {

    // Cuánto avanza este tipo de carro en cada drive() (el doble que el de producción)
    private static final int DISTANCE_PER_DRIVE = 20;

    private int distanceTravelled = 0;

    // Hace que el carro avance 20 unidades
    @Override
    public void drive() {
        distanceTravelled = distanceTravelled + DISTANCE_PER_DRIVE;
    }

    // Devuelve la distancia total recorrida
    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
