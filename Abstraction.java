Abstraction in Java is a fundamental concept in object-oriented programming (OOP) that allows you to hide the complex implementation details of a class and only show the essential features of the object
There are two primary ways to implement abstraction in Java:
Abstract Classes:An abstract class is a class that cannot be instantiated on its own and may contain one or more abstract methods.
Interfaces:An interface is a reference type similar to a class that can contain only constants, method signatures, default methods, static methods, and nested types.

// Abstract class example
abstract class Shape {
    // Abstract method
    abstract double area();

    // Non-abstract method
    void display() {
        System.out.println("This is a shape.");
    }
}

// Concrete subclass extending abstract class
class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    // Implementation of abstract method
    double area() {
        return Math.PI * radius * radius;
    }
}

// Interface example
interface Vehicle {
    void start();

    void stop();
}

// Concrete class implementing interface
class Car implements Vehicle {
    public void start() {
        System.out.println("Car started.");
    }

    public void stop() {
        System.out.println("Car stopped.");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        // Abstract class usage
        Shape shape = new Circle(5);
        shape.display();
        System.out.println("Area of circle: " + shape.area());

        // Interface usage
        Vehicle vehicle = new Car();
        vehicle.start();
        vehicle.stop();
    }
}
