import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import c41.template.JustTemplate;

public class Main {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.err.println("usage: [template] [config]");
			System.exit(1);
			return;
		}
		File templateFile = new File(args[0]);
		File configFile = new File(args[1]);
		
		if(!templateFile.isFile()) {
			System.err.println("template not exist: " + templateFile);
			System.exit(1);
			return;
		}
		if(!configFile.isFile()) {
			System.err.println("config not exist: " + configFile);
			System.exit(1);
			return;
		}
	
		System.out.println("generate start.");
		try {
			ArrayList<HashMap<String, String>> groups = GroupFileProcess.readGroups(configFile);
			for (HashMap<String, String> group : groups) {
				String filename= group.get("File");
				System.out.println("gen "+ filename);
				
				String text = JustTemplate.render(templateFile, group);
				File target = new File(templateFile.getParent(), filename);
				try(FileOutputStream fos = new FileOutputStream(target)){
					fos.write(text.getBytes("utf8"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

}
