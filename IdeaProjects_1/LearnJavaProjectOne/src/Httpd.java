import sun.java2d.pipe.SpanShapeRenderer;

import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Httpd implements Runnable, LogMessage
{
    private int port;
    private String docRoot;
    private LogMessage log;
    private Hashtable cache = new Hashtable();
    private boolean stopFlag;

    private static String version = "1.0";
    private static String mime_text_html = "text/html";
    private static String CRLF = "\r\n";
    private static String indexfile = "index.html";
    private static int buffer_size = 8192;
    static String mt[] = {"txt", "text/plain", "html", mime_text_html,
            "htm", "text/html", "gif", "image/gif", "jpg", "image/jpg",
            "jpeg", "image/jpg", "class", "application/octet-stream"};
    static String defaultExt = "txt";
    static Hashtable types = new Hashtable();
    static
    {
        for(int i = 0; i < mt.length; i+=2)
            types.put(mt[i],mt[i + 1]);
    }
    static String fnameToMimeType(String filename)
    {
        if(filename.endsWith("/"))
            return mime_text_html;
        int dot = filename.lastIndexOf('.');
        String ext = (dot > 0) ? filename.substring(dot  + 1) : defaultExt;
        String ret = (String) types.get(ext);
        return ret != null ? ret : (String)types.get(defaultExt);
    }
    int hits_served = 0;
    int bytes_served = 0;
    int files_in_cache = 0;
    int bytes_in_cache = 0;
    int hits_to_cache = 0;

    private final byte toBytes(String s)[]
    {
        byte b[] = s.getBytes();
        return b;
    }
    private MimeHeader makeMimeHeader(String type, int length)
    {
        MimeHeader mh = new MimeHeader();
        Date curDate = new Date();
        TimeZone gmtTz = TimeZone.getTimeZone("GMT");
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        sdf.setTimeZone(gmtTz);
        mh.put("Date", sdf.format(curDate));
        mh.put("Server", "JavaCompleteReference/" + version);
        mh.put("Content-Type",type);
        if(length >= 0)
            mh.put("Content-Length", String.valueOf(length));
        return mh;
    }
    private String error(int code, String msg, String url)
    {
        String html_page = "<body>" + CRLF + "<h1>" + code + " " + msg + "<h1>" + CRLF;
        if(url != null)
            html_page += "Error when fetching URL: " + url + CRLF;
        html_page += "</body>" + CRLF;
        MimeHeader mh = makeMimeHeader(mime_text_html, html_page.length());
        HttpResponse hr = new HttpResponse(code,msg,mh);
        
        logEntry("GET", url, code, 0);
        return hr + html_page;
    }
}
