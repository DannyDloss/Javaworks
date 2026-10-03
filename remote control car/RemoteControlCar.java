public interface RemoteControlCar {

    // Hace que el carro avance (la distancia depende del tipo de carro)
    void drive();

    // Devuelve la distancia total recorrida en la vida del carro
    int getDistanceTravelled();
}
