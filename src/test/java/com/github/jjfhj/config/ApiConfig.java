package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/api.properties",
        "classpath:config/api.properties"
})
public interface ApiConfig extends Config {

    @Key("baseURL")
    @DefaultValue("https://www.mvideo.ru/")
    String baseURL();

    @Key("token")
    String token();
}
