package org.example.Homework.HW11;

public class Number {
    private double real;
    private double imaginary;

    public Number(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static Number parseNumber(String input) {
        try {
            if (input.contains("+") || input.contains("-")) {
                int signIndex = input.lastIndexOf("+");
                if (signIndex == -1)
                    signIndex = input.lastIndexOf("-");

                double real = Double.parseDouble(input.substring(0, signIndex).trim());
                double imaginary = Double.parseDouble(input.substring(signIndex, input.length() - 1).trim());

                return new Number(real, imaginary);
            } else {
                double real = Double.parseDouble(input);
                return new Number(real, 0.0);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Number add(Number num) {
        double realResult = this.real + num.real;
        double imaginaryResult = this.imaginary + num.imaginary;
        return new Number(realResult, imaginaryResult);
    }

    public Number subtract(Number num) {
        double realResult = this.real - num.real;
        double imaginaryResult = this.imaginary - num.imaginary;
        return new Number(realResult, imaginaryResult);
    }

    public Number multiply(Number num) {
        double realResult = (this.real * num.real) - (this.imaginary * num.imaginary);
        double imaginaryResult = (this.real * num.imaginary) + (this.imaginary * num.real);
        return new Number(realResult, imaginaryResult);
    }

    public Number divide(Number num) {
        double denominator = (num.real * num.real) + (num.imaginary * num.imaginary);
        double realResult = ((this.real * num.real) + (this.imaginary * num.imaginary)) / denominator;
        double imaginaryResult = ((this.imaginary * num.real) - (this.real * num.imaginary)) / denominator;
        return new Number(realResult, imaginaryResult);
    }

    public boolean isZero() {
        return real == 0.0 && imaginary == 0.0;
    }

    @Override
    public String toString() {
        if (imaginary == 0.0) {
            return String.valueOf(real);
        } else if (real == 0.0) {
            return imaginary + "i";
        } else if (imaginary < 0.0) {
            return real + " - " + (-imaginary) + "i";
        } else {
            return real + " + " + imaginary + "i";
        }
    }
}
