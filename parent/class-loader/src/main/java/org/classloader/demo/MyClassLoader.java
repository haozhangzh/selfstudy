package org.classloader.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyClassLoader extends ClassLoader {
  
	private String classPath;
  
	public MyClassLoader(String classPath){
	  this.classPath = classPath;
    }
	public Class<?> loadPathClass(String name) throws ClassNotFoundException{
		return this.findClass(name);
	}
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		try {
			byte[] result = this.getDate(name);
			Class<?> c = this.defineClass(name, result, 0, result.length);
			return c;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return super.findClass(name);
	}
	
	 private byte[] getDate(String name) throws IOException{
		 String filePath = classPath+"/"+name.replace(".", "/")+".class";
		 File classFile = new File(filePath);
		 FileInputStream fileInput = new FileInputStream(classFile);
		 FileChannel fc = fileInput.getChannel();
		 ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		 WritableByteChannel wbc = Channels.newChannel(byteOutput);
		 ByteBuffer by = ByteBuffer.allocate(1024);
		 while(true){
			 int i = fc.read(by);
			 if(i <= 0){
				 break;
			 }
			 by.flip();
			 wbc.write(by);
			 by.clear();
		 }
		 fileInput.close();
		 return byteOutput.toByteArray();
	 }
	
}
