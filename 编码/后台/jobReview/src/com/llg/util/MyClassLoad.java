package com.llg.util;

import java.io.File;

/**
 * 自定义ClassLoader,用于反射加载class文件
 * @author 罗龙贵
 * @Date 2019年4月11日 下午2:12:22
 */
public class MyClassLoad extends ClassLoader{

	private File file;
	public MyClassLoad(File file) {
		super();
		this.file = file;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = null;
		try {
			byte[] fileByte = FileUtil.getClassFileBytes(file);
			 clazz = defineClass(name, fileByte, 0, fileByte.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz;
	}

}
