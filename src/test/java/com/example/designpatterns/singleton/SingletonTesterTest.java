package com.example.designpatterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTesterTest {

    @Test
    void isSingleton() {
        Object obj = new Object();
        assertTrue(SingletonTester.isSingleton(() -> obj));
        assertFalse(SingletonTester.isSingleton(Object::new));
    }
}