package exercise5;

// Product interface
interface Shape {
    void draw();
}

// Concrete Product 1
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete Product 2
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Concrete Product 3
class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Factory class
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        switch (shapeType.toLowerCase()) {
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            case "square": return new Square();
            default: return null;
        }
    }
}

// Client
public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("circle");
        shape1.draw();

        Shape shape2 = factory.getShape("rectangle");
        shape2.draw();

        Shape shape3 = factory.getShape("square");
        shape3.draw();
    }
}
