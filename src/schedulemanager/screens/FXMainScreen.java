/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulemanager.screens;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Represents the Main Application Screen
 * @author Olavo Henrique Dias
 */
public class FXMainScreen extends FXScreen {

    /* The default name for this form */
    private static final String DEFAULTTITLE = "Schedule Manager";
    
    /***************************************************************************
     * FXLoginForm Implementation
     ***************************************************************************/

    /**
     * Initializes a new FXMainScreen
     * 
     * @param cssPath           The CSS Path
     */
    public FXMainScreen(String cssPath) {
        this(cssPath, DEFAULTTITLE);
    }

    /**
     * Initializes a new FXMainScreen
     * 
     * @param cssPath           The CSS Path
     * @param title             The Screen Title
     */
    public FXMainScreen(String cssPath, String title) {
        super(cssPath, title);
        super.setSize(900, 450);
                
        /* Creates the Scene itself */
        this.createScene();
    }

    /**
     * Creates the Part Setup Screen
     */
    @Override
    public final void createScene()
    {
        /******************************************
         * Header
         *****************************************/
        
        /* Label for Title */
        Label lblHeader_Title = new Label();
        lblHeader_Title.setText(super.getTitle());
        lblHeader_Title.getStyleClass().add("label-header");

        /* WGU Logo */
        Image image = new Image("schedulemanager/wguLogo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        /* Grid to Display Title and Logo */
        GridPane gridHeader = new GridPane();
        gridHeader.setAlignment(Pos.CENTER);
        gridHeader.setMinHeight(60);
        gridHeader.setPadding(new Insets(15));
        gridHeader.getStyleClass().add("hbox-header");
        
        /* Create Column Constraints */
        ColumnConstraints[] colConstraintsGridHeader = new ColumnConstraints[2];
        
        colConstraintsGridHeader[0] = new ColumnConstraints();
        colConstraintsGridHeader[0].setPercentWidth(70);
        colConstraintsGridHeader[0].setHalignment(HPos.LEFT); 
        
        colConstraintsGridHeader[1] = new ColumnConstraints();
        colConstraintsGridHeader[1].setPercentWidth(30);
        colConstraintsGridHeader[1].setHalignment(HPos.RIGHT); 
        
        gridHeader.getColumnConstraints().addAll(colConstraintsGridHeader);
        
        gridHeader.add(lblHeader_Title, 0, 0);
        gridHeader.add(imageView, 1, 0);
        
        /***********************************************************************
         * Bottom
         **********************************************************************/

        /* Button to Exit */
        Button btnBottom_Exit = new Button();
        btnBottom_Exit.setText("EXIT");
        btnBottom_Exit.setPrefSize(100, 25);
        btnBottom_Exit.getStyleClass().add("button-type2");        
        
        btnBottom_Exit.setOnAction(e -> Platform.exit());
        
        /* Box to wrap the Button */
        HBox hBoxBottom = new HBox(btnBottom_Exit);
        hBoxBottom.setPrefHeight(57);
        hBoxBottom.setAlignment(Pos.CENTER_RIGHT);
        hBoxBottom.setPadding(new Insets(0, 20, 0, 0));
        hBoxBottom.setSpacing(6);
        hBoxBottom.getStyleClass().add("hbox-bottom");
        
        /***********************************************************************
         * Center
         **********************************************************************/

        /***********************************************************************
         * Border Pane
         **********************************************************************/
        BorderPane border = new BorderPane();
        border.setTop(gridHeader);
        //border.setCenter(gridCenter);
        border.setBottom(hBoxBottom);

        /***********************************************************************
         * Create the Scene
         **********************************************************************/
        super.scene = new Scene(border, super.getWidth(), super.getHeight());
        super.applyCss();
    }
    
    @Override
    public final void applyLocale() {
        
    }
    
}
