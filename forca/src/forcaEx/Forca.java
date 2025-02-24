package forcaEx;

import java.util.Scanner;

public class Forca {

	private static final String PALAVRA = "Treinamento";

	private static final int MAX_ERROS = 6;

	public static void main(String[] args) {

		char[] palavraOculta = new char[PALAVRA.length()];

		boolean[] letrasDescobertas = new boolean[PALAVRA.length()];

		int erros = 0;

		// Inicializa a palavra oculta

		for (int i = 0; i < PALAVRA.length(); i++) {

			if (PALAVRA.charAt(i) == ':') {

				palavraOculta[i] = ':'; // Mantém os dois pontos visíveis

				letrasDescobertas[i] = true;

			} else {

				palavraOculta[i] = '_';

			}

		}

		Scanner scanner = new Scanner(System.in);

		while (erros < MAX_ERROS) {

			System.out.println("\nPalavra: " + String.valueOf(palavraOculta));

			System.out.println("Tentativas restantes: " + (MAX_ERROS - erros));

			System.out.print("Digite uma letra: ");

			char tentativa = scanner.next().charAt(0);

			tentativa = Character.toLowerCase(tentativa); // Ignorar maiúsculas e minúsculas

			boolean acertou = false;

			// Verifica se a letra está na palavra

			for (int i = 0; i < PALAVRA.length(); i++) {

				if (Character.toLowerCase(PALAVRA.charAt(i)) == tentativa && !letrasDescobertas[i]) {

					palavraOculta[i] = PALAVRA.charAt(i);

					letrasDescobertas[i] = true;

					acertou = true;

				}

			}

			if (!acertou) {

				erros++;

				System.out.println("Errou! Você ainda tem " + (MAX_ERROS - erros) + " tentativas.");

			}

			// Verifica se o jogador venceu

			if (String.valueOf(palavraOculta).equals(PALAVRA)) {

				System.out.println("\nParabéns! Você acertou a palavra: " + PALAVRA);

				break;

			}

		}

		if (erros == MAX_ERROS) {

			System.out.println("\nVocê perdeu! A palavra era: " + PALAVRA);

		}

		scanner.close();

	}

}