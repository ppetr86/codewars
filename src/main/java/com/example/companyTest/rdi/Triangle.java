package com.example.companyTest.rdi;

public class Triangle extends Shape {
    protected Double aLen;
    protected Double maHeight;
    protected Double bLen;
    protected Double cLen;

    public Triangle(double aLen, double maHeight) {
        this.aLen = aLen;
        this.maHeight = maHeight;
        this.bLen = null;
        this.cLen = null;
    }

    public Triangle(double aLen, double bLen, double cLen) {
        if (aLen < bLen + cLen || bLen < aLen + cLen || cLen < aLen + bLen) {
            this.aLen = aLen;
            this.cLen = cLen;
            this.bLen = bLen;
            this.maHeight = null;
        } else {
            throw new ArithmeticException("Invalid input");
        }
    }


    @Override
    double areaOfShape(Shape shape) {
        double area = 0.00;
        if (aLen != null && bLen != null && cLen != null) {
            double s = (this.aLen + this.bLen + this.cLen) / 2;
            area = Math.sqrt(s * (s - aLen) * (s - bLen) * (s - cLen));
        } else if (this.aLen != null & this.maHeight != null) {
            area = (aLen * maHeight) / 2;
        }
        return area;
    }
}
