package service;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileUploader {
	
	public fileUploader() {
		
	}
	public int upload(String path,Part filePart) throws IOException {
		File uploadDir = new File(path);
		if (!uploadDir.exists()) uploadDir.mkdir();
	    String fileName = getFileName(filePart);
		OutputStream out = null;
	    InputStream filecontent = null;
	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();
	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        return 1;
	    } catch (FileNotFoundException fne) {
	    	fne.printStackTrace();
	    }
		return 0;
	}
	private String getFileName(Part part) {
	    String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
