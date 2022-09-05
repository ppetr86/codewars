package com.example.codewars3.codewars.kyu6;
//https://www.codewars.com/kata/design-a-simple-automaton-finite-state-machine

import java.util.Arrays;
import java.util.List;

public class Automaton {

    static class StateMachine {
        private List<Transition> transitions;
        private String command;
        private State current;
        private State next;

        public static StateMachine build(TransitionConfiguration config, String command,
                                         State current) {
            return new StateMachine(config.getTransitions(), command, current);
        }

        public StateMachine(List<Transition> transitions, String command, State current) {
            this.transitions = transitions;
            this.command = command;
            this.current = current;
        }

        public StateMachine() {
        }


        /**
         * Apply a new action to the current request
         */
        public StateMachine apply(Action action) {
            for (Transition transition : transitions) {
                boolean currentStateMatches = transition.from.equals(current);

                if (currentStateMatches && action != null && action.equals(transition.action)) {
                    System.out.println("Applying from: " + transition.from + ", to: " + transition.to + " to request");

                    next = transition.to;
                    break;
                }
            }

            return this;
        }

    }

    private enum Action {
        ONE(),
        ZERO();
    }


    private enum State {
        Q1, Q2, Q3;
    }

    static class Transition {
        State from;
        Action action;
        State to;

        public Transition(State from, Action action, State to) {
            this.from = from;
            this.to = to;
            this.action = action;
        }
    }

    private enum TransitionConfiguration {
        DEFAULT(Arrays.asList(
                new Transition(State.Q1, Action.ONE, State.Q2),
                new Transition(State.Q1, Action.ZERO, State.Q1),

                new Transition(State.Q2, Action.ZERO, State.Q3),
                new Transition(State.Q2, Action.ONE, State.Q2),

                new Transition(State.Q3, Action.ZERO, State.Q2),
                new Transition(State.Q3, Action.ONE, State.Q2)
        ));

        private List<Transition> transitions;

        TransitionConfiguration(List<Transition> transitions) {
            this.transitions = transitions;
        }

        public List<Transition> getTransitions() {
            return transitions;
        }
    }

    public static void main(String[] args) {
        Automaton s = new Automaton();
        System.out.println(s.readCommands(new String[]{"1", "0", "0", "1", "0"}));
    }

    public boolean readCommands(String[] commands) {
        State current = State.Q1;
        for (String command : commands) {
            StateMachine sm = StateMachine.build(TransitionConfiguration.DEFAULT, command, current);
            sm.apply(command.equals("1") ? Action.ONE : command.equals("0") ? Action.ZERO : null);
            current = sm.next;
        }

        return State.Q2.equals(current);
    }
}
