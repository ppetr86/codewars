package com.example.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class DynamicLoggingProxyDemo {

    public static void main(String[] args) {
        Person person = new Person();
        Human logged = withLogging(person, Human.class);
        logged.walk();
        logged.talk();
        logged.talk();

        System.out.println(logged);
    }

    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> itf) {
        return (T) Proxy.newProxyInstance(itf.getClassLoader(), new Class<?>[]{itf}, new LoggingHandler(target));
    }

    private interface Human {
        void talk();

        void walk();
    }

    private static class LoggingHandler implements InvocationHandler {
        private final Object target;
        private Map<String, Integer> calls = new HashMap<>();

        LoggingHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();

            if (name.contains("toString")) {
                return calls.toString();
            }

            // add or increment number of calls
            calls.merge(name, 1, Integer::sum);
            return method.invoke(target, args);
        }
    }

    private static class Person implements Human {
        @Override
        public void talk() {
            System.out.println("I am talking");
        }

        @Override
        public void walk() {
            System.out.println("I am walking");
        }
    }
}

