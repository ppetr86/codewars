package com.example.dataservicetype;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class MqttWssPubSubServiceImpl implements MqPubSubService {

    private final RabbitMqService rabbitMqService;

    private MqttWssPubSubServiceImpl(final RabbitMqService rabbitMqService) {
        this.rabbitMqService = Objects.requireNonNull(rabbitMqService);
        System.out.println(getClass().getName() + " constructed");
    }

    @Override
    public PublishResult publishToBroker(String fullRoutingKey, String payload) {
        System.out.println("PUBLISHING TO BROKER");
        System.out.println(fullRoutingKey);
        System.out.println(payload);
        return PublishResult.OK;
    }

    @Override
    public PublishResult sendCommandToPos(Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId, MqCommandType command) {
        System.out.println("SENDING COMMAND TO POS WITH MqCommandType");
        return PublishResult.OK;
    }

    @Override
    public PublishResult sendCommandToPos(Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId, String command) {
        System.out.println("SENDING COMMAND TO POS WITH STRING");
        return PublishResult.OK;
    }

    public final static MqPubSubService ofConfig(final RabbitMqServiceImpl.Configuration config) {
        RabbitMqService rabbitMqService1 = RabbitMqServiceImpl.ofConfig(config);
        final MqPubSubService service = new MqttWssPubSubServiceImpl(rabbitMqService1);

        return new Random().nextBoolean() ? new LoggingPubSubService(service) : service;
    }
}
