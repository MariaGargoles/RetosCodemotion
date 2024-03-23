import java.util.HashMap;
import java.util.Scanner;

public class MorseConverter {

    // Definir el alfabeto Morse
    private static final HashMap<Character, String> morseAlphabet = new HashMap<>();
    static {
        morseAlphabet.put('A', ".-");
        morseAlphabet.put('B', "-...");
        morseAlphabet.put('C', "-.-.");
        morseAlphabet.put('D', "-..");
        morseAlphabet.put('E', ".");
        morseAlphabet.put('F', "..-.");
        morseAlphabet.put('G', "--.");
        morseAlphabet.put('H', "....");
        morseAlphabet.put('I', "..");
        morseAlphabet.put('J', ".---");
        morseAlphabet.put('K', "-.-");
        morseAlphabet.put('L', ".-..");
        morseAlphabet.put('M', "--");
        morseAlphabet.put('N', "-.");
        morseAlphabet.put('O', "---");
        morseAlphabet.put('P', ".--.");
        morseAlphabet.put('Q', "--.-");
        morseAlphabet.put('R', ".-.");
        morseAlphabet.put('S', "...");
        morseAlphabet.put('T', "-");
        morseAlphabet.put('U', "..-");
        morseAlphabet.put('V', "...-");
        morseAlphabet.put('W', ".--");
        morseAlphabet.put('X', "-..-");
        morseAlphabet.put('Y', "-.--");
        morseAlphabet.put('Z', "--..");
        morseAlphabet.put('0', "-----");
        morseAlphabet.put('1', ".----");
        morseAlphabet.put('2', "..---");
        morseAlphabet.put('3', "...--");
        morseAlphabet.put('4', "....-");
        morseAlphabet.put('5', ".....");
        morseAlphabet.put('6', "-....");
        morseAlphabet.put('7', "--...");
        morseAlphabet.put('8', "---..");
        morseAlphabet.put('9', "----.");
        morseAlphabet.put('.', ".-.-.-");
        morseAlphabet.put(',', "--..--");
        morseAlphabet.put('?', "..--..");
        morseAlphabet.put('\'', ".----.");
        morseAlphabet.put('!', "-.-.--");
        morseAlphabet.put('/', "-..-.");
        morseAlphabet.put('(', "-.--.");
        morseAlphabet.put(')', "-.--.-");
        morseAlphabet.put('&', ".-...");
        morseAlphabet.put(':', "---...");
        morseAlphabet.put(';', "-.-.-.");
        morseAlphabet.put('=', "-...-");
        morseAlphabet.put('+', ".-.-.");
        morseAlphabet.put('-', "-....-");
        morseAlphabet.put('_', "..--.-");
        morseAlphabet.put('"', ".-..-.");
        morseAlphabet.put('$', "...-..-");
        morseAlphabet.put('@', ".--.-.");
    }

    // Función para convertir texto a Morse
    public static String textoAMorse(String texto) {
        StringBuilder morse = new StringBuilder();
        for (char c : texto.toUpperCase().toCharArray()) {
            if (morseAlphabet.containsKey(c)) {
                morse.append(morseAlphabet.get(c)).append(" ");
            } else if (c == ' ') {
                morse.append("/ ");
            }
        }
        return morse.toString().trim();
    }

    // Función para convertir Morse a texto
    public static String morseATexto(String morse) {
        StringBuilder texto = new StringBuilder();
        String[] palabras = morse.split("/");
        for (String palabra : palabras) {
            String[] letras = palabra.trim().split(" ");
            for (String letra : letras) {
                for (char key : morseAlphabet.keySet()) {
                    if (morseAlphabet.get(key).equals(letra)) {
                        texto.append(key);
                        break;
                    }
                }
            }
            texto.append(" ");
        }
        return texto.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir texto a Morse");
            System.out.println("2. Convertir Morse a texto");
            System.out.println("3. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el texto a convertir a Morse: ");
                    String texto = scanner.nextLine();
                    String morse = textoAMorse(texto);
                    System.out.println("El texto convertido a Morse es: " + morse);
                    break;
                case "2":
                    System.out.print("Ingrese el código Morse a convertir a texto: ");
                    morse = scanner.nextLine();
                    texto = morseATexto(morse);
                    System.out.println("El código Morse convertido a texto es: " + texto);
                    break;
                case "3":
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
