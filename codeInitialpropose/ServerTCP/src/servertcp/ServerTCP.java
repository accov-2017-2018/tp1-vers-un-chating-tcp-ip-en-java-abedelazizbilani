package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class ServerTCP {

    public static final int port = 4444;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new ServerTCP().runServer();
    }

    public void runServer() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server ready");
        while (true) {
            Socket socket = ss.accept();
            new ServerThread(socket).start();
        }
    }
}
