package com.example.codewars3.dataservicetype;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class RabbitMqServiceImpl implements RabbitMqService {

    public static class Configuration {

        private String someConfigVariable;

        private String port;

        private Configuration(String localhost, String port) {
            this.someConfigVariable = localhost;
            this.port = port;
        }

        public String getPort() {
            return port;
        }

        public String getSomeConfigVariable() {
            return someConfigVariable;
        }

        public static Configuration configOf(String host, String port) {
            return new Configuration(host, port);
        }
    }


    private final Configuration rabbitConnectionDetail;


    private RabbitMqServiceImpl(final Configuration rabbitConnectionDetail) {
        this.rabbitConnectionDetail = rabbitConnectionDetail;
    }


    @Override
    public void connectClientToBroker() {
        System.out.println("connecting client to broker");
    }


    @Override
    public void createClient(final String clientType, final String identifier) {

        System.out.println("creating client");
    }


    @Override
    public void disconnectClientFromBroker() {
        System.out.println("disconnecting client");
    }


    @Override
    public void isClientConnectedToBroker() {
        System.out.println("client is connected to broker: " + new Random().nextBoolean());
    }


    public static RabbitMqService ofConfig(final Configuration config) {

        final int minPort = 0;
        final int maxPort = 65353;

        if (!config.getPort().matches("\\d+") || parseInt(config.getPort()) < minPort || parseInt(config.getPort()) > maxPort)
            throw new IllegalArgumentException("messageQueue.active is true, but missing correct messageQueue.consumer.rabbit.port.mqttwss");

        if (config.getSomeConfigVariable().isBlank())
            throw new IllegalArgumentException("messageQueue.active is true, but missing correct messageQueue.consumer.rabbit.someconfig");

        return new RabbitMqServiceImpl(config);
    }

}
