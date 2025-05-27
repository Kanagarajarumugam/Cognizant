import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                if (in.ready()) {
                    clientMsg = in.readLine();
                    if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                        System.out.println("Client disconnected.");
                        break;
                    }
                    System.out.println("Client: " + clientMsg);
                }

                if (console.ready()) {
                    serverMsg = console.readLine();
                    out.write(serverMsg);
                    out.newLine();
                    out.flush();
                    if (serverMsg.equalsIgnoreCase("bye")) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
