import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    // same code as done in class
    public String connectForOneMessage(String sIP, int iPort, String sMessage) {
        try (Socket oSocket = new Socket()) {
            // actual line that tries to connect to the server
            oSocket.connect(new InetSocketAddress(sIP, iPort), 5000);

            // *** Boiler plate pt1 *** opposite of server
            OutputStream output = oSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println(sMessage);

            // *** boiler plate pt2 ***
            InputStream input = oSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String sReturnedMessage = reader.readLine();

            return sReturnedMessage;

        }
        catch (IOException ex) {
            System.out.println("[client]: Client exception: " + ex.getMessage());
            return null;
        }
    }
}
