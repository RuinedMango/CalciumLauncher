package com.ruinedmango.CalciumLauncher;

import org.to2mbn.jmccc.auth.AuthInfo;
import org.to2mbn.jmccc.auth.AuthenticationException;
import org.to2mbn.jmccc.auth.Authenticator;
import org.to2mbn.jmccc.auth.OfflineAuthenticator;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import jmccc.microsoft.MicrosoftAuthenticator;

public class CalciumAuth extends Thread implements Authenticator{
	private String name;
	private Boolean offline;
	private AuthInfo authinfo = null;
	public Boolean done = false;
	
	
	public CalciumAuth(Boolean offline, String name) {
		this.name = name;
		this.offline = offline;
	}
	
	@Override
	public AuthInfo auth() throws AuthenticationException {
		return authinfo;
	}
	
	public void run() {
		if(offline) {
			try {
				authinfo = new OfflineAuthenticator(name).auth();
				done = true;
				interrupt();
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
	    	MicrosoftAuthenticator.setClientId("09abef53-b1af-4401-88b7-4bb2a412df74");
	    	MicrosoftAuthenticator auth = null;
			try {
				auth = MicrosoftAuthenticator.login(it -> loginWebUi(it.userCode));
				done = true;
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	authinfo = auth.auth();
	    	interrupt();
		}
	}
	
	public void loginWebUi(String userCode) {
	    javafx.application.Platform.runLater(new Runnable() {

	        @Override
	        public void run() {
	            Stage stage = new Stage();
	            WebView webView = new WebView();
	            
	            final WebEngine webEngine = webView.getEngine();
	            
	            System.out.print(userCode);
	            
	            webEngine.load("https://login.live.com/oauth20_remoteconnect.srf");
	            
	            VBox root = new VBox(webView);
	            
	            stage.setScene(new Scene(root));
	            stage.show();
	        }
	    });
	}
	
}
