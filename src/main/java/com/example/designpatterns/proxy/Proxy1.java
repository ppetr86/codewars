package com.example.designpatterns.proxy;

import lombok.AllArgsConstructor;

public class Proxy1 {

    public static void main(String[] args) {
        var car = new Car(new Driver(12));
        car.drive();

        var proxy = new CarProxy(new Driver(12));
        proxy.drive();
    }

    private interface Drivable{
        void drive();
    }

    @AllArgsConstructor
    private static class Car implements Drivable{
        protected Driver driver;

        @Override
        public void drive() {
            System.out.println("brrrrrbrmmmm");
        }
    }

    @AllArgsConstructor
    private static class Driver{
        private int age;
    }

    private static class CarProxy extends Car{
        public CarProxy(Driver driver){
            super(driver);
        }

        @Override
        public void drive(){
            if(driver.age>=16){
                super.drive();
            } else {
                System.out.println("drive too young...");
            }
        }
    }
}
