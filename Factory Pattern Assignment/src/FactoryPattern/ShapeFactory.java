package FactoryPattern;

public class ShapeFactory {
    public Shape getShape(String channel){
        if(channel==null || channel.isEmpty()){
            return null;
        }
        return switch (channel) {
            case "square" -> new Square();
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            default -> null;
        };
    }
}
