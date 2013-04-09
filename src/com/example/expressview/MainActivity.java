package com.example.expressview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final String[] m={"顺风速递","畅通快递","ＥＭＳ邮政","Ｅ物流","天天物流"}; 
	private ArrayAdapter<String> adapter; 
	
	private Button button1;
	private Spinner spinner1;
	private TextView text1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    button1 = (Button) this.findViewById(R.id.button1);
	    spinner1 = (Spinner) this.findViewById(R.id.spinner1);
	    text1 = (TextView) this.findViewById(R.id.text1);
	    
        //将可选内容与ArrayAdapter连接起来  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);  
          
        //设置下拉列表的风格  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //将adapter 添加到spinner中  
        spinner1.setAdapter(adapter);  
          
        //添加事件Spinner事件监听    
   //     spinner1.setOnItemSelectedListener(new SpinnerSelectedListener()); 
		
	    button1.setOnClickListener(new View.OnClickListener() { 
	    	 public void onClick(View v) { 
	    		 // Perform action on click    
	    		 text1.setText("等待下一个版本的发布，哥需要时间");
	    	  }         
	     });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
