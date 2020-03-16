package com.camel.test;

import com.camel.test.route.TestRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RouteTest extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
			return new TestRoute();
	}

	@Test
	public void testFileMover() throws Exception{

		String expected="Hello";

		MockEndpoint mock = getMockEndpoint("mock:endpoint");
		mock.expectedBodiesReceived(expected);
		template.sendBody("direct:testRoute","Hello" );
		assertMockEndpointsSatisfied();
	}
}
