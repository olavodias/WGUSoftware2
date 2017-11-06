/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulemanager;

import javafx.application.Application;
import javafx.stage.Stage;
import schedulemanager.screens.FXLoginForm;

/**
 * The Schedule Manager Program
 * @author Olavo Henrique Dias
 */
public class ScheduleManager extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        /***********************************************************************
         * Create the Main Screen
         **********************************************************************/
        FXLoginForm formMainScreen = new FXLoginForm("schedulemanager/wguTheme.css");
        formMainScreen.setCurrentStage(primaryStage);
                
        primaryStage.setTitle(formMainScreen.getTitle());
        primaryStage.setScene(formMainScreen.getScene());
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(450);
        primaryStage.setResizable(false);
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
