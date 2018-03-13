package chap3.Henacat_0_1.servlet.http;
import java.io.*;

public interface HttpServletRequest {
    String getMethod();
    String getParameter(String name);
    String[] getParameterValues(String name);
    void setCharacterEncoding(String env) throws UnsupportedEncodingException;
}
