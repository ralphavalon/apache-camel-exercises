package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TesteCamel04 {
	
	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes( new RouteBuilder() {
			public void configure() throws Exception {
				
				from("file:entrada?delay=2s&noop=true")
					.split(xpath("//itens/item"))
					.log("04")
					.setHeader("count", simple("${header.CamelSplitIndex}++"))
				.to("file:saida4?fileName=${file:onlyname.noext}_${in.header.count}.xml");
			}
		});
		ctx.start();
		Thread.sleep(15*1000);
		ctx.stop();
	}

}