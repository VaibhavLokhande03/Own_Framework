package pom.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Config_Data_Provider {
	Properties pro;
	public Config_Data_Provider() throws Exception {
		String File="C:\\Users\\HP\\eclipse-workspace\\Own_Framework\\Config\\Config.Properties";
		FileInputStream fil=new FileInputStream(File);
	    pro=new Properties();
		pro.load(fil);
	}
	
	public String getQAENV_01() {
	 return	pro.getProperty("QAENV_01");
	}
}
