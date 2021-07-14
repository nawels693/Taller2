import java.util.Scanner;

public class menu {
   import java.util.Scanner;

    public class Menu {
        public static void iniciarPrograma() {
            boolean a;
            do {
                menuPrincipal();
                a = tipodeBusqueda(ingresarRespuesta());
            } while (!a);

        }
        public static void menuPrincipal() {
            System.out.println("**********************************************************");
            System.out.println("*             Bienvenido a Turismo Araucanía            *");
            System.out.println("*                            /                           *");
            System.out.println("*              Welcome to Turismo Araucanía              *");
            System.out.println("**********************************************************");
            System.out.println("Por favor, seleccione una de las opcíones/Please select one of the options");
            System.out.println("[1] ver lugares turísticos/see tourist places");
            System.out.println("[2] ver árboles nativos/see native trees");
            System.out.println("[3] ver animales nativos/see native animals");
            System.out.println("[4] Salir del Programa/Exit the program");
        }
        public static String ingresarRespuesta() {
            Scanner teclado = new Scanner(System.in);
            return teclado.next();
        }

        public static boolean tipodeBusqueda(String ingresoDatos) {
            boolean a;
            switch (ingresoDatos) {
                case "1" -> {
                    do {
                        System.out.println("Lista de lugares turísticos/ List of tourist places ");

                        textoSalida();
                        a=salir();
                    }while(a==true);
                }
                case "2" -> {
                    do {
                        System.out.println("Lista de árboles nativos/List of native trees");

                        textoSalida();
                        a=salir();
                    }while (a==true);
                    break;
                }
                case "3" -> {
                    System.out.println("Lista de los animales nativos de la zona/ List of native animals in the area");
                    a = true;

                    break;
                }
                case "4" -> {
                    System.out.println("Desea Salir?");
                    textoSalida();
                    a=salir();
                    break;
                }
                default -> {
                    System.out.println("opción no válida/invalid option");
                    a = false;
                    break;
                }
            }
            return a;
        }

        public static boolean salir(){
            boolean a= true;
            int b=0;
            do {
                String respuesta = ingresarRespuesta();
                switch (respuesta){
                    case "1":
                        System.out.println("Gracias por ocupar el programa / Thank you for occupying the program");
                        a=true;
                        b=1;
                        break;
                    case "2":
                        a=false;
                        b=2;
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida / Enter a valid option");
                        b=0;
                        break;
                }
            }while(b==0);
            return a;
        }
        public static void textoSalida() {
            System.out.println("[1] Si / yes");
            System.out.println("[2] No / no");
        }
    }


}
