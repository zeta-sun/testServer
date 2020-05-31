package com.sun;

import com.sun.util.Handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTomcat {

    public static void main(String[] args) {
        try {
            //定义一个服务端
            System.out.println("----------server start!----------");
            ServerSocket server = new ServerSocket(8888);
            while (true){
                //接受客户端的请求
                Socket socket = server.accept();
                //创建线程
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
