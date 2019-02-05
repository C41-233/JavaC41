import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Main {

	private static ArrayList<Config> Configs;
	
	public static void main(String[] args) throws Exception {
		String srcPath = args[0];
		String destPath = args[1];
		String configPath = args[2];
		
		File configFile = new File(configPath);
		Configs = createConfig(configFile);
		
		File dest = new File(destPath);
		
		File root = new File(srcPath);
		
		if(!root.getParent().equals(dest.getParent())) {
			System.err.println("project not same parent file");
			return;
		}
		
		FileUtils.cleanDirectory(dest);
		visit(root, dest);
	}
	
	private static void visit(File root, File dest) throws IOException, TemplateException {
		for(File file : root.listFiles()) {
			if(file.isDirectory()) {
				visit(file, new File(dest, file.getName()));
			}
			else if(file.getName().endsWith(".java.template")){
				run(file, dest);
			}
		}
	}

	private static void run(File templateFile, File dest) throws IOException, TemplateException {
		System.out.println("read " + templateFile.getAbsolutePath());
		
		String templateFileName = templateFile.getName();
		
		Configuration configuration = new Configuration(new Version("2.3.27"));
		configuration.setDirectoryForTemplateLoading(templateFile.getParentFile());
		configuration.setDefaultEncoding("utf8");
		configuration.setLogTemplateExceptions(false);
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template template = configuration.getTemplate(templateFileName);
		
		templateFileName = templateFileName.replace(".java.template", "");
		
		dest.mkdirs();
		
		if(templateFileName.contains("$")) {
			for(Config config : Configs) {
				File outputFile = new File(dest, templateFileName.replace("$", config.output) + ".java");
				System.out.println("generate " + outputFile.getName());
				try(FileOutputStream fos = new FileOutputStream(outputFile)){
					OutputStreamWriter writer = new OutputStreamWriter(fos, "utf8");
					template.process(config.arguments, writer);
				}
			}
		}
		else {
			File outputFile = new File(dest, templateFileName + ".java");
			System.out.println("generate " + outputFile.getName());
			try(FileOutputStream fos = new FileOutputStream(outputFile)){
				OutputStreamWriter writer = new OutputStreamWriter(fos, "utf8");
				ArrayList<HashMap<String, String>> arguments = new ArrayList<>();
				for (Config config : Configs) {
					arguments.add(config.arguments);
				}
				HashMap<String, Object> root = new HashMap<>();
				root.put("configs", arguments);
				template.process(root, writer);
			}
		}
	}
	
	private static ArrayList<Config> createConfig(File configFile) throws Exception{
		ArrayList<Config> list = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(configFile);
		Element elementTemplates = document.getDocumentElement();
		
		NodeList listTemplate = elementTemplates.getElementsByTagName("template");
		for(int i=0; i<listTemplate.getLength(); i++) {
			Element elementTemplate = (Element) listTemplate.item(i);
			Config config = new Config();
			String name = elementTemplate.getAttribute("name");
			config.output = name;
			config.arguments.put("Name", name);
			
			NodeList listParameter = elementTemplate.getElementsByTagName("parameter");
			for(int j=0; j<listParameter.getLength(); j++) {
				Element elementParameter = (Element) listParameter.item(j);
				config.arguments.put(elementParameter.getAttribute("name"), elementParameter.getAttribute("value"));
			}
			list.add(config);
		}
		return list;
	}
	
}
