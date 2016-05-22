package com.intellisoft.intellibusinessws.ws;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.intellisoft.intellibusinessws.util.Configuration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Helper {

	public static Response noResponse() {
		return Response.noContent().build();
	}

	public static Response response(Object o) {
		Gson builder = new GsonBuilder().setDateFormat("MMM dd,yyyy HH:mm:ss").create();
		return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").entity(builder.toJson(o)).build();
	}

	public static String saveFile(byte[] content) {
		Configuration config = new Configuration();
		String fileName = Long.toString(new Date().getTime()) + ".jpg";
		String fileDirName = config.get("images.folder") + fileName;
		if (content.length > 1000) {
			try {
				FileOutputStream fos = new FileOutputStream(fileDirName);
				BufferedOutputStream outputStream = new BufferedOutputStream(fos);
				outputStream.write(content);
				outputStream.close();
				fos.close();
				return fileName;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
