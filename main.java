package com.example.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws LineUnavailableException, InterruptedException {

            primaryStage.setTitle("Game Room");
            Group root = new Group();
            TextArea ta = new TextArea();
            TextArea userList = new TextArea();
            Scene scene = new Scene(root, 640, 480);
            TextArea ta2 = new TextArea();
            AudioFormat format = new AudioFormat(1600, 8, 2,true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            Font font = new Font();


            System.out.println("Ended sound test");


            ta2.setEditable(false);
            String name = "Chase";

            userList.setPrefSize(170, 300);
            userList.setLayoutX(460);
            userList.setLayoutY(20);
            userList.setEditable(false);
            userList.appendText(name + "\n");
            userList.appendText("Tommy" + "\n");


            Button sendBtn = new Button("Send");
            Button webcamBtn = new Button("Webcam");
            Button fileBtn = new Button("File");
            Button emojiBtn = new Button("Emoji");
            Button micBtn = new Button("Mic");



            ta.setPrefSize(360, 100); // resize the box itself
            ta.setLayoutX(20); // x axis positioning
            ta.setLayoutY(360); // y axis positioning
            ta.setFont(new Font("Comic-Sans", 16));
            ta.getText();

            ta2.setLayoutX(20);
            ta2.setLayoutY(20);
            ta2.setPrefSize(360, 300);

            micBtn.setLayoutX(200);
            micBtn.setLayoutY(325);
            micBtn.setPrefSize(70,30);


            sendBtn.setPrefSize(60, 60); // resize the box itself
            sendBtn.setLayoutX(470); // x axis positioning
            sendBtn.setLayoutY(350); // y axis positioning


            // When microphone button is pressed, it will begin recording voice.
            micBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent)  {
                            if(!AudioSystem.isLineSupported(info)){
                                    System.out.println("Line is not supported");
                            }

                            TargetDataLine targetDataLine = null;
                            try {
                                    targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
                            } catch (LineUnavailableException e) {
                                    e.printStackTrace();
                            }

                            try {
                                    targetDataLine.open();
                            } catch (LineUnavailableException e) {
                                    e.printStackTrace();
                            }

                            System.out.println("Started Recording");

                            targetDataLine.start();

                            TargetDataLine finalTargetDataLine = targetDataLine;
                            Thread stopper = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                            AudioInputStream audioStream = new AudioInputStream(finalTargetDataLine);

                                            File wavFile = new File("C://Test.wav");
                                            try {
                                                    AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, wavFile);
                                            } catch (IOException e) {
                                                    e.printStackTrace();
                                            }
                                    }
                            });

                            stopper.start();

                            try {
                                    // this has to do with the amount of time you can talk on the microphone before the thread sleeper engages.
                                    Thread.sleep(9000000);
                            } catch (InterruptedException e) {
                                    e.printStackTrace();
                            }

                            try {
                                    AudioSystem.getLine(info);
                            } catch (LineUnavailableException e) {
                                    e.printStackTrace();
                            }

                            targetDataLine.stop();

                            //targetDataLine.close();

                    }
            });



            ta.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent j) {
                            if(j.getCode().equals(KeyCode.ENTER)) {
                                    String str = ta.getText();
                                    // this will append text to the chat box above
                                    ta2.appendText(name + ": " + str + "\n");
                            }
                    }
            });

            sendBtn.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent k) {
                            if(k.getCode().equals(KeyCode.ENTER)){
                                    String str = ta.getText();
                                    // this will append text to the chat box above
                                    ta2.appendText(str + "\n");

                            }

                    }
            });




            root.getChildren().add(userList);
            root.getChildren().add(sendBtn);
            root.getChildren().add(ta);
            root.getChildren().add(micBtn);
            root.getChildren().add(ta2);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) throws LineUnavailableException, InterruptedException {

            Application.launch(args); // will launch javaFX





        }



    }

