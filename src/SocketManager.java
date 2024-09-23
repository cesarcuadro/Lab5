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
        // after starting up the server, should be a never-ending loop
        // ask user for 3 numbers separated by commas
        // Ex. 4,7,22
        // send raw text to the server using the SocketClient class
        // items sent should be comma-delimited all concatenated as one string
    }

}
