/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {

  private final static int port = 8000;
    
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress("145.37.74.49",port), 0);
      System.out.println(server.getAddress().getAddress().getHostAddress());
    server.createContext("/data", new InfoHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
  }

  static class InfoHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        System.out.println("someone is connecting!");
      String data = "Leave me alone!";
      t.sendResponseHeaders(200, data.length());
      OutputStream os = t.getResponseBody();
      os.write(data.getBytes());
      os.close();
    }
  }

}