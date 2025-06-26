package com.github.tirnak.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tirnak.generated.client.api.VisitsClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.Retryer.NEVER_RETRY;

@Configuration
public class FeignConfiguration {

    @Value("${feign.clients.visits.url}")
    private String visitsServiceUrl;

    @Bean
    public VisitsClient dictionaryApiClient(ObjectMapper mapper) {
        return Feign.builder()
                .encoder(new JacksonEncoder(mapper))
                .decoder(new JacksonDecoder(mapper))
                .retryer(NEVER_RETRY)
                .target(VisitsClient.class, visitsServiceUrl);
    }
}
