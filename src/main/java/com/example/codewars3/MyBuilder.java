package com.example.codewars3;

import java.util.Date;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class MyBuilder {

    static class Calzone extends Pizza {
        public static class Builder extends Pizza.Builder<Builder> {
            private boolean sauceInside = false; // Default

            @Override
            public Calzone build() {
                return new Calzone(this);
            }

            public Builder sauceInside() {
                sauceInside = true;
                return this;
            }

            @Override
            protected Builder self() {
                return this;
            }
        }

        private final boolean sauceInside;

        private Calzone(Builder builder) {
            super(builder);
            sauceInside = builder.sauceInside;
        }
    }

    static class NutritionFacts {
        static class Builder {

            // Required parameters
            private final int servingSize;
            private final int servings;
            //optional params
            private int calories = 0;
            private int fat = 0;
            private int sodium = 0;
            private int carbohydrate = 0;

            public Builder(int servingSize, int servings) {
                this.servingSize = servingSize;
                this.servings = servings;
            }

            public NutritionFacts build() {
                return new NutritionFacts(this);
            }

            public Builder calories(int val) {
                this.calories = val;
                return this;
            }

            public Builder carbohydrate(int val) {
                carbohydrate = val;
                return this;
            }

            public Builder fat(int val) {
                fat = val;
                return this;
            }

            public Builder sodium(int val) {
                sodium = val;
                return this;
            }
        }

        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrate;

        private NutritionFacts(Builder builder) {

            if (builder.servingSize > 1111 || builder.servings > 1111 || builder.calories > 1111)
                throw new IllegalArgumentException("Illegal Argument");

            servingSize = builder.servingSize;
            servings = builder.servings;
            calories = builder.calories;
            fat = builder.fat;
            sodium = builder.sodium;
            carbohydrate = builder.carbohydrate;
        }


    }

    static class NyPizza extends Pizza {
        public static class Builder extends Pizza.Builder<Builder> {
            private final Size size;

            public Builder(Size size) {
                this.size = Objects.requireNonNull(size);
            }

            @Override
            public NyPizza build() {
                return new NyPizza(this);
            }

            @Override
            protected Builder self() {
                return this;
            }
        }

        public enum Size {SMALL, MEDIUM, LARGE}

        private final Size size;

        private NyPizza(Builder builder) {
            super(builder);
            size = builder.size;
        }
    }

    static abstract class Pizza {
        abstract static class Builder<T extends Builder<T>> {
            EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

            public T addTopping(Topping topping) {
                toppings.add(Objects.requireNonNull(topping));
                return self();
            }

            // Subclasses must override this method to return "this"
            protected abstract T self();


            abstract Pizza build();
        }

        public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

        final Set<Topping> toppings;

        Pizza(Builder<?> builder) {
            toppings = builder.toppings.clone(); // See Item 50
        }
    }

    static class Task {
        private final long id;
        private String summary = "";
        private String description = "";
        private boolean done = false;
        private Date dueDate;

        public Task(long id) {
            this.id = id;
        }

        public Task(long id, String summary, String description, boolean done, Date dueDate) {
            this.id = id;
            this.summary = summary;
            this.description = description;
            this.done = done;
            this.dueDate = dueDate;

        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getDueDate() {
            return new Date(dueDate.getTime());
        }

        public void setDueDate(Date dueDate) {
            this.dueDate = new Date(dueDate.getTime());
        }

        public long getId() {
            return id;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }

    static class TaskBuilder {

        private long id;
        private String summary = "";
        private String description = "";
        private boolean done = false;
        private Date dueDate;

        public TaskBuilder(long id, String summary, String description, boolean done, Date dueDate) {
            this.id = id;
            this.summary = summary;
            this.description = description;
            this.done = done;
            this.dueDate = dueDate;
        }


        public TaskBuilder() {
        }

        public Task build() {
            return new Task(id, summary, description, done, dueDate);
        }

        public TaskBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder setDone(boolean done) {
            this.done = done;
            return this;
        }

        public TaskBuilder setDueDate(Date dueDate) {
            this.dueDate = new Date(dueDate.getTime());
            return this;
        }

        public TaskBuilder setId(long id) {
            if (this.id == 0) this.id = id;
            return this;
        }

        public TaskBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }
    }

    public static void main(String[] args) {
        var task = new TaskBuilder().setId(5L).setDescription("Hello").setSummary("Test").build();

        var cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).sauceInside().build();
    }
}
