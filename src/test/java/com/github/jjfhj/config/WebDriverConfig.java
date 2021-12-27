package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${typeProperties}.properties"})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("versionBrowser")
    @DefaultValue("91.0")
    String versionBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteWebDriver")
    String remoteWebDriver();
}
