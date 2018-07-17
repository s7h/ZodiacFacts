package com.project.yourzodiac;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zodiacfacts.R;


public class ZodiacXMLParsing extends Activity{
	
	
	Boolean isInternetPresent = false;
	CheckInternet ci;
	TextView tv;
	ParsingXML gettingText=new ParsingXML();
	ImageButton love,view;
	String text=null;
	String sign=null;
	
	@Override
	protected void onCreate(Bundle zodiac) {
		// TODO Auto-generated method stub
		super.onCreate(zodiac);
		setContentView(R.layout.zodiacxmlparsing);
		tv=(TextView)findViewById(R.id.tv);
		love=(ImageButton)findViewById(R.id.love);
		view=(ImageButton)findViewById(R.id.view);
		final MediaPlayer mp=MediaPlayer.create(this,R.raw.click);
		
		ci = new CheckInternet(getApplicationContext());
		isInternetPresent = ci.isConnectingToInternet();
		
		
		Intent myIntent=getIntent();
		Bundle b=myIntent.getExtras();
		if (b!=null){
			sign=(String)b.get("sign");
		}
	    gettingText.parsing(sign);
		String text=gettingText.giveData();
		tv.setText(text);
		new PostAsync().execute();
		
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent viewIntent=new Intent(ZodiacXMLParsing.this,ViewLovedFacts.class);
				startActivity(viewIntent);
				mp.start();
			}
		});
		
		
		if (isInternetPresent){
		love.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean didItWork=true;
				mp.start();
				try{
				String name=gettingText.giveData();
				
				LovedFactsSQLite entry=new LovedFactsSQLite(ZodiacXMLParsing.this);
				
				entry.open();
				entry.createEntry(name);
				
				
				entry.close();}
				catch(Exception e){
					didItWork=false;
				}finally{
					if(didItWork){
						Toast.makeText(ZodiacXMLParsing.this,"Fact Added To Your Loved Facts.", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});}
		
	}
	
	class PostAsync extends AsyncTask<Void, Void, Void>{
		ProgressDialog pd;

		
		protected void onPreExecute(){
			pd=ProgressDialog.show(ZodiacXMLParsing.this,"Loading","Retrieving Data...",true,false);
		}
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			gettingText.parsing(sign);
			
			return null;
		}
		protected void onPostExecute(Void result){
			String text=gettingText.giveData();
			tv.setText(text);
			pd.dismiss();
			
		}
		
	}
	
}
