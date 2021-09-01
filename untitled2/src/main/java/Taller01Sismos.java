import java.util.Random;
import java.util.Scanner;

public class Taller01Sismos {
    public static void main(String[] args) {
        iniciarPrograma();






        contarSismos();
        buscarMayorSismo();

    }

    public static void iniciarPrograma() {
        do {
            menu();

            while ()
        }
    }

    public static int buscarMayorSismo(double[] SismosM) {
        double a = 0;
        for (int i = 0; i < SismosM.length; i++) {
            if (SismosM[i] > a) {
                a = SismosM[i];
            }
            return a;
        }


        public static double enviarSMS ( double[] arr){
            double Mayo7;
            for (int i = 0; i < arr.length; i++) {
                if (arr >= 7) {
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                }
            }
            return
        }
        public static int contarSismos ( double[] sismos){
            int CantidadDeSismos = 0;
            for (int i = 0; i < sismos.length; i++) {
                if (sismos[i] >= 5) {
                    CantidadDeSismos++;
                }
            }
            return CantidadDeSismos;
        }


        public static double[] llenarArreglo () {
            Random rnum = new Random();
            double arr[] = new double[69];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rnum.nextDouble() * 9.9;
            }
            return arr;

        }

        public static int IngresarRespuesta () {
            Scanner teclado = new Scanner(System.in);
            int respuesta = teclado.nextInt();

            return respuesta;

        }

        public static void menu () {
            System.out.println("Bienvenido");
            System.out.println("¿que desea hacer?");
            System.out.println("[1] Ingresar datos");
            System.out.println("[2] Mostrar sismo de mayor magnitud");
            System.out.println("[3] Contar sismos mayores o iguales a 5.0");
            System.out.println("[4] Enviar SMS por cada sismo mayor o igual a 7.0");
            System.out.println("[5] Salir(S/N)");

            switch (IngresarRespuesta()) {
                case 1:
                    llenarArreglo();

                    break;
                case 2:
                    llenarArreglo();
                    buscarMayorSismo();
                    break;
                case 3:
                    llenarArreglo();
                    contarSismos();
                    break;
                case 4:
                    llenarArreglo();
                    enviarSMS();
                    break;
                case 5:


            }
        }
    }
