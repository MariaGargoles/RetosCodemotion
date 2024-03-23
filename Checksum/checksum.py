def calcular_checksum(matriz):
    checksum = 0
    for fila in matriz:
        max_valor = max(fila)
        min_valor = min(fila)
        diferencia = max_valor - min_valor
        checksum += diferencia
    return checksum

def main():
    # Solicitar al usuario que ingrese las checksums
    filas = int(input("Ingrese el número de filas de la matriz: "))
    matriz = []
    for i in range(filas):
        fila = list(map(int, input(f"Ingrese los números de la fila {i + 1}, separados por espacios: ").split()))
        matriz.append(fila)
    
    # Calcular el checksum
    resultado_checksum = calcular_checksum(matriz)
    
    # Imprimir el resultado
    print("El checksum de la matriz es:", resultado_checksum)

if __name__ == "__main__":
    main()
