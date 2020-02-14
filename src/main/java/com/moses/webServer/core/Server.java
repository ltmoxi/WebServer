package com.moses.webServer.core;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private Server() {
        try {
            serverSocket = new ServerSocket(80);
            System.out.println("服务端初始化完成,等待客户端连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() {
        try {
            while (true) {
                socket = serverSocket.accept();
                System.out.println("SOCKET: "+socket);

                ClientHandler handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
