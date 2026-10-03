public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    // Cuánto avanza este tipo de carro en cada drive()
    private static final int DISTANCE_PER_DRIVE = 10;

    private int distanceTravelled = 0;
    private int numberOfVictories = 0;

    // Hace que el carro avance 10 unidades
    @Override
    public void drive() {
        distanceTravelled = distanceTravelled + DISTANCE_PER_DRIVE;
    }

    // Devuelve la distancia total recorrida
    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    // Permite asignar el número de victorias de este carro
    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    // Orden por defecto: de MÁS a MENOS victorias (orden descendente).
    // Integer.compare evita el desbordamiento de la resta (other - this)
    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(other.numberOfVictories, this.numberOfVictories);
    }
}
