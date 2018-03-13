package chap3.Henacat_0_1.servlet;

public class ServletException extends Exception {
    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable rootCause)  {
        super(message, rootCause);
    }

    public ServletException(Throwable rootCause) {
        super(rootCause);
    }
}
