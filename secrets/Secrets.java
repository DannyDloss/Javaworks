public class Secrets {

    // 1. Desplaza los bits hacia la derecha, insertando ceros a la izquierda
    public static int shiftBack(int value, int numberOfBits) {
        return value >>> numberOfBits; // >>> siempre rellena con 0s (shift lógico)
    }

    // 2. Pone en 1 los bits de value donde mask tenga 1
    public static int setBits(int value, int mask) {
        return value | mask; // OR: si el bit del mask es 1, el resultado será 1
    }

    // 3. Invierte los bits de value donde mask tenga 1
    public static int flipBits(int value, int mask) {
        return value ^ mask; // XOR: si el bit del mask es 1, el bit se invierte
    }

    // 4. Pone en 0 los bits de value donde mask tenga 1
    public static int clearBits(int value, int mask) {
        return value & ~mask; // primero invertimos el mask, luego usamos AND
    }

    public static void main(String[] args) {
        System.out.println("shiftBack(0b1001, 2): " + Integer.toBinaryString(shiftBack(0b1001, 2))); // 10
        System.out.println("setBits(0b0110, 0b0101): " + Integer.toBinaryString(setBits(0b0110, 0b0101))); // 111
        System.out.println("flipBits(0b1100, 0b0101): " + Integer.toBinaryString(flipBits(0b1100, 0b0101))); // 1001
        System.out.println("clearBits(0b0110, 0b0101): " + Integer.toBinaryString(clearBits(0b0110, 0b0101))); // 10
    }
}
