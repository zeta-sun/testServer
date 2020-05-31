package com.sun.util;


import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

//处理客户端传来的请求String
public class Handler extends Thread{

    private Socket socket;

    //构造函数注入传参

    public Handler(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try{
            receiveRequest();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //接受客户端传来的请求String
    private void receiveRequest() throws Exception {
        //sockets字节输入流:请求信息
        InputStream stream = socket.getInputStream();
        //传换成字符流
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        //解析客户端请求数据
        parseRequest(reader);
        reader.close();
    }

    //解析客户端请求数据
    private void parseRequest(BufferedReader reader) throws Exception {
        //读取文件
        String line = reader.readLine();
        String[] lineArr = line.split(" ");
        String method = lineArr[0]; //请求方法
        String path  = lineArr[1]; //请求资源地址
        String version = lineArr[2]; //版本号
        HttpServletRequest request = new HttpServletRequest(method, path, version);
//        while (line != null && !"".equals(line)){
//            line = reader.readLine();
//            String line2 = line.split(": ")[1];
//        }
        OutputStream outputStream = socket.getOutputStream();
        HttpServletResponse response = new HttpServletResponse(new OutputStreamWriter(outputStream));
        findResource(request, response);
    }


    //根据资源地址找资源
    private void findResource(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getRequestPath().replace("/","");
        if (path != null && !"".equals(path)){
            Class clazz = Class.forName(className(path));
            Method method1 = clazz.getMethod("service", HttpServletRequest.class, HttpServletResponse.class);
            Object obj = clazz.newInstance();
            method1.invoke(obj, request, response);
        }
    }

    private String className(String path){
        return "com.sun.web."+path+"Controller";
    }
}
