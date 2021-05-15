package org.investment.bitcoin.markettickpricenotifyservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;

@Configuration
public class FeginConfiguration {

    private String getFirebaseAccessToken() throws IOException {
        String firebaseConfigPath = "firebase/firebase_service_key.json";
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
                .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
        googleCredentials.refreshIfExpired
                ();
        return googleCredentials.getAccessToken().getTokenValue();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            try {
                requestTemplate.header("Content-Type", "application/json");
                requestTemplate.header("Authorization", "Bearer " + getFirebaseAccessToken());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
