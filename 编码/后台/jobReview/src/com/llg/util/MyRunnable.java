package com.llg.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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

	public void run(String className){
		Process process;
		try {
			process = Runtime.getRuntime().exec(new String[]{"java",className},null,new File(FileUtil.LOCAL_TEMP_PATH));
			InputStream in = process.getInputStream();
			InputStream err = process.getErrorStream();
			BufferedInputStream bufin = new BufferedInputStream(in);
			BufferedInputStream buferr = new BufferedInputStream(err);
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						process.waitFor();
					} catch (InterruptedException e) {
						process.destroy();
					}
				}
			});
			//获取输出
			Thread thread1 = new Thread(new Runnable() {
				public void run() {
					int len = 0;
					byte[] b = new byte[128];
					try {
						while((len = bufin.read(b)) != -1){
							bout.write(b, 0, len);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally {
						
							try {
								if(in != null) in.close();
								if(bufin != null) bufin.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				}
			});
			//获取异常
			Thread thread2 = new Thread(new Runnable() {
				public void run() {
					int len = 0;
					byte[] b = new byte[128];
					try {
						while((len = buferr.read(b)) != -1){
							berr.write(b, 0, len);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally {
						
							try {
								if(err != null) in.close();
								if(buferr != null) bufin.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				}
			});
			thread.start();
			thread1.start();
			thread2.start();
			thread.join(10000);
			if(!thread.isInterrupted()) thread.interrupt();
			thread1.join();
			thread2.join();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
