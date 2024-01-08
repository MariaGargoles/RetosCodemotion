import java.util.Scanner;

public class ADN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Solicitar de cadena ADN
            System.out.print("Ingrese la cadena de ADN (o 'Q' para salir): ");
            String dnaStrand = scanner.nextLine();

            if (dnaStrand.equalsIgnoreCase("Q")) {
                continuar = false;
            } else {
               
                String rnaStrand = transcribeToRna(dnaStrand);

                // Mostrar resultado
                System.out.println("Resultado de la cadena transcrita: " + rnaStrand);
            }
        }
    }

    private static String transcribeToRna(String dnaStrand) {
        StringBuilder rnaStrand = new StringBuilder();

        for (char nucleotide : dnaStrand.toCharArray()) {
            switch (nucleotide) {
                case 'G':
                    rnaStrand.append('C');
                    break;
                case 'C':
                    rnaStrand.append('G');
                    break;
                case 'T':
                    rnaStrand.append('A');
                    break;
                case 'A':
                    rnaStrand.append('U');
                    break;
                default:
                    // Evitar caracteres no validos
                    System.out.println("Error: Caracter no válido en la cadena de ADN.");
                    System.exit(1);
            }
        }

        return rnaStrand.toString();
    }
}
