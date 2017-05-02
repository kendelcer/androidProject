package com.example.search;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	MyAdapter adapter;

	ArrayList<Student> source;
	ArrayList<Student> list;
	ListView lv;
	EditText txtSearch;
	int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list = new ArrayList<Student>();
        source = new ArrayList<Student>();
        
        this.txtSearch = (EditText) this.findViewById(R.id.editText1);
        this.lv = (ListView) this.findViewById(R.id.listView1);
        
        adapter = new MyAdapter(this,list);
        this.lv.setAdapter(adapter);
        
        this.source.add(new Student(R.drawable.img1,"ALPHA"," BSIT"));
        this.source.add(new Student(R.drawable.img2,"BRAVO","BEED"));
        this.source.add(new Student(R.drawable.img3,"CHARLIE","BSCREAM"));
        this.source.add(new Student(R.drawable.img4,"DELTA","BSCIS"));
        this.source.add(new Student(R.drawable.img5,"ECHO","5th Philippine President"));
        this.source.add(new Student(R.drawable.img6,"Elpidio P. Quirino","6th Philippine President"));
        this.source.add(new Student(R.drawable.img7,"Ramon D. Magsaysay","7th Philippine President"));
        this.source.add(new Student(R.drawable.img8,"Carlos P. Garcia","1st 8th President"));
        this.source.add(new Student(R.drawable.img9,"Diosdado P. Macapagal","9th Philippine President"));
        this.source.add(new Student(R.drawable.img10,"Ferdinand E. Marcos","10th Philippine President"));
        this.source.add(new Student(R.drawable.img11,"Corazon C. Aquino","11th Philippine President"));
        this.source.add(new Student(R.drawable.img12,"Fidel V. Ramos","12th Philippine President"));
       

        
        this.lv.setOnItemClickListener(this);
      
        this.txtSearch.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-geneWrated method stu
				
			}

			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				list.clear();
				
				Pattern p = Pattern.compile(arg0.toString());
				for(int i = 0; i < source.size(); i++){
					Matcher name = p.matcher(source.get(i).getName());
					Matcher course = p.matcher(source.get(i).getCourse());
					if(name.find() || course.find()){
						list.add(source.get(i));
					}
					adapter.notifyDataSetChanged();
				}
				
			}});

    }
    @Override
    protected void onPause(){
    	super.onPause();
    	finish();
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle(list.get(arg2).getName());
				
				ImageView myiv=new ImageView(this);
					myiv.setImageResource(list.get(arg2).getImage());
				TextView myname=new TextView(this);
					myname.setText(list.get(arg2).getName());
				TextView mycourse=new TextView(this);
					mycourse.setText(list.get(arg2).getCourse());
				
				LinearLayout mainLayout=new LinearLayout(this);	
						mainLayout.setOrientation(LinearLayout.HORIZONTAL);
						mainLayout.addView(myiv);
						
				LinearLayout subLayout=new LinearLayout(this);
					subLayout.setOrientation(LinearLayout.VERTICAL);
					subLayout.addView(myname);
					subLayout.addView(mycourse);
					
					mainLayout.addView(subLayout);
					
					builder.setView(mainLayout);
					builder.setNeutralButton("Okey", null);
					
			AlertDialog dialog=builder.create();
				dialog.show();
								
		}

}
