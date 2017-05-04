package com.example.picgrid;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	GridView gv;
	ArrayList<Person> list = new ArrayList<Person> ();
    GridAdapter adapter;
    AdapterView.AdapterContextMenuInfo info;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.gv = (GridView) this.findViewById(R.id.gridView1);
        this.adapter = new GridAdapter(this, list);
        this.gv.setAdapter(adapter);
        
        this.registerForContextMenu(gv);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.contextmenu, menu);
		info=(AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(list.get(info.position).getName());
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	   Intent intent = new Intent(this, UpdatePersonActivity.class);	
	   this.startActivityForResult(intent,1);
	   return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		int select = item.getItemId();
		switch(select) {
		
		case R.id.delete : 
			 
			      list.remove(info.position);
			      Toast.makeText(this, "has been deleted", Toast.LENGTH_SHORT).show();
			      this.adapter.notifyDataSetChanged();
			
			break;
		case R.id.view:
			
			ImageView iv = new ImageView(this);
			iv.setImageURI(list.get(info.position).getImageUri());
			TextView tv = new TextView(this);
		
			tv.setText(list.get(info.position).getName());
			
			LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.VERTICAL);
			layout.addView(iv);
			layout.addView(tv);
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(list.get(info.position).getName());
			builder.setView(layout);
			builder.setNeutralButton("Okay", null);
			
			AlertDialog dialog = builder.create();
			dialog.show();
			
		
		}
		
		
		return super.onContextItemSelected(item);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	    if(resultCode==Activity.RESULT_OK){
	    	if(requestCode==1){
	    		Bundle b = data.getExtras();
	    	    Uri image = b.getParcelable("image");
	    	    String name = b.getString("name");
	    	    Person p = new Person (image,name);
	    	    list.add(p);
	    	    this.adapter.notifyDataSetChanged();
	    	}
	    }
	}
}
