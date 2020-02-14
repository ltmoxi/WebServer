package com.moses.webServer.http;

import java.io.InputStream;
import java.net.Socket;

public class HttpRequest {
    private Socket socket;
    private InputStream in;

    public HttpRequest(Socket socket) {
        try {
            System.out.println("正在解析请求信息.....");
            this.socket = socket;
            in = socket.getInputStream();
            //构造HttpRequest对象时解析请求信息
            parseRequestLine();
            parseHeaders();
            parseContent();
            System.out.println("请求信息解析完毕");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //解析消息头
    private void parseRequestLine() {
        String data;
        while (!(data = readLine()).equals("")) {
            System.out.println(data);
        }
        System.out.println("消息头解析完毕");
    }

    //解析请求头
    private void parseHeaders() {

    }

    //解析正文
    private void parseContent() {

    }


    private String readLine() {
        StringBuilder line = new StringBuilder();
        int data;
        char c1, c2 = '1';
        try {
            while ((data = in.read()) != -1) {
                c1 = (char) data;
                if (c1 == '\n' && c2 == '\r') {
                    break;
                }
                c2 = c1;
                line.append(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line.toString().trim();
    }

}
