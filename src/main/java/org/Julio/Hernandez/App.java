package org.Julio.Hernandez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner Lectura = new Scanner(System.in);

    public static void main( String[] args )
    {
        menu();
    }
    public static void menu() {
        int menu = 0;

        do {
            System.out.println("___________");
            System.out.println("1 - Opcion 1");
            System.out.println("2 - Salir");
            System.out.println("3 - Opcion 3");
            System.out.println("___________");

            try {
                menu = Lectura.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println("Tremendo");
                        break;
                    case 2:
                        System.out.println("Saliendo");
                        menu = 5;
                        break;
                    default:
                        System.out.println("Otro numero");
                        break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Te equivocashte");
                Lectura.next();
            }
        }while (menu != 5);
    }
}
