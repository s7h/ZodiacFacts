package com.project.yourzodiac;

import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zodiacfacts.R;

public class ViewLovedFacts extends Activity{
long count=1;
TextView tv;
EditText et;
String returnedFact;


Animation animFadein;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewlovedfacts);
		
		tv=(TextView)findViewById(R.id.lovedtextview);
		ImageButton prevb=(ImageButton)findViewById(R.id.prevb);
		ImageButton nextb=(ImageButton)findViewById(R.id.nextb);
		ImageButton gob=(ImageButton)findViewById(R.id.bgo);
		ImageButton unlove=(ImageButton)findViewById(R.id.unlove);
		et=(EditText)findViewById(R.id.editno);
		
		
		
		
		animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
		//animFadein.setAnimationListener(this);
		
		nextb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count=count+1;
				LovedFactsSQLite lfq=new LovedFactsSQLite(ViewLovedFacts.this);
				
				try {
					
					lfq.open();
					returnedFact=lfq.getFact(count);
					lfq.close();
					
					while(returnedFact!=null){
						here:
						if(returnedFact=="factDeleted"){
							count=count+1;
							lfq.open();
							returnedFact=lfq.getFact(count);
							lfq.close();
							break here;
							}
							break;
							
						}
						
					
				
						
					
					tv.setVisibility(View.VISIBLE);
	                tv.startAnimation(animFadein);
					tv.setText(count + " " +returnedFact);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		prevb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(count>=2){
				count=count-1;}
				LovedFactsSQLite lfq=new LovedFactsSQLite(ViewLovedFacts.this);
				

				try {
					
					lfq.open();
					returnedFact=lfq.getFact(count);
					lfq.close();
					
					while(returnedFact!=null){
						here:
						if(returnedFact=="factDeleted"){
							count=count-1;
							lfq.open();
							returnedFact=lfq.getFact(count);
							lfq.close();
							break here;
							}
							break;
							
						}
						
					
				
						
					
					tv.setVisibility(View.VISIBLE);
	                tv.startAnimation(animFadein);
					tv.setText(count + " " +returnedFact);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		LovedFactsSQLite lfq=new LovedFactsSQLite(this);
		try {
			lfq.open();
			String returnedFact=lfq.getFact(1);
			lfq.close();
			/*while(returnedFact!="factDeleted"){
				count=count+1;
				lfq.open();
				returnedFact=lfq.getFact(count);
				lfq.close();
			}*/
			tv.setVisibility(View.VISIBLE);
            tv.startAnimation(animFadein);
			tv.setText(returnedFact);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		gob.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				long temp=count;
				et.setInputType(InputType.TYPE_CLASS_NUMBER);
				String c=et.getText().toString();
				if(c.equals("")){
					Toast.makeText(ViewLovedFacts.this,"Bitch Please!!", Toast.LENGTH_SHORT).show();
					count=temp;
				}else{
				count=Long.parseLong(c);
				}
				LovedFactsSQLite lfq=new LovedFactsSQLite(ViewLovedFacts.this);
				
				try {
					lfq.open();
					String returnedFact=lfq.getFact(count);
					lfq.close();
					tv.setVisibility(View.VISIBLE);
	                tv.startAnimation(animFadein);
					tv.setText(count + " " +returnedFact);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		unlove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LovedFactsSQLite lfq=new LovedFactsSQLite(ViewLovedFacts.this);
				
				try {
					lfq.open();
					lfq.updateEntry(count,"factDeleted");
					lfq.close();
					Toast.makeText(ViewLovedFacts.this, "Unloved", Toast.LENGTH_SHORT).show();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		/*LovedFactsSQLite info =new LovedFactsSQLite(this);
		try {
			info.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data=info.getData();
		info.close();
		tv.setText(data);*/
	}

}
