package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String message = getMessage(input.readLine());
                    switch (message) {
                        case "Hello" -> output.write("Hello".getBytes());
                        case "Exit" -> server.close();
                        default -> output.write(message.getBytes());
                    }
                    output.flush();
                }
            }
        }
    }

    private static String getMessage(String message) {
        String regex = "msg=(\\S+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        return matcher.find() ? matcher.group(1) : "Enter correct data";
    }
}
