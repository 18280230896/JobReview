package com.llg.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.llg.util.FileUtil;

public class MyServletContentListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//½âÎöpath.xml
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(MyServletContentListener.class.getClassLoader().getResourceAsStream("config.xml"));
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for (Element element : elements) {
				if(element.getQualifiedName().equals("localJobPath")) FileUtil.LOCAL_JOB_PATH = element.getText();
				if(element.getQualifiedName().equals("localTempPath")) FileUtil.LOCAL_TEMP_PATH = element.getText();
				if(element.getQualifiedName().equals("virtualJobPath")) FileUtil.VIRTUAL_JOB_PATH = element.getText();
				if(element.getQualifiedName().equals("system")) FileUtil.SYSTEM = element.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
