package chap2;

import java.io.*;
import java.util.*;
import java.text.*;

class Util {
    // InputStream����̃o�C�g����A�s�P�ʂœǂݍ��ރ��[�e�B�e�B���\�b�h
    static String readLine(InputStream input) throws Exception {
        int ch;
        String ret = "";
        while ((ch = input.read()) != -1) {
            if (ch == '\r') {
                // �������Ȃ�
            } else if (ch == '\n') {
                break;
            } else {
                ret += (char)ch;
            }
        }
        if (ch == -1) {
            return null;
        } else {
            return ret;
        }
    }

    // 1�s�̕�������A�o�C�g��Ƃ���OutputStream�ɏ�������
    // ���[�e�B���e�B���\�b�h
    static void writeLine(OutputStream output, String str)
        throws  Exception {
        for (char ch : str.toCharArray()) {
            output.write((int)ch);
        }
        output.write((int)'\r');
        output.write((int)'\n');
    }

    // ���ݎ�������AHTTP�W���ɍ��킹�ăt�H�[�}�b�g���ꂽ���t�������Ԃ�
    static String getDateStringUtc() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss",
                                             Locale.US);
        df.setTimeZone(cal.getTimeZone());
        return df.format(cal.getTime()) + " GMT";
    }

    // �g���q��Content-Type�̑Ή��\
    static final HashMap<String, String> contentTypeMap =
        new HashMap<String, String>() {
                private static final long serialVersionUID = 1L;
        {
            put("html", "text/html");
            put("htm", "text/html");
            put("txt", "text/plain");
            put("css", "text/css");
            put("png", "image/png");
            put("jpg", "image/jpeg");
            put("jpeg", "image/jpeg");
            put("gif", "image/gif");
        }
    };

    // �g���q���󂯎��Content-Type��Ԃ�
    static String getContentType(String ext) {
        String ret = contentTypeMap.get(ext.toLowerCase());
        if (ret == null) {
            return "application/octet-stream";
        } else {
            return ret;
        }
    }
}
