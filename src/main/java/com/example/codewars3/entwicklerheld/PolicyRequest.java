package com.example.codewars3.entwicklerheld;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PolicyRequest {

    public enum State {
        INCOMPLETE,
        NEW,
        IN_REVIEW,
        READY_FOR_TRANSMISSION,
        TRANSMITTED,
        DUPLICATE_FAKE,
        SUCCESSFUL,
        INACTIVE,
        CANCELED,
        NOT_SUCCESSFUL,
        ERROR;
    }

    static class Transition {
        State from;
        Action action;
        State to;

        public Transition(State from, Action action, State to) {
            this.from = from;
            this.action = action;
            this.to = to;
        }
    }

    enum Action {
        TO_NEXT, TO_SUCCESSFUL, TO_NOT_SUCCESSFUL, TO_CANCELED, TO_INACTIVE, TO_DUPLICATE_FAKE, TO_ERROR
    }

    enum TransitionConfiguration {
        DEFAULT(Arrays.asList(
                new Transition(State.INCOMPLETE, Action.TO_NEXT, State.NEW),
                new Transition(State.INCOMPLETE, Action.TO_DUPLICATE_FAKE, State.DUPLICATE_FAKE),
                new Transition(State.NEW, Action.TO_NEXT, State.IN_REVIEW),
                new Transition(State.NEW, Action.TO_DUPLICATE_FAKE, State.DUPLICATE_FAKE),
                new Transition(State.IN_REVIEW, Action.TO_NEXT, State.READY_FOR_TRANSMISSION),
                new Transition(State.IN_REVIEW, Action.TO_NEXT, State.DUPLICATE_FAKE),
                new Transition(State.NEW, Action.TO_DUPLICATE_FAKE, State.DUPLICATE_FAKE),
                new Transition(State.READY_FOR_TRANSMISSION, Action.TO_NEXT, State.TRANSMITTED),
                new Transition(State.TRANSMITTED, Action.TO_SUCCESSFUL, State.SUCCESSFUL),
                new Transition(State.TRANSMITTED, Action.TO_NOT_SUCCESSFUL, State.NOT_SUCCESSFUL),
                new Transition(State.SUCCESSFUL, Action.TO_INACTIVE, State.INACTIVE),
                new Transition(State.SUCCESSFUL, Action.TO_CANCELED, State.CANCELED),

                new Transition(State.INCOMPLETE, Action.TO_ERROR, State.ERROR),
                new Transition(State.NEW, Action.TO_ERROR, State.ERROR),
                new Transition(State.IN_REVIEW, Action.TO_ERROR, State.ERROR),
                new Transition(State.READY_FOR_TRANSMISSION, Action.TO_ERROR, State.ERROR),
                new Transition(State.TRANSMITTED, Action.TO_ERROR, State.ERROR),
                new Transition(State.SUCCESSFUL, Action.TO_ERROR, State.ERROR)
        ));

        private List<Transition> transitions;

        TransitionConfiguration(List<Transition> transitions) {
            this.transitions = transitions;
        }

        public List<Transition> getTransitions() {
            return transitions;
        }
    }

    static class StateMachine {
        private List<Transition> transitions;
        private PolicyRequest request;

        /**
         * Create StateMachine instance
         */
        public static StateMachine build(TransitionConfiguration config, PolicyRequest request) {
            return new StateMachine(config, request);
        }

        private StateMachine(TransitionConfiguration config, PolicyRequest request) {
            this.request = request;
            this.transitions = config.getTransitions();
        }

        /**
         * Apply a new action to the current request
         */
        public StateMachine apply(Action action) {
            for (Transition transition : transitions) {
                boolean currentStateMatches = transition.from.equals(request.getState());
                boolean conditionsMatch = transition.action.equals(action);

                if (currentStateMatches && conditionsMatch) {
                    System.out.println("Applying " + transition.to + " to request");

                    request.setState(transition.to);
                    break;
                }
            }

            return this;
        }
    }

    private State state;
    private String iban;

    public PolicyRequest(State currentState) {
        this.state = currentState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public PolicyRequest(String state, String iban) {
        State match = getMatch(state);
        StateMachine stateMachine = StateMachine.build(TransitionConfiguration.DEFAULT, new PolicyRequest(match));
        this.state = match;
        this.iban = iban;
    }

    private State getMatch(String state) {
        return Arrays.stream(State.values()).filter(val -> val.name().equalsIgnoreCase(state)).findFirst().orElse(State.ERROR);
    }

    public String getLeadState() {
        return state.name();
    }


    public Set<String> getPossibleNextStates() {
        return TransitionConfiguration.DEFAULT.getTransitions().stream()
                .filter(transition -> transition.from.equals(state))
                .map(transition -> transition.to.name())
                .collect(Collectors.toSet());
    }


    public boolean transitionState(String to) {
        State toState = getMatch(to);
        if (state.equals(State.INCOMPLETE) && toState.equals(State.NEW)) {
            if (isIbanValid(iban)) {
                state = State.NEW;
                return true;
            }
            return false;

        }
        boolean result = getPossibleNextStates().contains(toState.name());
        if (result) state = toState;
        return result;
    }

    public boolean isIbanValid(String iban) {
        if (iban == null) return false;
        iban = iban.replace("\\s", "").toUpperCase();
        iban = iban.substring(4) + iban.substring(0, 4);

        String total = "";
        for (int i = 0; i < iban.length(); i++) {
            int charValue = Character.getNumericValue(iban.charAt(i));
            if (charValue < 0 || charValue > 35)
                return false;
            total += charValue;
        }

        BigInteger totalInt = new BigInteger(total);
        return totalInt.mod(new BigInteger("97")).equals(BigInteger.ONE);
    }


}