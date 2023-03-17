package com.example.dataservicetype;

public class Main {

    private static final String CONSUMER = "rabbit_mq";

    public static void main(String[] args) {
        var service = MqDataServiceType.RABBIT_MQ;
        MqPubSubService service1 = service.getService();
        service1.publishToBroker("part1.part2.part3", "welcome to mqtt");
    }
}
