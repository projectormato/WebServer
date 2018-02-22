import java.io.*;
import javax.servlet.http.*;

public class GenerateCSV extends HttpServlet {
    private static final String zodiacSigns[] = {
        "���Ђ���", "��������", "�ӂ�����", "���ɍ�",
        "������", "���Ƃߍ�", "�Ă�т��", "�������",
        "���č�", "�€��", "�݂����ߍ�","������",
    };
    private static final String fortunes[] = {
        "���b�L�[", "�ӂ�", "�ň�"
    };
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
         response.setContentType("text/csv;charset=Shift_JIS");
         response.setHeader("Content-Disposition",
                    "attachment; filename=\"horoscope.csv\"");
         PrintWriter out = response.getWriter();

         for (int i = 0; i < zodiacSigns.length; i++) {
             out.print("\"" + zodiacSigns[i] + "\",");
             out.print("\"" + fortunes[(int)(Math.random() * fortunes.length)]
                       + "\"\r\n");
         }

    }
}
