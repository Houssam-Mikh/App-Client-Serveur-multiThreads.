import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {//or extend thread
    private  Socket client;
    public ClientHandler(Socket client){
        this.client=client;
    }
    public void run(){
       try {
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        DataInputStream inputStream=new DataInputStream(client.getInputStream());
        //demander le nom et le prenom
        String message= "saisir votre nom ";outputStream.writeUTF(message);
        String nom = inputStream.readUTF();message= "saisir votre prenom ";
        outputStream.writeUTF(message);String prenom = inputStream.readUTF();message= "saisir le nombre d'article";
        outputStream.writeUTF(message);int nbrArticle = inputStream.readInt();message= "saisir le couple prix_Hors_taxe , Nombre_piece";
        outputStream.writeUTF(message);double []prix= new double[nbrArticle];int [] nbrPiece= new int[nbrArticle];
        double prix_produit;int nbrProduit;
        for(int i=0;i<nbrArticle;i++){
        message=" article "+i+"\n saisir le prix du produit " ;outputStream.writeUTF(message);
        prix_produit = inputStream.readDouble();
        message="saisir le nombre de produit \n";outputStream.writeUTF(message);
        nbrProduit=inputStream.readInt();
        prix[i]=prix_produit*nbrProduit;nbrPiece[i]=nbrProduit;
        }
        //calcule de la somme :
        double somme=0;
        for (int i=0; i<nbrArticle;i++){somme=somme+prix[i]*1.2;}
        message=" bonjour \n client: "+nom+" "+prenom+" \n vous avez achter "+nbrArticle+" articles \n";
        for (int i=0;i<nbrArticle; i++){message = message+"produit  "+i+"  avec prix "+prix[i]+" et quantité "+nbrPiece[i]+"\n";}
        message =message+"\n le prix TTC est ="+somme;outputStream.writeUTF(message);
           System.out.println("client have been served");client.close();
       }catch(IOException e){e.printStackTrace();}}
}