package org.apereo.cas.support.events.publish;

import org.apereo.cas.support.events.ticket.CasTicketGrantingTicketCreatedEvent;
import org.apereo.cas.util.AsciiArtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Publish CAS events to Spring Cloud Stream 'output' messaging channel.
 *
 * @author Dmitriy Kopylenko
 */
public class CasEventsSpringCloudStreamPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(CasEventsSpringCloudStreamPublisher.class);

    private Source messagingSource;

    public CasEventsSpringCloudStreamPublisher(Source messagingSource) {
        this.messagingSource = messagingSource;
    }

    @EventListener
    public void handleCasTicketGrantingTicketCreatedEvent(final CasTicketGrantingTicketCreatedEvent event) {

        AsciiArtUtils.printAsciiArtInfo(LOGGER, "SSO session established", String.format("User [%s] logged in at [%s]",
                event.getTicketGrantingTicket().getAuthentication().getPrincipal().getId(), event.getTicketGrantingTicket()
                        .getCreationTime().toString()));

        this.messagingSource.output()
                .send(MessageBuilder.withPayload(event.getTicketGrantingTicket().getAuthentication()).build());
    }
}
