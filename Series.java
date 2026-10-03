import java.util.ArrayList;
import java.util.List;

public class Series {

    private final String digits;

    // Constructor: guarda el string de dígitos
    public Series(String digits) {
        this.digits = digits;
    }

    // Devuelve todas las subcadenas contiguas de longitud n
    public List<String> slices(int n) {
        // Validaciones básicas
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser mayor que 0");
        }
        if (n > digits.length()) {
            throw new IllegalArgumentException("n no puede ser mayor que la longitud del string");
        }

        List<String> result = new ArrayList<>();

        // Recorremos el string tomando "ventanas" de tamaño n
        for (int i = 0; i <= digits.length() - n; i++) {
            String slice = digits.substring(i, i + n);
            result.add(slice);
        }

        return result;
    }

    public static void main(String[] args) {
        Series series = new Series("49142");

        System.out.println("slices(3): " + series.slices(3)); // [491, 914, 142]
        System.out.println("slices(4): " + series.slices(4)); // [4914, 9142]
    }
}
