import java.net.*;
import java.io.*;

public class Project06_A_Server {
    public static void main(String[] args) {
//        ServerSocket ss = new ServerSocket();
        ServerSocket ss = null;

        try{
            ss = new ServerSocket(9999);
            System.out.println("Server ready....");

        }
        catch (Exception e) {
            e.printStackTrace();}
        while(true){
            try {
                Socket socket = ss.accept();
                System.out.println("Client connect success!");
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                String message = dis.readUTF();
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("[ECHO] " + message  + "(from Server)");
                dos.close();
                dis.close();
                socket.close();
                System.out.println("client connect close....");

            }catch (Exception e) {e.printStackTrace();}
        }//while

    }//main
}//class
