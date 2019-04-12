package com.llg.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyRunnable {
	
	private static PrintStream systemOut = System.out;
	private static PrintStream systemErr = System.err;
	private ByteArrayOutputStream bout;
	private ByteArrayOutputStream berr;

	public MyRunnable(ByteArrayOutputStream bout, ByteArrayOutputStream berr) {
		super();
		this.bout = bout;
		this.berr = berr;
	}

	public void run(String name,File file){
		PrintStream out = new PrintStream(bout);
		PrintStream err = new PrintStream(berr);
		setOutAndErr(out,err);
		try {
			Class<?> c = Class.forName(name, true, new MyClassLoad(file));
			Method main = c.getMethod("main", String[].class);
			if(main != null){
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
							try {
								main.invoke(null, (Object)null);
							} catch (Exception e) {
								e.printStackTrace();
							} 
						
					}
				});
				thread.start();
				thread.join(2000);
				thread.stop();
//				if(!thread.isInterrupted()){
//					thread.interrupt();
//				}
				
			}
			
		} catch (Exception e) {
			return;
		}finally{
			reductionOutAndErr();
			if(out != null){
				out.close();
			}
			if(err != null){
				err.close();
			}
		}
	}
	
	private synchronized static void setOutAndErr(PrintStream out,PrintStream err){
		systemOut = System.out;
		systemErr = System.err;
		System.setOut(out);
		System.setErr(err);
	}
	
	private synchronized static void reductionOutAndErr(){
		System.setOut(systemOut);
		System.setErr(systemErr);
	}
}
