package com.example.loveexam;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {
	
	ListView lv;
    ArrayList<Person> list = new ArrayList<Person> ();
    MyAdapter adapter;
    AlertDialog dialog;
    EditText contactName;
    EditText contactNumber;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        
        this.lv = (ListView) this.findViewById(R.id.listView1);
        this.adapter=new MyAdapter(this, list);
        this.lv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		         contactName = new EditText (this);
		         contactName.setPadding(10, 10, 10, 10);
		         contactName.setHint("Contact Name");
		        
		         
		         contactNumber = new EditText (this);
		         contactNumber.setPadding(10, 10, 10, 10);
		         contactNumber.setHint("Contact Number");
		         contactNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
		         
		         LinearLayout layout = new LinearLayout (this);
			        layout.setOrientation(LinearLayout.VERTICAL);
			        layout.addView(contactName);
			        layout.addView(contactNumber);         
	
		         
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		   builder.setTitle("Add Contact");
		   builder.setView(layout);
		 
		   builder.setPositiveButton("Save", this);
		   builder.setNegativeButton("Cancel", this);
		   
		   dialog = builder.create();
		   dialog.show();
		
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE:
			
			String a = this.contactName.getText().toString();
			String b = this.contactNumber.getText().toString();
			
			list.add(new Person(R.drawable.ic_launcher,a,b));
			adapter.notifyDataSetChanged();
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			dialog.dismiss();
		
		}
		
	}
    
    
    
}
