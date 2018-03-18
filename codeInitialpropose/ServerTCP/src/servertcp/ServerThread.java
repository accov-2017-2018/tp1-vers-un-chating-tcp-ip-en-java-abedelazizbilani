/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Abed Bilani
 */
public class ServerThread extends Thread {

    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            String message = null;
            while ((message = getInput(socket).readLine()) != null) {
                System.out.println("message " + message);
                getoutput(socket).println("ping " + message);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    private static BufferedReader getInput(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
    private static PrintWriter getoutput(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }
}
