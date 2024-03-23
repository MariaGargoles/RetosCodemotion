#Alfabeto
morse_alphabet = {
    'A': '.-', 'B': '-...', 'C': '-.-.', 'D': '-..', 'E': '.', 'F': '..-.', 'G': '--.', 'H': '....', 'I': '..', 
    'J': '.---', 'K': '-.-', 'L': '.-..', 'M': '--', 'N': '-.', 'O': '---', 'P': '.--.', 'Q': '--.-', 'R': '.-.', 
    'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--', 'X': '-..-', 'Y': '-.--', 'Z': '--..',
    '0': '-----', '1': '.----', '2': '..---', '3': '...--', '4': '....-', '5': '.....', '6': '-....', '7': '--...',
    '8': '---..', '9': '----.',
    '.': '.-.-.-', ',': '--..--', '?': '..--..', "'": '.----.', '!': '-.-.--', '/': '-..-.', '(': '-.--.', ')': '-.--.-',
    '&': '.-...', ':': '---...', ';': '-.-.-.', '=': '-...-', '+': '.-.-.', '-': '-....-', '_': '..--.-', '"': '.-..-.',
    '$': '...-..-', '@': '.--.-.'
}

# Función para convertir texto a Morse
def texto_a_morse(texto):
    morse = []
    for letra in texto.upper():
        if letra in morse_alphabet:
            morse.append(morse_alphabet[letra])
        elif letra == ' ':
            morse.append('/')
    return ' '.join(morse)

# Función para convertir Morse a texto
def morse_a_texto(morse):
    texto = []
    palabras = morse.split('/')
    for palabra in palabras:
        letras = palabra.strip().split()
        for letra in letras:
            for clave, valor in morse_alphabet.items():
                if valor == letra:
                    texto.append(clave)
                    break
        texto.append(' ')
    return ''.join(texto).strip()

def main():
    while True:
        print("\nSeleccione una opción:")
        print("1. Convertir texto a Morse")
        print("2. Convertir Morse a texto")
        print("3. Salir")
        
        opcion = input("Ingrese el número de la opción deseada: ")
        
        if opcion == '1':
            texto = input("Ingrese el texto a convertir a Morse: ")
            morse = texto_a_morse(texto)
            print("El texto convertido a Morse es:", morse)
        elif opcion == '2':
            morse = input("Ingrese el código Morse a convertir a texto: ")
            texto = morse_a_texto(morse)
            print("El código Morse convertido a texto es:", texto)
        elif opcion == '3':
            print("Saliendo del programa...")
            break
        else:
            print("Opción no válida. Por favor, seleccione una opción válida.")

if __name__ == "__main__":
    main()
