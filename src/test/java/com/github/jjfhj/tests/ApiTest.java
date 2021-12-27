package com.github.jjfhj.tests;

import com.github.jjfhj.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTest {

    @Test
    public void apiTests() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.baseURL()).isEqualTo("https://www.mvideo.ru/");
        assertThat(apiConfig.token()).isEqualTo("tokenMvideo");
    }
}
