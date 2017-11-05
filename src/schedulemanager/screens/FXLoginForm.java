/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulemanager.screens;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Represents the Application Login Form
 * @author Olavo Henrique Dias
 */
public class FXLoginForm extends FXScreen {
    
    /* The default name for this form */
    private static final String DEFAULTTITLE = "Schedule Manager";

    /**
     * Initializes a new FXLoginForm
     * 
     * @param cssPath           The CSS Path
     */
    public FXLoginForm(String cssPath) {
        this(cssPath, DEFAULTTITLE);
    }

    /**
     * Initializes a new FXLoginForm
     * 
     * @param cssPath           The CSS Path
     * @param title             The Screen Title
     */
    public FXLoginForm(String cssPath, String title) {
        super(cssPath, title);
        super.setSize(450, 450);
        
        /* Creates the Scene itself */
        this.createScene();
    }

    /**
     * Creates the Part Setup Screen
     */
    @Override
    public final void createScene()
    {
        /***********************************************************************
         * Header of the Screen 
         ***********************************************************************/
        
        /* Horizontal Box */
        HBox hBoxHeader = new HBox();
        hBoxHeader.setAlignment(Pos.CENTER);
        hBoxHeader.setMinHeight(30);
        hBoxHeader.setPadding(new Insets(12));
        hBoxHeader.getStyleClass().add("hbox-header-small");
        
        /* WGU Logo */
        Image image = new Image("schedulemanager/wguLogo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        
        hBoxHeader.getChildren().add(imageView);
        
        /***********************************************************************
         * Footer of the Screen 
         ***********************************************************************/

        /* Button to Load Default Values */
        Button btnBottom_Login = new Button();
        btnBottom_Login.setText("LOGIN");
        btnBottom_Login.setPrefSize(100, 25);
        btnBottom_Login.getStyleClass().add("button-type2");        
        btnBottom_Login.setOnAction((ActionEvent e) -> { 
        
            /* Calls the event handler */
            //handleLoadTestDataButtonAction(e);
        });

        /* Button to Exit */
        Button btnBottom_Exit = new Button();
        btnBottom_Exit.setText("EXIT");
        btnBottom_Exit.setPrefSize(100, 25);
        btnBottom_Exit.getStyleClass().add("button-type2");        
        
        btnBottom_Exit.setOnAction(e -> Platform.exit());
        
        /* Box to wrap the Button */
        HBox hBoxBottom = new HBox(btnBottom_Login, btnBottom_Exit);
        hBoxBottom.setPrefHeight(57);
        hBoxBottom.setAlignment(Pos.CENTER_RIGHT);
        hBoxBottom.setPadding(new Insets(0, 20, 0, 0));
        hBoxBottom.setSpacing(6);
        hBoxBottom.getStyleClass().add("hbox-bottom");
        
        /***********************************************************************
         * Center of the Screen
         ***********************************************************************/

        /***********************************************************************
         * Sets the Scene
         ***********************************************************************/
        BorderPane border = new BorderPane();
        border.setTop(hBoxHeader);
        border.setBottom(hBoxBottom);

        super.scene = new Scene(border, super.getWidth(), super.getHeight());
        super.applyCss();
    }
    
}
