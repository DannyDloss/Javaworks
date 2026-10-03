// Clase base (padre) para todos los tipos de luchadores.
// Es abstracta porque no tiene sentido crear un "Fighter" genérico,
// solo tipos concretos como Warrior o Wizard.
abstract class Fighter {

    // Cada tipo de luchador decide si es vulnerable o no
    abstract boolean isVulnerable();

    // Cada tipo de luchador decide cuánto daño hace según a quién ataca
    abstract int getDamagePoints(Fighter opponent);
}
