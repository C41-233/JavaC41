import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Main {

	public static void main(String[] args) throws Exception {
		String arg1 = args[0];
		String arg2 = args[1];
		String arg3 = args[2];
		
		File templateFile = new File(arg1);
		String templateFileName = templateFile.getName();
		File directory = templateFile.getParentFile();
		File configFile = new File(arg3);
		
		Configuration configuration = new Configuration(new Version("2.3.27"));
		configuration.setDirectoryForTemplateLoading(templateFile.getParentFile());
		configuration.setDefaultEncoding("utf8");
		configuration.setLogTemplateExceptions(false);
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template template = configuration.getTemplate(templateFileName);
		
		for(Config config : createConfig(configFile)) {
			File outputFile = new File(directory, arg2.replace("$", config.output));
			System.out.println("generate " + outputFile.getName());
			try(FileOutputStream fos = new FileOutputStream(outputFile)){
				OutputStreamWriter writer = new OutputStreamWriter(fos, "utf8");
				template.process(config.arguments, writer);
			}
		}
		
	}

	private static Iterable<Config> createConfig(File configFile) throws Exception{
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
