package com.example.dataservicetype;

public interface RabbitMqService {
    void connectClientToBroker();


    void createClient(final String clientType, final String mqttClientIdentifier);


    void disconnectClientFromBroker();


    void isClientConnectedToBroker();
}
