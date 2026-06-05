package br.com.gs2espv.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Console {


    private static final Scanner SCANNER = new Scanner(System.in);


    private Console() {}

    public static String lerString(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().strip();
    }

    public static int lerInt(String prompt) {
        System.out.print(prompt);
        try {
            int valor = SCANNER.nextInt();
            SCANNER.nextLine(); // consome a quebra de linha restante
            return valor;
        } catch (InputMismatchException e) {
            SCANNER.nextLine(); // limpa buffer inválido
            System.out.println("  ⚠️  Entrada inválida — digite um número inteiro.");
            return -1;
        }
    }

    public static int lerIntNoIntervalo(String prompt, int min, int max) {
        int valor;
        do {
            valor = lerInt(prompt);
            if (valor < min || valor > max) {
                System.out.println("  ⚠️  Digite um valor entre " + min + " e " + max + ".");
            }
        } while (valor < min || valor > max);
        return valor;
    }


    public static void separador() {
        System.out.println("──────────────────────────────────────────────────");
    }

    public static void linha() {
        System.out.println();
    }

    public static void fechar() {
        SCANNER.close();
    }
}
