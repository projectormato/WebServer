import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] argv) throws Exception {
        try (ServerSocket server = new ServerSocket(8001);
             FileOutputStream fos = new FileOutputStream("server_recv.txt");
             FileInputStream fis = new FileInputStream("server_send.txt")) {
            System.out.println("�N���C�A���g����̐ڑ���҂��܂��B");
            Socket socket = server.accept();
            System.out.println("�N���C�A���g�ڑ��B");

            int ch;
            // �N���C�A���g����󂯎�������e��server_recv.txt�ɏo��
            InputStream input = socket.getInputStream();
            // �N���C�A���g�́A�I���̃}�[�N�Ƃ���0�𑗕t���Ă���
            while ((ch = input.read()) != 0) {
                fos.write(ch);
            }
            // server_send.txt�̓��e���N���C�A���g�ɑ��t
            OutputStream output = socket.getOutputStream();
            while ((ch = fis.read()) != -1) {
                output.write(ch);
            }
            socket.close();
            System.out.println("�ʐM���I�����܂����B");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}