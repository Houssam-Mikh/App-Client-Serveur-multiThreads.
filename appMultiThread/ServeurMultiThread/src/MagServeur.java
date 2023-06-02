import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MagServeur extends Thread  {

    public static int port;
    public static ServerSocket serverListener ;
    public static Socket client;
    public static void main(String []args) throws IOException {
    try {
        serverListener=new ServerSocket(8090);
        while (true){
            client=serverListener.accept();
            ClientHandler clientHandler= new ClientHandler(client);
            clientHandler.start();
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
}