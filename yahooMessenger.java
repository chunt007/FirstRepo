package com.example.project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class yahooMessenger extends Application {
@Override
    public void start(Stage primaryStage) {




        // create a new text area
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Yahoo Messenger");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                // listen for and accept a connection
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("Server started :"));

               Socket socket = serverSocket.accept();

                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    double radius = inputFromClient.readDouble();

                    double area = radius * radius * Math.PI;

                    outputToClient.writeDouble(area);

                    Platform.runLater(() -> {
                        ta.appendText("Radius received from client: " + radius + "\n");
                        ta.appendText("Area is: " + area + '\n');
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        }




}