import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    static int contador = 0;
    static int tiempo_ejecucion;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la dirección ip a conectar: ");
        String ipDestino = teclado.nextLine();
        System.out.println("Ingrese el puerto: ");
        int puertoDestino = teclado.nextInt();
        System.out.println("Ingrese el tiempo de ejecucion en segundos: ");
        tiempo_ejecucion = teclado.nextInt();
        System.out.println("Conectando....");

        try {
            Socket socketCliente = new Socket(ipDestino, puertoDestino);

            System.out.println("Conexion establecida :)");
            DataOutputStream dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socketCliente.getInputStream());
            String mensaje = "";


            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (contador < tiempo_ejecucion) {
                        try {
                            Thread.sleep(1000);
                            dataOutputStream.writeUTF("mensaje");
                            socketCliente.setKeepAlive(true);
                            System.out.println(dataInputStream.readUTF());
                            contador++;
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                        if (contador == tiempo_ejecucion) {
                            System.out.println("desea agregar mas segundos");
                            System.out.println("[1] SI");
                            System.out.println("[2] NO");
                            int j = teclado.nextInt();
                            switch (j) {
                                case 1:
                                    System.out.println("cuantos segundos desea agregar");
                                    tiempo_ejecucion = teclado.nextInt();
                                    contador = 0;
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("Dato no valido");
                            }
                        }
                    }
                }
            };
            // Creamos un hilo y le pasamos el runnable
            Thread hilo = new Thread(runnable);
            hilo.start();

        } catch (ConnectException e) {
            System.err.println("Error: Conexion rechazada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



