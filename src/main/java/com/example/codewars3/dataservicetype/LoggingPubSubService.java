package com.example.codewars3.dataservicetype;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class LoggingPubSubService implements MqPubSubService {

    private final Optional<MqPubSubService> innerService;

    public LoggingPubSubService() {
        this.innerService = Optional.empty();
    }

    public LoggingPubSubService(final MqPubSubService innerService) {
        this.innerService = Optional.ofNullable(innerService);
    }

    @Override
    public final PublishResult publishToBroker(final String fullRoutingKey, final String payload) {
        System.out.printf("publishToBroker => fullRoutingKey: %s, payload: %s%n", fullRoutingKey, payload);

        return this.innerService //
                .map(i -> i.publishToBroker(fullRoutingKey, payload)) //
                .orElse(PublishResult.OK);
    }


    @Override
    public final PublishResult sendCommandToPos(final Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId, final MqCommandType command) {
        System.out.printf("sendCommandToPos => mapOfOrgIdWithListOfPosId: %s, command: %s%n", mapToString(mapOfOrgIdWithListOfPosId), command);

        return this.innerService //
                .map(i -> i.sendCommandToPos(mapOfOrgIdWithListOfPosId, command)) //
                .orElse(PublishResult.OK);
    }

    @Override
    public final PublishResult sendCommandToPos(final Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId, final String command) {
        System.out.printf("sendCommandToPos => mapOfOrgIdWithListOfPosId: {}, command: {}", mapToString(mapOfOrgIdWithListOfPosId), command);

        // due to thrown exception -.-
        if (this.innerService.isPresent()) {
            return this.innerService.get().sendCommandToPos(mapOfOrgIdWithListOfPosId, command);
        }

        return PublishResult.OK;
    }

    private final static String mapToString(final Map<UUID, Set<UUID>> mapOfOrgIdWithListOfPosId) {
        if (mapOfOrgIdWithListOfPosId == null) {
            return "null";
        }

        final StringBuilder s = new StringBuilder();
        s.append("{");

        for (final Map.Entry<UUID, Set<UUID>> entry : mapOfOrgIdWithListOfPosId.entrySet()) {
            s.append("\"");
            s.append(entry.getKey());
            s.append("\":");

            if (entry.getValue() != null) {
                s.append("[");

                if (entry.getValue().size() > 0) {
                    s.append("\"");
                    s.append(String.join("\",\"", entry.getValue().stream() //
                            .map(UUID::toString) //
                            .collect(Collectors.toList())));
                    s.append("\"");
                }

                s.append("]");
            }
        }

        s.append("}");

        return s.toString();
    }
}
