package com.generation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestMinus {
    public static void main(String[] args) {
        String[] diasSemana = {"lunes", "martes", "miercoles", "jueves", "viernes"};
        List<String> listaDiasSemana = Arrays.asList(diasSemana);
        String diaSemana;
        int hora;
        int minutos;

        Scanner myScanner = new Scanner(System.in);
        while (true) {
            // Se solicita el día de la semana
            System.out.print("Ingrese el día de la semana: ");
            diaSemana = myScanner.next().toLowerCase();
            // Se verifica la validez
            if (!listaDiasSemana.contains(diaSemana)) {
                System.out.println("Error: Día de la semana no válido. Inténtalo de nuevo.");
                continue;
            }
            // Se solicita la hora
            System.out.print("Ingrese la hora (0-23): ");
            hora = myScanner.nextInt();
            // Se verifica la validez
            if (hora < 0 || hora > 23) {
                System.out.println("Error: Hora no válida. Inténtalo de nuevo.");
                continue;
            }
            // Se solicitan los minutos
            System.out.print("Ingrese los minutos (0-59): ");
            minutos = myScanner.nextInt();
            // Se verifica la validez
            if (minutos < 0 || minutos > 59) {
                System.out.println("Error: Minutos no válidos. Inténtalo de nuevo.");
                continue;
            }

            // Código para calcular los minutos faltantes hasta el fin de semana
            int diaIndex = listaDiasSemana.indexOf(diaSemana);
            int minutosFaltantes = 0;
            if (diaIndex < 4 || (diaIndex == 4 && hora < 15)) {
                minutosFaltantes = ((4 - diaIndex) * 24 * 60) + ((15 - hora) * 60) - minutos;
            }
            System.out.printf("Faltan %d minutos para el fin de semana.\n", minutosFaltantes);
            break;
        }
        myScanner.close();
    }
}

