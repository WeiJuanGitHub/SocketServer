package com.feicui.socketserve.socketserver;

/**
 * Created by dian on 2017/4/19.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**服务端
 * 1.创建一个服务端的Sockent
 * 2.接收连接到此服务端的客户端Sockent
 * 3.打开连接的客户端的Sockent的输入输出流
 * 4.对Sockent
 */

public class MyServer {

    //程序的入口
    public  static  void  main(String [] args) throws IOException {

        //1.创建Sockent的服务
        ServerSocket serverSocket = new ServerSocket(3700);

        // 2. 接收连接的客户端
        while (true){
            // 拿到连接的Socket
            Socket socket = serverSocket.accept();
            System.out.println("connect success");

            // 为每一个连接的Socket开启一个单独的线程去处理
            new Thread(new ServerThread(socket)).start();
        }

    }
}
