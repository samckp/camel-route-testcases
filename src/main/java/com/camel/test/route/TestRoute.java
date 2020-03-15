package com.camel.test.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer://mytimer?period=1000&repeatCount=5")
                .routeId("timerRoute")
                .setBody(simple("this is test msg ! ------>"))
                .log(LoggingLevel.INFO, "${body}")
                .to("file:src/main/resources/test.txt")
        ;
    }
}
