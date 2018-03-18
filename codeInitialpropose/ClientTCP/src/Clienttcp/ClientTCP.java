package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Pascal Fares
 */
public class ClientTCP {
    
    public static final int port = 4444;

    /**
     * Récupère le flux d'entrée d'une Socket et l'encapsule dans un
     * BufferedReader Un BufferedReader permet de Lire le texte à partir d'un
     * flux d'entrée de caractères, en mettant en mémoire tampon les caractères
     * afin de permettre une lecture efficace des caractères, des tableaux et
     * des lignes.
     *
     * @param p la SOcket
     * @return le BufferedReader crée
     * @throws IOException
     */
    private static BufferedReader getInput() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in));
    }
    
    private static BufferedReader getServerMessage(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
    }

    /**
     * Récupère le flus de sortie de la socket et l'encapsule dans un
     * PrintWriter Imprime des représentations formatées d'objets dans un flux
     * de sortie de texte. Cette classe implémente toutes les méthodes
     * d'impression trouvées dans PrintStream.
     *
     * @param p la Socket
     * @return le PrintWriter crée
     * @throws IOException
     */
    private static PrintWriter getOutput(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //Se connecté au port 2000
//        String name = args[0];
        Socket socket = new Socket("localhost", port);
        while (true) {
            String reader = getInput().readLine();
            getOutput(socket).println(reader);
            String messageFromServer = getServerMessage(socket).readLine();
            whileChatting(messageFromServer);
        }
    }
    
    private static void whileChatting(String messageFromServer) {
        System.out.println("Message from server to client " + messageFromServer);
    }
}
