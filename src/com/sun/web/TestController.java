package com.sun.web;

import com.sun.util.HttpServlet;
import com.sun.util.HttpServletRequest;
import com.sun.util.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

public class TestController extends HttpServlet {


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //响应回去
        System.out.println("这是你们要找的资源！");
        //输出流
        Writer writer= response.getWriter();
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("Content-Type: text/html;charset=utf-8\n\n");
        writer.write("<html>");
        writer.write("     <body>");
        writer.write("         hello,word!");
        writer.write("     </body>");
        writer.write("</html>");
        writer.flush();
        writer.close();
    }
}
