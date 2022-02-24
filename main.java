package com.example.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {

            primaryStage.setTitle("Hello World");
            Group root = new Group();
            TextField tf = new TextField();
            TextArea userList = new TextArea();
            Scene scene = new Scene(root, 640, 480);
            TextArea ta2 = new TextArea();
            ta2.setEditable(false);

            userList.setPrefSize(170, 300);
            userList.setLayoutX(460);
            userList.setLayoutY(20);



            Button sendBtn = new Button("Send");
            Button webcamBtn = new Button("Webcam");
            Button micBtn = new Button("Mic");
            Button fileBtn = new Button("File");
            Button emojiBtn = new Button("Emoji");
            Button displayPic = new Button("Display");


            Image image = new Image("C:\\Users\\Wojak\\Desktop\\The_GNU_logo.png"); // file extension has to be exact or crazy exception errors will run. Also helps to run this in admin mode.

            tf.setPrefSize(340, 100); // resize the box itself
            tf.setLayoutX(20); // x axis positioning
            tf.setLayoutY(300); // y axis positioning
            tf.setFont(new Font("Comic-Sans", 16));
            tf.getText();

            ta2.setPrefSize(320, 280);


            File file = new File("C:\\\\Users\\\\Wojak\\\\Desktop\\\\The_GNU_logo.png\""); // building a display box for later. We need to create a dialog box to allow the user to choose whatever image


            ImageView imageView = new ImageView(image);
            imageView.getOnMouseClicked(); // this is reserved
            // keeping pixel consistent with size of box
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(440);
            imageView.setLayoutY(300);



            sendBtn.setPrefSize(60, 60); // resize the box itself
            sendBtn.setLayoutX(370); // x axis positioning
            sendBtn.setLayoutY(300); // y axis positioning
            sendBtn.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent k) {
                            if(k.getCode().equals(KeyCode.ENTER)){
                                    String str = tf.getText();
                                    // this will append text to the chat box above
                                    ta2.appendText(str + "\n");
                            }

                    }
            });


            displayPic.setPrefSize(100,100);
            displayPic.setLayoutY(300);
            displayPic.setLayoutX(440);

            root.getChildren().add(userList);
            root.getChildren().add(sendBtn);
            root.getChildren().add(tf);
            root.getChildren().add(displayPic);
            root.getChildren().add(imageView);
            //root.getChildren().add(ta2);
            root.getChildren().add(ta2);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) throws LineUnavailableException, InterruptedException {

            Application.launch(args); // will launch javaFX
/*
            AudioFormat format = new AudioFormat(1600, 8, 2,true, true);

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            if(!AudioSystem.isLineSupported(info)){
                System.out.println("Line is not supported");
            }

            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);

            targetDataLine.open();

            System.out.println("Started Recording");

            targetDataLine.start();

            Thread stopper = new Thread(new Runnable() {
                @Override
                public void run() {
                    AudioInputStream audioStream = new AudioInputStream(targetDataLine);

                    File wavFile = new File("C://Test.wav");
                    try {
                        AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, wavFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            stopper.start();

            Thread.sleep(5200);

            AudioSystem.getLine(info);

            targetDataLine.stop();

            targetDataLine.close();

            System.out.println("Ended sound test");
            */


        }



    }

