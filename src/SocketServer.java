import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
    private int thisServerPort;

    public SocketServer(int thisServerPort) {
        this.thisServerPort = thisServerPort;
    }

    public void run() {
        // when server receives a message from a client
        try (ServerSocket serverSocket = new ServerSocket(thisServerPort)) {
            System.out.println("Server listening on port " + thisServerPort);
            while (true) {
                Socket oSocket = serverSocket.accept();
                System.out.println("[server]: New client connected: " + oSocket.getRemoteSocketAddress());

                InputStream inputStream = oSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String receivedMessage = reader.readLine();
                System.out.println("[server]: Received message: " + receivedMessage);

                String[] messageArray = receivedMessage.split(",");
                int num1 = Integer.parseInt(messageArray[0]);
                int num2 = Integer.parseInt(messageArray[1]);
                int num3 = Integer.parseInt(messageArray[2]);

                int sumOfArray = num1 + num2 + num3;
                System.out.println("[server]: Sum of array: " + sumOfArray);

                OutputStream outputStream = oSocket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                printWriter.println("Sum: "+ sumOfArray);
                printWriter.flush();
            }
        }
        catch (IOException ex) {
            System.out.println("[server]: error: " + ex.getMessage());
        }
        // it should try to parse the comma-delimited message into an array
        // use sReceivedMessage.split(",")
        // turn each array string into three int variables
        // use Integer.parseInt() to do this on each item in the array
        // then sum these numbers into a result
        // reply with the sum of these numbers
    }

}
