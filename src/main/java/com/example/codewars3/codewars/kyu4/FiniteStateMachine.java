package com.example.codewars3.codewars.kyu4;
//https://www.codewars.com/kata/54acc128329e634e9a000362
//https://www.codewars.com/kata/54acc128329e634e9a000362/solutions/java

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiniteStateMachine {
    enum Action {
        APP_PASSIVE_OPEN,
        APP_ACTIVE_OPEN,
        APP_SEND,
        APP_CLOSE,
        APP_TIMEOUT,
        RCV_SYN,
        RCV_ACK,
        RCV_SYN_ACK,
        RCV_FIN,
        RCV_FIN_ACK
    }

    enum State {
        CLOSED,
        LISTEN,
        SYN_SENT,
        SYN_RCVD,
        ESTABLISHED,
        CLOSE_WAIT,
        LAST_ACK,
        FIN_WAIT_1,
        FIN_WAIT_2,
        CLOSING,
        TIME_WAIT
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

    enum TransitionConfiguration {
        DEFAULT(Arrays.asList(
                new Transition(State.CLOSED, Action.APP_PASSIVE_OPEN, State.LISTEN),
                new Transition(State.CLOSED, Action.APP_ACTIVE_OPEN, State.SYN_SENT),
                new Transition(State.LISTEN, Action.RCV_SYN, State.SYN_RCVD),
                new Transition(State.LISTEN, Action.APP_SEND, State.SYN_SENT),
                new Transition(State.LISTEN, Action.APP_CLOSE, State.CLOSED),
                new Transition(State.SYN_RCVD, Action.APP_CLOSE, State.FIN_WAIT_1),
                new Transition(State.SYN_RCVD, Action.RCV_ACK, State.ESTABLISHED),
                new Transition(State.SYN_SENT, Action.RCV_SYN, State.SYN_RCVD),
                new Transition(State.SYN_SENT, Action.RCV_SYN_ACK, State.ESTABLISHED),
                new Transition(State.SYN_SENT, Action.APP_CLOSE, State.CLOSED),
                new Transition(State.ESTABLISHED, Action.APP_CLOSE, State.FIN_WAIT_1),
                new Transition(State.ESTABLISHED, Action.RCV_FIN, State.CLOSE_WAIT),
                new Transition(State.FIN_WAIT_1, Action.RCV_FIN, State.CLOSING),
                new Transition(State.FIN_WAIT_1, Action.RCV_FIN_ACK, State.TIME_WAIT),
                new Transition(State.FIN_WAIT_1, Action.RCV_ACK, State.FIN_WAIT_2),
                new Transition(State.CLOSING, Action.RCV_ACK, State.TIME_WAIT),
                new Transition(State.FIN_WAIT_2, Action.RCV_FIN, State.TIME_WAIT),
                new Transition(State.TIME_WAIT, Action.APP_TIMEOUT, State.CLOSED),
                new Transition(State.CLOSE_WAIT, Action.APP_CLOSE, State.LAST_ACK),
                new Transition(State.LAST_ACK, Action.RCV_ACK, State.CLOSED)
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
        private String command;
        private State current;
        private State next;

        public static StateMachine build(TransitionConfiguration config, String command, State current) {
            return new StateMachine(config.getTransitions(), command, current);
        }

        public StateMachine(List<Transition> transitions, String command, State current) {
            this.transitions = transitions;
            this.command = command;
            this.current = current;
        }

        public StateMachine() {
        }


        public StateMachine apply(Action action) {
            for (Transition transition : transitions) {
                boolean currentStateMatches = transition.from.equals(current);

                if (currentStateMatches && action != null && action.equals(transition.action)) {
                    //System.out.println("Applying from: " + transition.from + ", to: " + transition.to + " to request");

                    next = transition.to;
                    break;
                }
            }

            return this;
        }

    }

    public static String traverseStates(String[] events) {
        State result = State.CLOSED;
        for (String event : events) {
            StateMachine fsm = StateMachine.build(TransitionConfiguration.DEFAULT, event, result);
            fsm.apply(Action.valueOf(event));
            result = fsm.next;
        }
        return result == null ? "ERROR" : result.name();
    }

    public static void main(String[] args) {
        //System.out.println(traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN"}));
        System.out.println(traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN", "RCV_ACK", "APP_CLOSE", "APP_SEND"}));
        //[APP_PASSIVE_OPEN, RCV_SYN, RCV_ACK]
        //[APP_ACTIVE_OPEN, RCV_SYN_ACK, RCV_FIN, APP_CLOSE]
        //[APP_ACTIVE_OPEN]

        Map<String, String> map = Map.of("Petr", "Novotny", "Jan", "Bobek");
    }

    final static private String START = "CLOSED", ERROR = "ERROR";
    final static private Map<String, Map<String, String>> STATES = new HashMap<>() {{
        put("CLOSED", Map.of("APP_PASSIVE_OPEN", "LISTEN", "APP_ACTIVE_OPEN", "SYN_SENT"));
        put("LISTEN", Map.of("RCV_SYN", "SYN_RCVD", "APP_SEND", "SYN_SENT", "APP_CLOSE", "CLOSED"));
        put("SYN_RCVD", Map.of("APP_CLOSE", "FIN_WAIT_1", "RCV_ACK", "ESTABLISHED"));
        put("SYN_SENT", Map.of("RCV_SYN", "SYN_RCVD", "RCV_SYN_ACK", "ESTABLISHED", "APP_CLOSE", "CLOSED"));
        put("ESTABLISHED", Map.of("APP_CLOSE", "FIN_WAIT_1", "RCV_FIN", "CLOSE_WAIT"));
        put("FIN_WAIT_1", Map.of("RCV_FIN", "CLOSING", "RCV_FIN_ACK", "TIME_WAIT", "RCV_ACK", "FIN_WAIT_2"));
        put("CLOSING", Map.of("RCV_ACK", "TIME_WAIT"));
        put("FIN_WAIT_2", Map.of("RCV_FIN", "TIME_WAIT"));
        put("TIME_WAIT", Map.of("APP_TIMEOUT", "CLOSED"));
        put("CLOSE_WAIT", Map.of("APP_CLOSE", "LAST_ACK"));
        put("LAST_ACK", Map.of("RCV_ACK", "CLOSED"));
    }};

    public static String traverseStates2(String[] events) {
        String state = START;
        for (String e : events) {
            state = STATES.get(state).get(e);
            if (state == null) return ERROR;
        }
        return state;
    }
}
