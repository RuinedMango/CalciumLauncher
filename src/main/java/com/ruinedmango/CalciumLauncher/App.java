package com.ruinedmango.CalciumLauncher;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.to2mbn.jmccc.auth.AuthenticationException;
import org.to2mbn.jmccc.launch.LaunchException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	private static Pack example = new Pack("RLCraft", "forge", "1.12.2", "14.23.5.2860", null);
	private static boolean offline = false;
	
    @Override
    public void start(Stage stage) throws AuthenticationException, LaunchException, IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        try {
			example.install();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        var startButton = new Button("Start");
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	CalciumAuth auth = new CalciumAuth(offline, "Goofy");
            	PackRunner runner = new PackRunner(example, auth);
            	runner.start();
            } 
        }; 
        
        startButton.setOnAction(event);
        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label, startButton), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}