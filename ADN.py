def transcribe_to_rna(dna_strand):
    rna_strand = ""

    for nucleotide in dna_strand:
        if nucleotide == 'G':
            rna_strand += 'C'
        elif nucleotide == 'C':
            rna_strand += 'G'
        elif nucleotide == 'T':
            rna_strand += 'A'
        elif nucleotide == 'A':
            rna_strand += 'U'
        else:
            # Caracter no valido
            print("Error: Caracter no válido en la cadena de ADN.")
            exit(1)

    return rna_strand


def main():
    continuar = True

    while continuar:
        # Solicitud ADN
        dna_strand = input("Ingrese la cadena de ADN (o 'Q' para salir): ")

        if dna_strand.upper() == 'Q':
            continuar = False
        else:
            
            rna_strand = transcribe_to_rna(dna_strand)

            # Mostrar resultado
            print("Resultado de la cadena transcrita:", rna_strand)


if __name__ == "__main__":
    main()