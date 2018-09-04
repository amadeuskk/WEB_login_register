package verification_code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

public class get_yzm {
	public static void main(String args[]) {
		File f = new File("/home/amadeus/tools/apache-tomcat-8.0.53/webapps/WEB13/WEB-INF/new_words.txt");
		int lines = 0;
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(chars.length());
		while (lines < 600) {
			System.out.println(lines);
			lines+=1;
			String yzms = "";
			for(int i =0;i<4;i++) {
				char yzm = chars.charAt((int)(Math.random()*52));
				yzms += yzm;
			}
			try {
				FileWriter out = new FileWriter(f,true);
				out.write(yzms);
				out.write("\n");
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
