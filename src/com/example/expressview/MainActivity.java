package com.example.expressview;

import java.net.URL;

import com.example.expressview.http.httpUnit;
import com.example.expressview.json.jsonTool;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String[] m = { "中通快递", "圆通快递", "申通快递", "韵达快递", "天天快递",
			"宅急送" };
	private ArrayAdapter<String> adapter;

	private Button button1, button2;
	private Spinner spinner1;
	private TextView text1;
	private EditText editText1;
	private String selected = "zhongtong";
	private ImageView imageView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) this.findViewById(R.id.button1);
		button2 = (Button) this.findViewById(R.id.button2);
		spinner1 = (Spinner) this.findViewById(R.id.spinner1);
		text1 = (TextView) this.findViewById(R.id.text1);
		editText1 = (EditText) this.findViewById(R.id.edit_text1);
		imageView1 = (ImageView) this.findViewById(R.id.imageView1);

		// 访问网络
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		// 将可选内容与ArrayAdapter连接起来
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, m);

		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 将adapter 添加到spinner中
		spinner1.setAdapter(adapter);

		// 输入框添加提示信息
		editText1.setHint("请输入快递单号！");

		// 添加事件Spinner事件监听
		spinner1.setOnItemSelectedListener(new SpinnerSelectedListener());

		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				String str = editText1.getText().toString();

				if (str.length() < 1) {
					Log.v("JsonTool", "物流单号为空");
					text1.setText("物流单号为空了，请输入物流单号！");
					return;
				}

				text1.setText("你选择的物流公司是：" + selected + "\n" + "你输入的物流单号是："
						+ str + "\n" + "正在提交，请耐心等候！");

				String urlString = "http://www.4568113.com/index.php/snoopy/searchExpress?com="
						+ selected + "&order=" + str;
				Log.v("JsonTool", urlString);
				String jsonString = httpUnit.getJsonContent(urlString);
				Log.v("JsonTool", jsonString);
				if (jsonString != "") {
					String str1 = jsonTool.JoinJson("--", jsonString);
					text1.setText(str1);
				}
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String path = "http://www.4568113.com/images/0A22825E.jpg";
				try {
					byte data[] = ImageService.getImageData(path);
					Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0,
							data.length);
					imageView1.setImageBitmap(bitmap);
				} catch (Exception e) {
					Log.e("tag", e.toString());
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	//选择物流下拉菜单事件
	class SpinnerSelectedListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			selected = (String) m[arg2];
			if ((String) m[arg2] == "韵达快递") {
				selected = "yunda";
			} else if ((String) m[arg2] == "中通快递") {
				selected = "zhongtong";
			} else if ((String) m[arg2] == "圆通快递") {
				selected = "yuantong";
			} else if ((String) m[arg2] == "申通快递") {
				selected = "shentong";
			} else if ((String) m[arg2] == "天天快递") {
				selected = "tiantian";
			} else if ((String) m[arg2] == "宅急送") {
				selected = "zhaijisong";
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}
}
