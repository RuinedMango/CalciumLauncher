package com.ruinedmango.CalciumLauncher;

import java.io.IOException;

import org.to2mbn.jmccc.auth.AuthenticationException;
import org.to2mbn.jmccc.launch.LaunchException;

public class PackRunner extends Thread{
	private Pack runnable;
	private CalciumAuth auth;
	
	public PackRunner(Pack pack, CalciumAuth auth) {
		runnable = pack;
		this.auth = auth;
	}
	
	public void run() {
    	auth.start();
    	while(!auth.done) {
    		
    	}
		try {
			runnable.run(auth);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LaunchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
