public class Warrior extends Fighter {

    // 3. Un Warrior nunca es vulnerable
    @Override
    boolean isVulnerable() {
        return false;
    }

    // 4. Calcula el daño que hace un Warrior contra otro luchador
    @Override
    int getDamagePoints(Fighter opponent) {
        if (opponent.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }

    // 2. Describe qué tipo de luchador es
    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard(); // necesario para probar getDamagePoints()

        System.out.println(warrior.toString());        // Fighter is a Warrior
        System.out.println(warrior.isVulnerable());     // false

        // El wizard, sin preparar hechizo, es vulnerable => daño = 10
        System.out.println(warrior.getDamagePoints(wizard)); // 10

        // Si el wizard prepara un hechizo, deja de ser vulnerable => daño = 6
        wizard.prepareSpell();
        System.out.println(warrior.getDamagePoints(wizard)); // 6
    }
}
