package com.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleMicroservice {
    public static void main(String[] args) throws IOException {
        int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/hellojava", new HelloHandler());
        server.createContext("/api/Goodbyejava", new GoodbyeHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port " + port);
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            // CORSヘッダーの追加
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
        
            String response = "Hello, World!-Java";
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }        
    }

    static class GoodbyeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            // CORSヘッダーの追加
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
        
            String response = "Goodbye, World!-Java";
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        
    }
}
