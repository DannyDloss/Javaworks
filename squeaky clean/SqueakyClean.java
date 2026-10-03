public class SqueakyClean {

    // Convierte un nombre "sucio" en un nombre válido SqueakyClean
    // (solo letras y guiones bajos)
    public static String clean(String identifier) {
        StringBuilder result = new StringBuilder();

        // Bandera: indica si la próxima letra debe ir en mayúscula
        // (se activa cuando encontramos un guion '-')
        boolean capitalizeNext = false;

        char[] chars = identifier.toCharArray();

        for (char ch : chars) {

            // 1. Espacios se convierten en guion bajo
            if (ch == ' ') {
                result.append('_');

            // 2. Guion: se elimina y la siguiente letra se pone en mayúscula
            } else if (ch == '-') {
                capitalizeNext = true;

            // 3. Leetspeak: convertimos dígitos específicos a letras
            } else if (isLeetspeakChar(ch)) {
                char letter = leetspeakToLetter(ch);
                result.append(applyCapitalizationIfNeeded(letter, capitalizeNext));
                capitalizeNext = false;

            // 4. Letras normales se mantienen (respetando mayúscula pendiente)
            } else if (Character.isLetter(ch)) {
                result.append(applyCapitalizationIfNeeded(ch, capitalizeNext));
                capitalizeNext = false;

            }
            // 5. Cualquier otro carácter (números normales, símbolos, etc.)
            //    se omite, no se agrega nada al resultado.
        }

        return result.toString();
    }

    // Indica si el carácter es uno de los dígitos que usamos en leetspeak
    private static boolean isLeetspeakChar(char ch) {
        return ch == '4' || ch == '3' || ch == '0' || ch == '1' || ch == '7';
    }

    // Traduce un dígito de leetspeak a su letra equivalente
    private static char leetspeakToLetter(char ch) {
        switch (ch) {
            case '4': return 'a';
            case '3': return 'e';
            case '0': return 'o';
            case '1': return 'l';
            case '7': return 't';
            default: return ch; // no debería llegar aquí
        }
    }

    // Si corresponde, convierte la letra a mayúscula (para camelCase)
    private static char applyCapitalizationIfNeeded(char letter, boolean capitalize) {
        if (capitalize) {
            return Character.toUpperCase(letter);
        }
        return letter;
    }

    public static void main(String[] args) {
        System.out.println(clean("my   Id"));       // my___Id
        System.out.println(clean("a-bc"));           // aBc
        System.out.println(clean("H3ll0 W0rld"));    // Hello_World
        System.out.println(clean("4 73s7"));         // a_test
        System.out.println(clean("a$#.b"));          // ab
    }
}
