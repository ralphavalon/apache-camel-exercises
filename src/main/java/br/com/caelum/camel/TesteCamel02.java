package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TesteCamel02 {
	
	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes( new RouteBuilder() {
			public void configure() throws Exception {
				
				from("file:entrada?delay=2s&noop=true")
					.marshal()
					.xmljson()
//					.log("${body}")
					.log("02")
				.to("file:saida2?fileName=${file:onlyname.noext}.json");
			}
		});
		ctx.start();
		Thread.sleep(15*1000);
		ctx.stop();
	}

}