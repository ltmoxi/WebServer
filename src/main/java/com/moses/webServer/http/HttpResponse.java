package com.moses.webServer.http;

import java.net.Socket;

public class HttpResponse {
    private Socket socket;
    public HttpResponse(Socket socket) {
        this.socket = socket;
    }
}
