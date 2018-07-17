package com.project.yourzodiac;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.project.zodiacfacts.R;

public class Splash extends Activity{
	
	@Override
	protected void onCreate(Bundle splashscreen) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(splashscreen);
		setContentView(R.layout.splash);
		
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent  mainscreenactivity=new Intent(Splash.this,MainActivity.class);
					startActivity(mainscreenactivity);
					
				}
			}
		};
		timer.start();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
