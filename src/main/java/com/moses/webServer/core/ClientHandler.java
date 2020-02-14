package com.moses.webServer.core;

import com.moses.webServer.http.HttpRequest;
import com.moses.webServer.http.HttpResponse;

import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+":  线程在运行");
        HttpRequest request = new HttpRequest(socket);
        HttpResponse response = new HttpResponse(socket);
    }
}
