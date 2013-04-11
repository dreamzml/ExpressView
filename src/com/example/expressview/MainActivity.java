package com.example.expressview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
	
	private static final String[] m={"顺丰快递","圆通快递","申通快递","韵达快递","天天快递","EMS"}; 
	private ArrayAdapter<String> adapter; 
	
	private Button button1;
	private Spinner spinner1;
	private TextView text1;
	private EditText editText1;
	private String selected="顺丰快递";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    button1 = (Button) this.findViewById(R.id.button1);
	    spinner1 = (Spinner) this.findViewById(R.id.spinner1);
	    text1 = (TextView) this.findViewById(R.id.text1);
	    editText1 = (EditText) this.findViewById(R.id.edit_text1);
	    
        //将可选内容与ArrayAdapter连接起来  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);  
          
        //设置下拉列表的风格  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //将adapter 添加到spinner中  
        spinner1.setAdapter(adapter);  
          
        //添加事件Spinner事件监听    
       spinner1.setOnItemSelectedListener(
        		new SpinnerSelectedListener()
        	); 
		
	    button1.setOnClickListener(new View.OnClickListener() { 
	    	 public void onClick(View v) { 
	    		 // Perform action on click
	    		 String str = editText1.getText().toString();
	    		 text1.setText("你选择的物流公司是："+selected+"\n"+"你输入的物流单号是："+str+"\n"+"正在提交，请耐心等候！");
	    	  }         
	     });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	class SpinnerSelectedListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			selected =(String)m[arg2];  
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}
}
