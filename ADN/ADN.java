import java.util.Scanner;

public class ADNtranscription {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            System.out.print("Ingrese la cadena de ADN o 'Q' para salir: ");
            String dnaStrand = scanner.nextLine();

            if (dnaStrand.equalsIgnoreCase("Q")) {
                continuar = false;
            } else {

                String rnaStrand = transcriptToRna(dnaStrand);

                System.out.println("Resultado: " + rnaStrand);
            }
        }
    }

    private static String transcriptToRna(String dnaStrand) {
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

                    System.out.println("Error: Caracter no válido." );
                    System.exit(1);
            }
        }

        return rnaStrand.toString();
    }
}
