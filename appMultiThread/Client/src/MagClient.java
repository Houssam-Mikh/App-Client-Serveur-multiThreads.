import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MagClient {
    public static int port=8090;
    public static String ip_serverSocket="localhost";
    public static Socket socket;
    public static void main(String[] args) throws IOException {
        socket=new Socket(ip_serverSocket,port);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream=new DataInputStream(socket.getInputStream());
        Scanner scanner  = new Scanner(System.in);
        //nom
        System.out.println(inputStream.readUTF());
        outputStream.writeUTF(scanner.next());
        //prenom
        System.out.println(inputStream.readUTF());
        outputStream.writeUTF(scanner.next());
        //nbrArticle
        System.out.println(inputStream.readUTF());
        int nbrArticle = scanner.nextInt();
        outputStream.writeInt(nbrArticle);
        System.out.println(inputStream.readUTF());
        for(int i=0; i<nbrArticle; i++){
            scanner=null;
            scanner=new Scanner(System.in);
            System.out.println(inputStream.readUTF());
            outputStream.writeDouble(scanner.nextDouble());
            scanner=null;
            scanner=new Scanner(System.in);
            System.out.println(inputStream.readUTF());
            outputStream.writeInt(scanner.nextInt());
        }
        System.out.println(inputStream.readUTF());

        socket.close();
    }
}