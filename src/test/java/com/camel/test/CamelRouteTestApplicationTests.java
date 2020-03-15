package com.camel.test;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.engine.DefaultProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;

import java.io.File;
public class CamelRouteTestApplicationTests {

	@Produce("timerRoute")
	ProducerTemplate template ;

	@Test
	@DirtiesContext
	public void testFileMover() throws Exception{

		template.sendBody("direct:testRoute", "Junit test case ofr camel route!");
		Thread.sleep(2000);
	}
}
