package br.com.caelum.camel;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TesteCamel03 {
	
	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes( new RouteBuilder() {
			public void configure() throws Exception {
				
				from("file:entrada?delay=2s&noop=true")
					.marshal()
					.xmljson()
//					.log("${body}")
					.log("03")
				.to("file:saida3")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						Path dir = Paths.get("saida3");
					    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.xml")) {
					    	for (Path xmlFile: stream) {
					    		Path toJson = Paths.get(xmlFile.toString().replace(".xml", ".json"));
					    		Files.move(xmlFile, toJson, StandardCopyOption.REPLACE_EXISTING);
						    }
					    }
					}
				});
			}
		});
		ctx.start();
		Thread.sleep(15*1000);
		ctx.stop();
	}

}