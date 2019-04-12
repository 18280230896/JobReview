package com.llg.util;

import java.io.File;

/**
 * �Զ���ClassLoader,���ڷ������class�ļ�
 * @author ������
 * @Date 2019��4��11�� ����2:12:22
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
