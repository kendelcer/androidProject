package com.example.prefinal;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	TabHost tabhost;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = this.getTabHost();
        
        Intent intentL = new Intent(this,LocationList.class);
        Intent intentA = new Intent(this,AddLocation.class);
        Intent intentProfile = new Intent(this,MyProfile.class);
        
        Drawable locationicon=this.getResources().getDrawable(R.drawable.mylocation);
        Drawable addicon=this.getResources().getDrawable(R.drawable.add);
        Drawable profileicon=this.getResources().getDrawable(R.drawable.edit);
        
        TabSpec locationlist = tabhost.newTabSpec("locationlist");
        	locationlist.setIndicator("", locationicon);
        	locationlist.setContent(intentL);
        	
        TabSpec addlist = tabhost.newTabSpec("addlist");	
        	addlist.setIndicator("", addicon);
        	addlist.setContent(intentA);
        	
        TabSpec aboutlist = tabhost.newTabSpec("aboutlist");
        	aboutlist.setIndicator("", profileicon);
        	aboutlist.setContent(intentProfile);	
        	 
        	
        tabhost.addTab(locationlist);	
        tabhost.addTab(addlist);
        tabhost.addTab(aboutlist);
        
        
    }
		
    
}
