public class AnnalynsInfiltration {

    // 1. Se puede hacer un ataque rápido si el caballero está dormido
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    // 2. Se puede espiar si al menos uno de los tres está despierto
    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    // 3. Se puede señalar al prisionero si está despierto y el arquero está dormido
    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    // 4. Se puede liberar al prisionero de dos formas distintas
    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake,
                                           boolean prisonerIsAwake, boolean petDogIsPresent) {

        // Caso 1: con el perro, solo importa que el arquero esté dormido
        boolean canFreeWithDog = petDogIsPresent && !archerIsAwake;

        // Caso 2: sin el perro, el prisionero debe estar despierto
        // y tanto el caballero como el arquero deben estar dormidos
        boolean canFreeWithoutDog = !petDogIsPresent && prisonerIsAwake && !knightIsAwake && !archerIsAwake;

        return canFreeWithDog || canFreeWithoutDog;
    }

    public static void main(String[] args) {
        System.out.println("canFastAttack(true): " + canFastAttack(true)); // false

        System.out.println("canSpy(false, true, false): "
                + canSpy(false, true, false)); // true

        System.out.println("canSignalPrisoner(false, true): "
                + canSignalPrisoner(false, true)); // true

        System.out.println("canFreePrisoner(false, true, false, false): "
                + canFreePrisoner(false, true, false, false)); // false
    }
}
