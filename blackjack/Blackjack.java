public class Blackjack {

    // 1. Calcula el valor numérico de una carta según su nombre
    public static int parseCard(String card) {
        switch (card) {
            case "ace":
                return 11;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
            case "jack":
            case "queen":
            case "king":
                return 10;
            default:
                return 0; // cualquier otra carta desconocida
        }
    }

    // 2. Determina si dos cartas forman un Blackjack (suman 21)
    public static boolean isBlackjack(String card1, String card2) {
        int total = parseCard(card1) + parseCard(card2);
        return total == 21;
    }

    // 3. Lógica de decisión cuando la mano vale más de 20 puntos (Large Hand)
    public static String largeHand(boolean isBlackJack, int dealerScore) {

        // Si no es Blackjack (por ejemplo, un par de ases), hay que dividir la mano
        if (!isBlackJack) {
            return "P"; // Split
        }

        // Si es Blackjack, ganamos automáticamente a menos que el dealer
        // tenga un as, una figura o un diez (dealerScore >= 10)
        if (dealerScore < 10) {
            return "W"; // Win automático
        } else {
            return "S"; // Stand, esperar a ver la otra carta del dealer
        }
    }

    // 4. Lógica de decisión cuando la mano vale menos de 21 puntos (Small Hand)
    public static String smallHand(int handScore, int dealerScore) {

        if (handScore >= 17) {
            return "S"; // Stand
        } else if (handScore <= 11) {
            return "H"; // Hit
        } else {
            // handScore está entre 12 y 16
            if (dealerScore >= 7) {
                return "H"; // Hit, el dealer tiene una carta fuerte
            } else {
                return "S"; // Stand
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("parseCard(\"ace\"): " + parseCard("ace")); // 11

        System.out.println("isBlackjack(\"queen\", \"ace\"): "
                + isBlackjack("queen", "ace")); // true

        System.out.println("largeHand(true, 7): " + largeHand(true, 7)); // W
        System.out.println("largeHand(true, 10): " + largeHand(true, 10)); // S
        System.out.println("largeHand(false, 10): " + largeHand(false, 10)); // P

        System.out.println("smallHand(15, 12): " + smallHand(15, 12)); // H
        System.out.println("smallHand(9, 10): " + smallHand(9, 10)); // H
        System.out.println("smallHand(18, 10): " + smallHand(18, 10)); // S
        System.out.println("smallHand(14, 5): " + smallHand(14, 5)); // S
    }
}
