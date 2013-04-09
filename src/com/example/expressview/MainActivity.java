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
	
	private static final String[] m={"˳���ٵ�","��ͨ���","�ţͣ�����","������","��������"}; 
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
	    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner1.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
   //     spinner1.setOnItemSelectedListener(new SpinnerSelectedListener()); 
		
	    button1.setOnClickListener(new View.OnClickListener() { 
	    	 public void onClick(View v) { 
	    		 // Perform action on click    
	    		 text1.setText("�ȴ���һ���汾�ķ���������Ҫʱ��");
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
