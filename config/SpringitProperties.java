package com.ehayes.springit2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("Springit")
public class SpringitProperties {

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    private String welcomeMsg = "Hello, World";
}
