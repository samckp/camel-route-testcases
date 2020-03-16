package com.camel.test.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:testRoute")
                .routeId("testRoute")
                .log(LoggingLevel.INFO, "${body}")
                .to("mock:endpoint")
        ;
    }
}
