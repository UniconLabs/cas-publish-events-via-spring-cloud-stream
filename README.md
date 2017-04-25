CAS 5 overlay with spring cloud stream event publishing prototype
============================

> This project is being developed and maintained as part of Unicon's [Open Source Support program](https://unicon.net/opensource).
Professional Support / Integration Assistance for this module is available. For more information [visit](https://unicon.net/opensource/cas).

This is a prototype of code that publishes CAS events (just one at this time) to Spring Cloud Stream output messaging channel.

This implementation uses RabbitMQ binding which results in JSON messages representing CAS `Authentication` object being eventually published
to the default `output` RabbitMQ topic exchange which could be configured on the RabbitMQ side to be bound to any number of Rabbit queues
for interested downstream consumers. On the Spring Boot side there are also a number of property source properties available to customize
bindings e.g. channel/exchange names, content type, Rabbit connection properties, etc.

This repository serves as a template example for Spring Cloud Stream implementation of CAS messaging functionality should such use cases arise in the future.
