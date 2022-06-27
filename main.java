package com.example.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
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

            primaryStage.setTitle("Game Room 2");
            Group root = new Group();
            TextArea ta = new TextArea();
            ta.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            TextArea userList = new TextArea();
            Scene scene = new Scene(root, 640, 480);
            scene.setFill(Color.LIGHTGRAY);
            TextArea ta2 = new TextArea();
            try {
                    AudioFormat format = new AudioFormat(1600, 8, 2, true, true); //adjusting bitrate and sound quality
                    DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); // We need a line to listen in on.
            } catch (Exception e) {
                    System.out.println(e);
            }





            final String[][] Categories = {{"Games"},{"Game Room: 1", "Game Room: 2"},{"Television"},{"International"}};
            /*
            EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                            Tree tree = new Tree();
                            tree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            tree.setTitle("Join Room");
                            tree.setLayout(new BorderLayout());


                            TreeSecond mytree2 = new TreeSecond(Categories);
                            tree.add(mytree2.getJPanel(), "Center");



                            tree.setVisible(true);
                            tree.pack();


                    }
            });
        */




            ComboBox<String> fontBox = new ComboBox<>();
            fontBox.getItems().addAll("Arial","Comic-Sans","Times New Roman");
            fontBox.setStyle("-fx-color: #FFFFFF");
            ComboBox<String> fontSize = new ComboBox<>();
            fontSize.getItems().addAll("8","10","12","20","22","34");
            fontSize.setStyle("-fx-color: #FFFFFF");


            BorderPane paneForComboBox = new BorderPane();
            paneForComboBox.setCenter(fontBox);
            paneForComboBox.setPrefSize(160,200);
            paneForComboBox.setLayoutX(280);
            paneForComboBox.setLayoutY(240);

            BorderPane paneForComboBoxTwo = new BorderPane();
            paneForComboBoxTwo.setCenter(fontSize);
            paneForComboBoxTwo.setPrefSize(170, 200);
            paneForComboBoxTwo.setLayoutX(80);
            paneForComboBoxTwo.setLayoutY(240);


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

            Button micBtn = new Button("Talk");



            ta.setPrefSize(360, 100); // resize the box itself
            ta.prefWidthProperty();
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
            micBtn.setStyle("-fx-background-color:#32CD32");

            micBtn.setBorder(new Border((new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
            micBtn.setFont(Font.font("Aerial", FontWeight.BOLD, FontPosture.REGULAR, 14)); // Trying to mimic the font look of Yahoo Messenger's talk button



            EventHandler handler2 = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                            System.out.println("Based");

                    }
            };

            micBtn.setOnMouseReleased(handler2);



            Image image = new Image("C:\\Users\\Wojak\\IdeaProjects\\project\\target\\classes\\com\\example\\project\\smiley.png");
            ImageView imageView = new ImageView(image);
            //imageView.setLayoutX();
            imageView.setLayoutY(-10);


            sendBtn.setPrefSize(60, 60); // resize the box itself
            sendBtn.setLayoutX(470); // x axis positioning
            sendBtn.setLayoutY(350); // y axis positioning


            // When microphone button is pressed, it will begin recording voice.

            micBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent)  {
                        System.out.println("Yes");
                        // record stuff here


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
            root.getChildren().add(paneForComboBox);
            root.getChildren().add(paneForComboBoxTwo);
            root.getChildren().add(imageView);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) throws LineUnavailableException, InterruptedException {

            Application.launch(args); // will launch javaFX





        }



    }

