package com.example.codewars3.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccumulatorTest {

    static class Rating {

        double points;
        List<Review> reviews = new ArrayList<>();

        public void add(Review review) {
            reviews.add(review);
            computeRating();
        }

        private double computeRating() {
            double totalPoints =
                    reviews.stream().map(Review::getPoints).reduce(0, Integer::sum);
            this.points = totalPoints / reviews.size();
            return this.points;
        }

        public static Rating average(Rating r1, Rating r2) {
            Rating combined = new Rating();
            combined.reviews = new ArrayList<>(r1.reviews);
            combined.reviews.addAll(r2.reviews);
            combined.computeRating();
            return combined;
        }

    }

    static class Review {

        private int points;
        private String review;

        public Review() {
        }

        public Review(int i, String s) {
            this.points = i;
            this.review = s;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }
    }


    private static class User {
        private String name;
        private int age;
        private Rating rating;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Rating getRating() {
            return rating;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }
    }

    public static void main(String[] args) {

        User john = new User("John", 30);
        john.getRating().add(new Review(5, ""));
        john.getRating().add(new Review(3, "not bad"));
        User julie = new User("Julie", 35);
        john.getRating().add(new Review(4, "great!"));
        john.getRating().add(new Review(2, "terrible experience"));
        john.getRating().add(new Review(4, ""));
        List<User> users = Arrays.asList(john, julie);


        Rating averageRating = users.stream()
                .reduce(new Rating(),
                        (rating, user) -> Rating.average(rating, user.getRating()),
                        Rating::average);

        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*Statistics result = numbers.stream()
                .reduce(new Statistics(),
                        (statistics, integer) -> Statistics.createObject(statistics, integer), Statistics::createObject);*/

    }
}
