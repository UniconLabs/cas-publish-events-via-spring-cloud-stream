package org.apereo.cas.support.events.publish.config;

import org.apereo.cas.support.events.publish.CasEventsSpringCloudStreamPublisher;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration class for cas events spring cloud stream subsystem.
 *
 * @author Dmitriy Kopylenko
 */
@Configuration
@EnableBinding(Source.class)
public class CasEventsSpringCloudStreamConfiguration {

    @Bean
    public CasEventsSpringCloudStreamPublisher casEventsSpringCloudStreamPublisher(Source messagingSource) {
        return new CasEventsSpringCloudStreamPublisher(messagingSource);
    }
}
