package com.kmaebashi.henacat.util;
import java.io.*;
import java.util.*;
import java.text.*;

public class Util {
    // InputStream����̃o�C�g����A�s�P�ʂœǂݍ��ރ��[�e�B���e�B���\�b�h
    public static String readLine(InputStream input) throws IOException {
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
    public static void writeLine(OutputStream output, String str)
        throws  IOException {
        for (char ch : str.toCharArray()) {
            output.write((int)ch);
        }
        output.write((int)'\r');
        output.write((int)'\n');
    }

    // ���ݎ�������AHTTP�W���ɍ��킹�ăt�H�[�}�b�g���ꂽ���t�������Ԃ�
    public static String getDateStringUtc() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss",
                                             Locale.US);
        df.setTimeZone(cal.getTimeZone());
        return df.format(cal.getTime()) + " GMT";
    }

    // �g���q��Content-Type�̑Ή��\
    private static final HashMap<String, String> contentTypeMap =
        new HashMap<String, String>() {{
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
    public static String getContentType(String ext) {
        String ret = contentTypeMap.get(ext.toLowerCase());
        if (ret == null) {
            return "application/octet-stream";
        } else {
            return ret;
        }
    }
    
    // ���N�G�X�g(����)�w�b�_�𖼑O�ƒl�ɕ������AheaderMap�ɒǉ�����B
    public static void parseHeader(Map<String, String> headerMap,
         String line) {
        int colonPos = line.indexOf(':');
        if (colonPos == -1)
            return;

        String headerName = line.substring(0, colonPos).toUpperCase();
        String headerValue = line.substring(colonPos + 1).trim();
        headerMap.put(headerName, headerValue);
    }
    
    // Content-Type�̕�������p�[�X����
    public static ContentType parseContentType(String str) {
        String[] temp = str.split(" *; *");
        String[] typeSubType = temp[0].split("/");
        String type = typeSubType[0];
        String subType = null;
        if (typeSubType.length > 1) {
            subType = typeSubType[1];
        }
        Map<String, String> attributes = new HashMap<String, String>(); 
        
        for (int i = 1; i < temp.length; i++) {
            String[] keyValue = temp[i].split("=");
            attributes.put(keyValue[0].toUpperCase(), keyValue[1]);
        }
        
        return new ContentType(type, subType, attributes);
    }
}
