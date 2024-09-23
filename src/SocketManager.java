import java.util.Scanner;

public class SocketManager {
    public static void main(String[] args) {
        // ask the user
        // the port that server will run on
        System.out.print("Enter the port for this server to run on: ");
        int initialPort = new Scanner(System.in).nextInt();
        // IP of another server
        System.out.print("Enter the IP address for the server to talk to: ");
        String otherIPAddress = new Scanner(System.in).nextLine();
        // port of the other server
        System.out.print("Enter the port for this server to talk to: ");
        int otherPort = new Scanner(System.in).nextInt();

        SocketServer oServer = new SocketServer(initialPort);
        Thread oServerThread = new Thread(oServer);
        oServerThread.start();
        // after starting up the server, should be a never-ending loop
        while (true) {
            // ask user for 3 numbers separated by commas
            // Ex. 4,7,22
            System.out.print("Enter three numbers separated by a comma (Ex. 4,7,22): ");
            String numberInput = new Scanner(System.in).nextLine();
            // send raw text to the server using the SocketClient class
            // items sent should be comma-delimited all concatenated as one string
            SocketClient oSocketClient = new SocketClient();
            String oServerResponse = oSocketClient.connectForOneMessage(otherIPAddress, otherPort, numberInput);
            System.out.println(oServerResponse);
        }
    }

}
