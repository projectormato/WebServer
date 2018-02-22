import java.io.*;
import java.net.*;

public class TestServer {
    public static void main(String[] argv) throws Exception {
        try (ServerSocket server = new ServerSocket(8001);
             FileOutputStream fos = new FileOutputStream("server_recv.txt")) {
            System.out.println("�N���C�A���g����̐ڑ���҂��܂��B");
            Socket socket = server.accept();
            System.out.println("�N���C�A���g�ڑ��B");
  
            int ch;
            // �N���C�A���g����󂯎�������e��server_recv.txt�ɏo��
            InputStream input = socket.getInputStream();
            while ((ch = input.read()) != -1) {
                fos.write(ch);
            }
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}