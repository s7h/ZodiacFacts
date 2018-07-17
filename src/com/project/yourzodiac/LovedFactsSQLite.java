package com.project.yourzodiac;

import java.sql.SQLException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class LovedFactsSQLite {

	public static final String KEY_ROWID="_id";
	public static final String KEY_FACT="facts";
	
	private static final String DATABASE_NAME="lovedfactsdb";
	private static final String DATABASE_TABLE="lovedfactstable";
	private static final int DATABASE_VERSION= 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	

	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " ("+
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
					KEY_FACT+ " TEXT);"
					);
			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	public LovedFactsSQLite(Context c){
		ourContext = c;
	}
	
	public LovedFactsSQLite open()throws SQLException{
		ourHelper=new DbHelper(ourContext);
		ourDatabase =ourHelper.getWritableDatabase();
		return this;
		
	}
	
	public void close(){
		ourHelper.close();
	}

	public long createEntry(String name) {
		// TODO Auto-generated method stub
		ContentValues cv= new ContentValues();
		cv.put(KEY_FACT, name);
		return ourDatabase.insert(DATABASE_TABLE,  null, cv);
		
	}

	public String getData() {
		// TODO Auto-generated method stub
		
		String[] columns=new String[]{KEY_ROWID,KEY_FACT};
		Cursor c=ourDatabase.query(DATABASE_TABLE,columns, null, null, null, null, null);
		String result="";
		
		int iRow=c.getColumnIndex(KEY_ROWID);
		int iFact=c.getColumnIndex(KEY_FACT);
		
		for(c.moveToFirst(); ! c.isAfterLast(); c.moveToNext()){
			result=result + c.getString(iRow)+"  "+c.getString(iFact) + "\n" ;
		}
		return result;
	}

	public String getFact(long count) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_ROWID,KEY_FACT};
		Cursor c=ourDatabase.query(DATABASE_TABLE,columns, KEY_ROWID + "=" + count , null,null,null,null);
		
		while(!c.isAfterLast()){
		if (c!=null){
			
			c.moveToFirst();
			
			String fact=c.getString(1);
			return fact;
		}}
			return null;
		
	}

	public void deleteEntry(long count) {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + count, null);
	}

	public void updateEntry(long count, String string) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_FACT, string);
		ourDatabase.update(DATABASE_TABLE, cv, KEY_ROWID +"="+ count, null);
	}

	

	


}
 