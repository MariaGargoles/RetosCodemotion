def calcular_checksum(matriz):
    checksum = 0
    for fila in matriz:
        max_valor = max(fila)
        min_valor = min(fila)
        diferencia = max_valor - min_valor
        checksum += diferencia
    return checksum

def main():
    while True:
        # Solicitar al usuario que ingrese el número de filas de la matriz
        num_filas = input("Ingrese el número de filas de la matriz o 'Q' para salir: ")

        # Salir del programa si el usuario ingresa 'Q'
        if num_filas.upper() == 'Q':
            print("Saliendo del programa...")
            break

        try:
            num_filas = int(num_filas)
            if num_filas <= 0:
                print("Por favor, ingrese un número de filas válido mayor que cero.")
                continue

            matriz = []
            for i in range(num_filas):
                # Solicitar al usuario que ingrese los números de la fila
                numeros_fila = input(f"Ingrese los números de la fila {i + 1}, separados por espacios, o 'Q' para salir: ")

                # Salir del programa si el usuario ingresa 'Q'
                if numeros_fila.upper() == 'Q':
                    print("Saliendo del programa...")
                    return

                numeros_fila = list(map(int, numeros_fila.split()))

                # Verificar si hay números negativos
                if any(num < 0 for num in numeros_fila):
                    print("Por favor, no ingrese números negativos.")
                    break

                matriz.append(numeros_fila)

            else:
                # Calcular el checksum
                resultado_checksum = calcular_checksum(matriz)
                
                # Imprimir el resultado
                print("El checksum de la matriz es:", resultado_checksum)

        except ValueError:
            print("Por favor, ingrese solo números enteros o 'Q' para salir.")

if __name__ == "__main__":
    main()
