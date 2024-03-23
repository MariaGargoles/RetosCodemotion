import java.util.Scanner;

public class ChecksumCalculator {

    public static int calcularChecksum(int[][] matriz) {
        int checksum = 0;
        for (int[] fila : matriz) {
            int maxValor = Integer.MIN_VALUE;
            int minValor = Integer.MAX_VALUE;
            for (int valor : fila) {
                maxValor = Math.max(maxValor, valor);
                minValor = Math.min(minValor, valor);
            }
            int diferencia = maxValor - minValor;
            checksum += diferencia;
        }
        return checksum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Solicitar al usuario que ingrese el número de filas de la matriz
            System.out.print("Ingrese el número de filas de la matriz o 'Q' para salir: ");
            String input = scanner.nextLine();

            // Salir del programa si el usuario ingresa 'Q'
            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            try {
                int filas = Integer.parseInt(input);
                if (filas <= 0) {
                    System.out.println("Por favor, ingrese un número de filas válido mayor que cero.");
                    continue;
                }

                // Crear la matriz
                int[][] matriz = new int[filas][];
                for (int i = 0; i < filas; i++) {
                    System.out.print("Ingrese los números de la fila " + (i + 1) + ", separados por espacios, o 'Q' para salir: ");
                    String filaInput = scanner.nextLine();

                    // Salir del programa si el usuario ingresa 'Q'
                    if (filaInput.equalsIgnoreCase("Q")) {
                        System.out.println("Saliendo del programa...");
                        return;
                    }

                    String[] valores = filaInput.split(" ");
                    matriz[i] = new int[valores.length];
                    for (int j = 0; j < valores.length; j++) {
                        try {
                            int valor = Integer.parseInt(valores[j]);
                            if (valor < 0) {
                                System.out.println("Por favor, no ingrese números negativos.");
                                break;
                            }
                            matriz[i][j] = valor;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, ingrese solo números enteros.");
                            break;
                        }
                    }
                }

                // Calcular el checksum
                int resultadoChecksum = calcularChecksum(matriz);

                // Imprimir el resultado
                System.out.println("El checksum de la matriz es: " + resultadoChecksum);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese solo números enteros o 'Q' para salir.");
            }
        }

        scanner.close();
    }
}
