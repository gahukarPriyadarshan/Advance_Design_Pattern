package FactoryPattern;

import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        System.out.println("Enter the shape type ");
        String channel =s.nextLine();
        ShapeFactory shapeFactory= new ShapeFactory();
        Shape shape = shapeFactory.getShape(channel.toLowerCase());
        shape.draw();

    }
}
