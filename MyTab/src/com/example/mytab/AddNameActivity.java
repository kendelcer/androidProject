package com.example.mytab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNameActivity extends Activity implements OnClickListener {
	
	EditText txtName;
	Button btnOkey, btnCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.addname);
		
		this.txtName =  (EditText) this.findViewById(R.id.editText1);
		this.btnOkey = (Button) this.findViewById(R.id.button1);
		this.btnCancel = (Button) this.findViewById(R.id.button2);
		

		this.btnOkey.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		
		int id=arg0.getId();
		switch(id) {
		case R.id.button1: //add a new name
			String name = this.txtName.getText().toString();
	     
			Intent n = new Intent ();
			
			
			
			break;
			
		case R.id.button2: 
			this.txtName.setText("");
			this.txtName.requestFocus();
			Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
			
		
		
		}
	}
}
