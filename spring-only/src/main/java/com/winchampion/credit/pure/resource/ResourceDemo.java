package com.winchampion.credit.pure.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceDemo {

	@Test
	public void testClassPath() throws IOException {
		Resource resource = new ClassPathResource("test.txt");
		String fileName = resource.getFilename();
		System.out.println(fileName);
		// resource.getFile(); //获取资源对应的文件
		// resource.getURL(); //获取资源对应的URL
		if (resource.isReadable()) {
			// 每次都会打开一个新的流
			InputStream is = resource.getInputStream();
			this.printContent(is);
		}
	}

	public void printContent(InputStream is) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
