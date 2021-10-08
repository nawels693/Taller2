import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class Taller2 {
    public static void main(String[] args) {
        iniciarPrograma();

    }

    public static void iniciarPrograma() {
        do {
            do {
                mostrarMenu();
            }while(seleccionarOpcion()==false);

        }while (Salir()==false);
    }

    public static boolean seleccionarOpcion() {
        boolean a = false;
        do{
            System.out.println("Ingrese una respuesta por favor");
            String b = ingresarRespuesta();
            switch (b){
                case "1":
                    System.out.println("Se mostrarán pares adyacentes");
                    mostrarArreglo(generarParesAdy(rellenarArreglo(crearArreglo())));
                    a = true;
                    break;
                case "2":
                    System.out.println("Se mostrará el mayor valor de productos");
                    a = true;
                    break;
                default:
                    a=false;
                    System.out.println("caracter no valido");
                    break;
            }

        }while (a==false);
        return a;
    }

    public static boolean Salir() {
        boolean a;
        boolean b = false;
        String opcion;
        do {
            System.out.println("Desea Salir?");
            System.out.println("[1] Si");
            System.out.println("[2] no");
            opcion = ingresarRespuesta();
            switch (opcion){
                case "1":
                    a =true;
                    b =true;
                    break;
                case "2":
                    a = true;
                    b = false;
                    break;
                default:
                    a=false;
                    System.out.println("caracter no valido");
                    break;
            }
        }while (a==false);
        return b;

    }

    public static String ingresarRespuesta() {
        Scanner teclado = new Scanner(System.in);
        return teclado.next();
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido, por favor ingrese uno de las opciones dispinibles");
        System.out.println("[1] Mostrar pares adyacentes");
        System.out.println("[2] Mostrar el mayor valor de productos");
    }
    public static int[] crearArreglo() {
        int[] arr = new int[numerosRandom(10)];
        return arr;
    }

    public static int numerosRandom(int a){
        Random rnum = new Random();
        return rnum.nextInt(a);
    }


    public static int[] rellenarArreglo( int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]=numerosRandom(2000)-999;
        }
        return arr;
    }

    public static ArrayList<String> generarParesAdy(int[] arr) {
        ArrayList<String> par = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length) {
                par.add(""+arr[i]+"," + (numerosRandom(2000)-999));
            }
            if (i<arr.length-1){
                par.add("" + arr[i] + "," + arr[i + 1]);

            }
        }
        return par;
    }
    public static void mostrarArreglo(ArrayList a) {
        System.out.println("Los pares son:");
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}