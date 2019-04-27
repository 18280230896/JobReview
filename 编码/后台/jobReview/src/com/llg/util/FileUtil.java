package com.llg.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.UUID;


/**
 * 文件操作工具类
 * @author 罗龙贵
 * @Date 2019年4月11日 上午10:55:37
 */
public class FileUtil {
	public static String LOCAL_JOB_PATH;
	public static String LOCAL_TEMP_PATH;
	public static String VIRTUAL_JOB_PATH;
	
	/**
	 * 用uuid生成一个随机文件名
	 * @author 罗龙贵
	 * @date 2019年4月11日 上午10:56:38
	 * @return
	 */
	public static String createFileName(){
		return "Job"+UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
	
	/**
	 * 通过传入的文件路径创建一个文件
	 * @author 罗龙贵
	 * @date 2019年4月11日 上午11:19:27
	 * @param fileName 要创建的文件路径名
	 * @return 返回创建好的文件对象
	 */
	public static File createFile(String fileName){
		File file = new File(fileName);
		File parent = file.getParentFile();
		//判断父级目录是否存在，不存在则创建
		if(!parent.exists()) parent.mkdirs();
		//判断文件是否存在，不存在则创建
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * 将指定内容写入指定文件
	 * @author 罗龙贵
	 * @date 2019年4月11日 下午2:04:55
	 * @param file 指定的文件
	 * @param content 要写入的内容
	 * @return
	 */
	public static boolean write(File file,String content){
		FileOutputStream out = null;
		BufferedOutputStream bo = null;
		try {
			out = new FileOutputStream(file);
			bo = new BufferedOutputStream(out);
			byte[] bytes = content.getBytes("UTF-8");
			bo.write(bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(bo != null){
				try {
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
		return true;
	}
	
	/**
	 * 读取文件内容转化为字符串返回
	 * @author 罗龙贵
	 * @date 2019年4月11日 下午2:25:59
	 * @param file 要读取的文件
	 * @return
	 */
	public static String getFileContent(File file){
		ByteArrayOutputStream out = null;
		FileInputStream in = null;
		String content = null;
		try {
			out = new ByteArrayOutputStream();
			in = new FileInputStream(file);
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1){
				out.write(b, 0, len);
			}
			byte[] arr = out.toByteArray();
			content = new String(arr, 0, arr.length, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null)
					in.close();
				if(out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	
	/**
	 * 读取文件内容，返回字节数组
	 * @author 罗龙贵
	 * @date 2019年4月11日 下午2:54:26
	 * @param file 要读取的文件
	 * @return
	 */
	public static byte[] getClassFileBytes(File file){
        //采用NIO读取
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
		try {
			fis = new FileInputStream(file);
			FileChannel fileC = fis.getChannel();
	        baos = new ByteArrayOutputStream();
	        WritableByteChannel outC = Channels.newChannel(baos);
	        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
	        while (true) {
	            int i = fileC.read(buffer);
	            if (i == 0 || i == -1) {
	                break;
	            }
	            buffer.flip();
	            outC.write(buffer);
	            buffer.clear();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        return baos.toByteArray();
    }
	
	
	/**
	 * 通过传入一个字符串，返回类名
	 * @author 罗龙贵
	 * @date 2019年4月11日 下午2:55:06
	 * @param content
	 * @return
	 */
	public static String parseClassName(String content) {
		String packageName = "";
		String className = null;
		int packageStart = content.indexOf("package");
		int packageEnd = content.indexOf(";", packageStart);
		if (packageStart >= 0 && packageEnd > 0) { // package name
			packageStart += "package".length();
			packageName = content.substring(packageStart, packageEnd).replace('\t', ' ').trim() + ".";
		}
		int classStart = content.indexOf("class");
		int classEnd = content.indexOf("{", classStart);
		if (classStart >= 0 && classEnd > 0) { // class name
			classStart += "class".length();
			className = content.substring(classStart, classEnd).replace('\t', ' ').trim();
		}
		return packageName + className;
	}
	
}
