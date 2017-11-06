/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulemanager;

import java.util.Locale;
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
        
        /***********************************************************************
         * Dear Evaluator: 
         *
         * 1) I added English and Portuguese as the languages available.
         * The user will have a combo box to select the language
         * Any other language as expected will result in using the default 
         * language, which is English.
         * 
         * Locale.setDefault(new Locale("en"));
         * Locale.setDefault(new Locale("pt"));
         * 
         * 2) The application does not require us to maintain users, 
         * so I'd suggest the use of user "test" and password "test".
         ***********************************************************************/
                
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
