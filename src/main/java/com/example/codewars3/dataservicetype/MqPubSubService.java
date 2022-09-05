package com.example.codewars3.dataservicetype;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface MqPubSubService {

    public enum PublishResult {
        OK,
        PARTIAL,
        DISCONNECTED
    }


    PublishResult publishToBroker(String fullRoutingKey, String payload);


    PublishResult sendCommandToPos(Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId, MqCommandType command);


    PublishResult sendCommandToPos(Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId, String command);
}
