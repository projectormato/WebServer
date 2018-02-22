import java.io.*;
import javax.servlet.http.*;

public class ShowBBS extends HttpServlet {
    // HTML�ňӖ������������G�X�P�[�v���郆�[�e�B���e�B���\�b�h
    private String escapeHtml(String src) {
        return src.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"",  "&quot;")
                .replace("'",  "&#39;");
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>�e�X�g�f����</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>�e�X�g�f����</h1>");
        out.println("<form action='/testbbs/PostBBS' method='post'>");
        out.println("�^�C�g���F<input type='text' name='title' size='60'>"
                    + "<br/>");
        out.println("�n���h�����F<input type='text' name='handle'><br/>");
        out.println("<textarea name='message' rows='4' cols='60'>"
                    + "</textarea><br/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("<hr/>");
        
        for (Message message : Message.messageList) {
            out.println("<p>�w" + escapeHtml(message.title) + "�x&nbsp;&nbsp;"
                        + escapeHtml(message.handle) + " ����&nbsp;&nbsp;"
                        + escapeHtml(message.date.toString()) + "</p>");
            out.println("<p>");
            out.println(escapeHtml(message.message).replace("\r\n", "<br/>"));
            out.println("</p><hr/>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}
