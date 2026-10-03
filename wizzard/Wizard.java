public class Wizard extends Fighter {

    // 7. Recuerda si el hechizo fue preparado
    private boolean spellPrepared = false;

    // 7. Permite preparar el hechizo con anticipación
    public void prepareSpell() {
        spellPrepared = true;
    }

    // 7. Un Wizard es vulnerable, a menos que haya preparado un hechizo
    @Override
    boolean isVulnerable() {
        return !spellPrepared;
    }

    // 8. Calcula el daño que hace un Wizard según si preparó el hechizo
    @Override
    int getDamagePoints(Fighter opponent) {
        if (spellPrepared) {
            return 12;
        } else {
            return 3;
        }
    }

    // 6. Describe qué tipo de luchador es
    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior(); // necesario para probar getDamagePoints()

        System.out.println(wizard.toString());   // Fighter is a Wizard
        System.out.println(wizard.isVulnerable()); // true (no ha preparado hechizo)

        wizard.prepareSpell();
        System.out.println(wizard.isVulnerable()); // false (ya preparó hechizo)

        System.out.println(wizard.getDamagePoints(warrior)); // 12
    }
}
