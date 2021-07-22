import java.awt.*;
import java.net.InetAddress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorMonitoreoTCP {
    static String muestra = "";
    static int x;
    static int y;
    static Point pixel;
    static Color color = null;

    public static void main(String[] args) throws UnknownHostException {

        int puerto = 62000;
        InetAddress direccion_server = InetAddress.getLocalHost();
        System.out.println("Datos del servidor");
        System.out.println("Ip local del servidor TCP: " + direccion_server.getHostAddress());
        System.out.println("Puerto: " + puerto);

        try {
            //System.out.println(String.valueOf(a));
            ServerSocket socket_servidor = new ServerSocket(puerto);
            Socket cliente = socket_servidor.accept();
            System.out.println("Se ha conectado un nuevo cliente");
            DataInputStream entrada_stream = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida_stream = new DataOutputStream(cliente.getOutputStream());
            String mensaje_cliente = "";
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // Esto se ejecuta en segundo plano una única vez
                    while (true) {
                        // Pero usamos un truco y hacemos un ciclo infinito
                        try {
                            Thread.sleep(1000);

                            pixel = MouseInfo.getPointerInfo().getLocation();
                            x = pixel.x;
                            y = pixel.y;
                            color = (new Robot()).getPixelColor(x, y);

                            muestra = "#" + Integer.toHexString(color.getRGB()).substring(2);


                            // Así, se da la impresión de que se ejecuta cada cierto tiempo
                        } catch (InterruptedException | AWTException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            // Creamos un hilo y le pasamos el runnable
            Thread hilo = new Thread(runnable);
            hilo.start();


            while (!mensaje_cliente.equals("salir")) {
                mensaje_cliente = entrada_stream.readUTF();
                System.out.println(mensaje_cliente);
                salida_stream.writeUTF(muestra);


            }

            while (true) {
                salida_stream.writeUTF(muestra);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

