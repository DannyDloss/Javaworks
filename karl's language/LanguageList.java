import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageList {

    private List<String> languages;

    // Constructor vacío: empieza sin ningún lenguaje
    public LanguageList() {
        this.languages = new ArrayList<>();
    }

    // Constructor que recibe una lista inicial de lenguajes
    public LanguageList(List<String> languages) {
        this.languages = new ArrayList<>(languages); // copiamos para no depender de la lista original
    }

    // 1. Revisa si la lista está vacía
    public boolean isEmpty() {
        return languages.isEmpty();
    }

    // 2. Agrega un lenguaje a la lista
    public void addLanguage(String language) {
        languages.add(language);
    }

    // 3. Elimina un lenguaje de la lista
    public void removeLanguage(String language) {
        languages.remove(language);
    }

    // 4. Devuelve el primer lenguaje de la lista
    public String firstLanguage() {
        return languages.get(0);
    }

    // 5. Devuelve cuántos lenguajes hay en la lista
    public int count() {
        return languages.size();
    }

    // 6. Revisa si un lenguaje específico está en la lista
    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    // 7. La lista es "emocionante" si contiene Java o Kotlin
    public boolean isExciting() {
        return languages.contains("Java") || languages.contains("Kotlin");
    }

    public static void main(String[] args) {
        LanguageList languageList = new LanguageList();

        System.out.println("isEmpty(): " + languageList.isEmpty()); // true

        languageList.addLanguage("Kotlin");
        languageList.addLanguage("Python");
        System.out.println("count(): " + languageList.count()); // 2
        System.out.println("firstLanguage(): " + languageList.firstLanguage()); // Kotlin

        System.out.println("containsLanguage(\"Python\"): "
                + languageList.containsLanguage("Python")); // true
        System.out.println("containsLanguage(\"Ruby\"): "
                + languageList.containsLanguage("Ruby")); // false

        System.out.println("isExciting(): " + languageList.isExciting()); // true (tiene Kotlin)

        languageList.addLanguage("Scala");
        System.out.println("count() después de agregar Scala: " + languageList.count()); // 3

        languageList.removeLanguage("Scala");
        System.out.println("count() después de eliminar Scala: " + languageList.count()); // 2
        System.out.println("containsLanguage(\"Scala\"): "
                + languageList.containsLanguage("Scala")); // false

        // Ejemplo de lista NO emocionante
        LanguageList neitherKotlinNorJavaLanguageList = new LanguageList(Arrays.asList("Python", "Ruby"));
        System.out.println("isExciting() sin Java ni Kotlin: "
                + neitherKotlinNorJavaLanguageList.isExciting()); // false
    }
}