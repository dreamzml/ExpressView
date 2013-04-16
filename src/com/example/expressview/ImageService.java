package com.example.expressview;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageService {
	public static byte[] getImageData(String path) throws Exception {

		URL url = new URL(path);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");

		conn.setConnectTimeout(5000);

		InputStream inStream = conn.getInputStream();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];

		int len = 0;

		while ((len = inStream.read(buffer)) != -1) {

			bos.write(buffer, 0, len);

		}

		byte[] data = bos.toByteArray();

		return data;

	}
}
