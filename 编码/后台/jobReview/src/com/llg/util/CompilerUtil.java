package com.llg.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 编译工具累
 * @author 罗龙贵
 * @Date 2019年4月11日 上午10:52:17
 */
public class CompilerUtil {

	/**
	 * 需要编译时调用此方法
	 * @author 罗龙贵
	 * @date 2019年4月11日 上午10:52:39
	 * @param files 需要编译的java文件列表
	 * @return 返回一个map,包含两个key,一个是success表示编译是否成功，一个是msg表示如果编译错误的提示信息，若success=true,则没有msg
	 */
	public static Map<String, Object> compiler(File[] files){
		Map<String, Object> result = new HashMap<>();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> javaFileObjects = fileManager.getJavaFileObjects(files);
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		boolean success = compiler.getTask(null, fileManager, diagnostics, null, null, javaFileObjects).call();
		result.put("success", success);
		if(!success){
			result.put("msg", diagnostics.getDiagnostics());
			return result;
		}
		return result;
	}
}
