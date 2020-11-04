package automation.CommonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;

import automation.Logging.LogManager;

public class PropertyReader {
	private InputStream is=null;
	private static Properties prop=null;
	private  String filename=null;
	
	public PropertyReader(String filename)
	{
		
		try{
			this.filename=filename;
			 prop = new Properties();
			 File file=new File(filename);
			 is = new FileInputStream(file);
			
			
		}
		catch(Exception e)
		{
		}
	}

	public String getValue(String key)   
	{
		try{
		

		if(is != null) 
			prop.load(is);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

		return prop.getProperty(key);
	}
	
	
	public void updateProperty(String key,String value)
	{
		try {
		prop.setProperty(key,value);
		 File file=new File(filename);
		FileWriter fw=new FileWriter(file);
		prop.store(fw, "changed value");
		
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
	}

}
