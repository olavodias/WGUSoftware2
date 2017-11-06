/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulemanager.screens;

import java.util.Locale;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

/**
 * Represents the Application Login Form
 * @author Olavo Henrique Dias
 */
public class FXLoginForm extends FXScreen {
    
    /* The default name for this form */
    private static final String DEFAULTTITLE = "Schedule Manager";
    
    /* The default bundle name for this form */
    private static final String DEFAULTBUNDLE = "schedulemanager.screens/FXLoginForm";
    
    /***************************************************************************
     * UI Elements
     ***************************************************************************/

    /* Label Header */
    Label lblHeader = new Label();
    
    /* Buttons */
    Button btnBottom_Exit = new Button();
    Button btnBottom_Login = new Button();
    
    /* User Name */
    Label lblField_UserName = new Label();
    TextField txtField_UserName = new TextField();
    
    /* Password */
    Label lblField_Password = new Label();
    PasswordField txtField_Password = new PasswordField();
    
    /* Locale ComboBox */
    Label lblField_Locale = new Label();    
    ComboBox cboField_Locale = new ComboBox();

    /***************************************************************************
     * FXLoginForm Implementation
     ***************************************************************************/

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
        
        /* Sets the Localization */
        this.setLocale(Locale.getDefault(), DEFAULTBUNDLE);
        
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
        btnBottom_Login = new Button();
        btnBottom_Login.setText(super.getResourceBundle().getString("btn_login"));
        btnBottom_Login.setPrefSize(100, 25);
        btnBottom_Login.getStyleClass().add("button-type2");        
        btnBottom_Login.setOnAction((ActionEvent e) -> { 
            /* Calls the event handler */
            handleLoginButtonAction(e);
        });

        /* Button to Exit */
        btnBottom_Exit = new Button();
        btnBottom_Exit.setText(super.getResourceBundle().getString("btn_exit"));
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

        /* Grid to Store Labels and Fields */
        GridPane gridCenter = new GridPane(); 
        gridCenter.setMaxWidth(300);
        gridCenter.setAlignment(Pos.CENTER);
        
        ColumnConstraints[] colConstraintsGridCenter = new ColumnConstraints[2];

        colConstraintsGridCenter[0] = new ColumnConstraints();
        colConstraintsGridCenter[0].setPercentWidth(30);

        colConstraintsGridCenter[1] = new ColumnConstraints();
        colConstraintsGridCenter[1].setPercentWidth(70);

        gridCenter.getColumnConstraints().addAll(colConstraintsGridCenter);
        
        RowConstraints[] rowConstraintsGridCenter = new RowConstraints[5];
        
        rowConstraintsGridCenter[0] = new RowConstraints();
        rowConstraintsGridCenter[0].setPrefHeight(70);
        rowConstraintsGridCenter[0].setValignment(VPos.CENTER);        
        
        rowConstraintsGridCenter[1] = new RowConstraints();
        rowConstraintsGridCenter[2] = new RowConstraints();
        rowConstraintsGridCenter[3] = new RowConstraints();

        rowConstraintsGridCenter[4] = new RowConstraints();        
        rowConstraintsGridCenter[4].setPrefHeight(70);
        
        gridCenter.getRowConstraints().addAll(rowConstraintsGridCenter);
        
        lblHeader = new Label();
        lblHeader.setText(super.getResourceBundle().getString("string_formheader"));
        lblHeader.setPrefWidth(300);
        lblHeader.setAlignment(Pos.CENTER);
        
        lblHeader.getStyleClass().add("label-header-small");
        
        gridCenter.add(lblHeader, 0, 0, 2, 1);
               
        /* Set UI Objects */
        lblField_UserName.setText(super.getResourceBundle().getString("string_user"));
        gridCenter.add(lblField_UserName, 0, 1);
        gridCenter.add(txtField_UserName, 1, 1);

        lblField_Password.setText(super.getResourceBundle().getString("string_password"));
        txtField_Password.setPromptText(super.getResourceBundle().getString("string_password_prompttext"));
        gridCenter.add(lblField_Password, 0, 2);
        gridCenter.add(txtField_Password, 1, 2);

        /* For the Localization ComboBox, add valid languages */
        lblField_Locale.setText(super.getResourceBundle().getString("string_locale"));
        cboField_Locale.getItems().addAll("en","pt");
        cboField_Locale.setEditable(false);
        
        /* Select Current Language or English as the Default */
        String currentLanguage = Locale.getDefault().getLanguage();
        
        if (cboField_Locale.getItems().contains(currentLanguage))
            cboField_Locale.getSelectionModel().select(Locale.getDefault().getLanguage());
        else
            cboField_Locale.getSelectionModel().select("en");
        
        /* Add event handler for when the user changes the language */
        cboField_Locale.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                setLocale(new Locale(t1), DEFAULTBUNDLE);
                applyLocale();
            }
        });
        
        /* Add elements to the grid */
        gridCenter.add(lblField_Locale, 0, 3);
        gridCenter.add(cboField_Locale, 1, 3);
        
        /***********************************************************************
         * Sets the Scene
         ***********************************************************************/
        BorderPane border = new BorderPane();
        border.setTop(hBoxHeader);
        border.setCenter(gridCenter);
        border.setBottom(hBoxBottom);

        super.scene = new Scene(border, super.getWidth(), super.getHeight());
        super.applyCss();
    }
    
    /**
     * Apply the Localized Strings to the fields
     */
    @Override
    public final void applyLocale() {
        btnBottom_Login.setText(super.getResourceBundle().getString("btn_login"));
        btnBottom_Exit.setText(super.getResourceBundle().getString("btn_exit"));

        lblHeader.setText(super.getResourceBundle().getString("string_formheader"));

        lblField_UserName.setText(super.getResourceBundle().getString("string_user"));
        lblField_Password.setText(super.getResourceBundle().getString("string_password"));
        txtField_Password.setPromptText(super.getResourceBundle().getString("string_password_prompttext"));

        lblField_Locale.setText(super.getResourceBundle().getString("string_locale"));
    }
    
    private void handleLoginButtonAction(ActionEvent event) {
        
        /* Validate the User and Password against the database */
        
        /* Calls the new screen */
        FXMainScreen mainScreen = new FXMainScreen(this.getCssPath());
        mainScreen.show();
        
        super.getCurrentStage().close();
    }
}
