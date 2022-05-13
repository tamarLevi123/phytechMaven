package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class PhytechOnlineApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(PhytechOnlineApplication.class, args);
    }
}
