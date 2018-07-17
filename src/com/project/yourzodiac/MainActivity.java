package com.project.yourzodiac;





import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;


import com.project.zodiacfacts.R;


public class MainActivity extends Activity{

	Boolean isInternetPresent = false;
	CheckInternet ci;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		ImageButton but1=(ImageButton)findViewById(R.id.but1);
		ImageButton but2=(ImageButton)findViewById(R.id.but2);
		ImageButton but3=(ImageButton)findViewById(R.id.but3);
		ImageButton but4=(ImageButton)findViewById(R.id.but4);
		ImageButton but5=(ImageButton)findViewById(R.id.but5);
		ImageButton but6=(ImageButton)findViewById(R.id.but6);
		ImageButton but7=(ImageButton)findViewById(R.id.but7);
		ImageButton but8=(ImageButton)findViewById(R.id.but8);
		ImageButton but9=(ImageButton)findViewById(R.id.but9);
		ImageButton but10=(ImageButton)findViewById(R.id.but10);
		ImageButton but11=(ImageButton)findViewById(R.id.but11);
		ImageButton but12=(ImageButton)findViewById(R.id.but12);
		
		final MediaPlayer mp=MediaPlayer.create(this,R.raw.click);
		
		ci = new CheckInternet(getApplicationContext());
		isInternetPresent = ci.isConnectingToInternet();
		if (!isInternetPresent){
			showAlertDialog(MainActivity.this, "No Internet Connection",
                    "Turn on your Internet.", false);
		}
but1.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="aries";
		myIntent.putExtra("sign", z);
		mp.start();
		startActivity(myIntent);
	}
});

	but1.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Aries.class);
		startActivity(myIntent);
		return false;
	}
});
	
	but2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
			String z="taurus";
			mp.start();
			myIntent.putExtra("sign", z);
			startActivity(myIntent);
		}
	});

but2.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Taurus.class);
		startActivity(myIntent);
		return false;
	}
});

but3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="gemini";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but3.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Gemini.class);
		startActivity(myIntent);
		return false;
	}
});

but4.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="cancer";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});
but4.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Cancer.class);
		startActivity(myIntent);
		return false;
	}
});

but5.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="leo";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but5.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Leo.class);
		startActivity(myIntent);
		return false;
	}
});

but6.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="virgo";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but6.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Virgo.class);
		startActivity(myIntent);
		return false;
	}
});

but7.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="libra";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but7.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Libra.class);
		startActivity(myIntent);
		return false;
	}
});

but8.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="scorpio";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but8.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Scorpio.class);
		startActivity(myIntent);
		return false;
	}
});

but9.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="sagittarius";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but9.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Sagi.class);
		startActivity(myIntent);
		return false;
	}
});

but10.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="capricorn";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but10.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Capricorn.class);
		startActivity(myIntent);
		return false;
	}
});

but11.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="aquarius";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but11.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Aquarius.class);
		startActivity(myIntent);
		return false;
	}
});

but12.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent= new Intent(MainActivity.this,ZodiacXMLParsing.class);
		String z="pisces";
		mp.start();
		myIntent.putExtra("sign", z);
		startActivity(myIntent);
	}
});

but12.setOnLongClickListener(new View.OnLongClickListener() {
	
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent=new Intent(MainActivity.this,Pisces.class);
		startActivity(myIntent);
		return false;
	}
});



		
	}
	
	@SuppressWarnings("deprecation")
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if((keyCode==KeyEvent.KEYCODE_BACK)){
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Zodiac Facts");
            alertDialog.setIcon(R.drawable.ic_launcher);

            alertDialog.setMessage("I'll Come Back Tomorrow For More Fun Facts.");
            alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                  finish();
                return;
            } }); 
            alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                  dialog.cancel();
                return;
            }}); 
              alertDialog.show();

         return true;
     }
     return super.onKeyDown(keyCode, event);
 }

	public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        // Setting Dialog Title
        alertDialog.setTitle(title);
 
        // Setting Dialog Message
        alertDialog.setMessage(message);
         
        // Setting alert dialog icon
        alertDialog.setIcon((status) ? R.drawable.fail : R.drawable.fail);
 
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
    }

}
