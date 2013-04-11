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
	
	private static final String[] m={"˳����","Բͨ���","��ͨ���","�ϴ���","������","EMS"}; 
	private ArrayAdapter<String> adapter; 
	
	private Button button1;
	private Spinner spinner1;
	private TextView text1;
	private EditText editText1;
	private String selected="˳����";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    button1 = (Button) this.findViewById(R.id.button1);
	    spinner1 = (Spinner) this.findViewById(R.id.spinner1);
	    text1 = (TextView) this.findViewById(R.id.text1);
	    editText1 = (EditText) this.findViewById(R.id.edit_text1);
	    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner1.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
       spinner1.setOnItemSelectedListener(
        		new SpinnerSelectedListener()
        	); 
		
	    button1.setOnClickListener(new View.OnClickListener() { 
	    	 public void onClick(View v) { 
	    		 // Perform action on click
	    		 String str = editText1.getText().toString();
	    		 text1.setText("��ѡ���������˾�ǣ�"+selected+"\n"+"����������������ǣ�"+str+"\n"+"�����ύ�������ĵȺ�");
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
