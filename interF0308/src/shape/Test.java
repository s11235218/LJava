package shape;

public class Test {
    public static void main(String[] args) {
//        Shape shape1 = new Circle();
//        Shape shape2 = new Flower();
//        Shape shape3 = new Rectangle();
//
//        shape1.draw();
//        shape2.draw();
//        shape3.draw();
//
//        // 多态
//        Shape shape = new Circle();
//        shape.draw();
//
//        shape = new Flower();
//        shape.draw();
//
//        shape = new Rectangle();
//        shape.draw();

        drawShapes2();
    }

    public static void drawShapes(){
        String[] shapes = {"circle", "rectangle", "flower", "circle", "flower"};

        // for each
        // 圈复杂度
        for(String shape: shapes){
            if(shape.equals("circle")){
                Circle circle = new Circle();
                circle.draw();
            }else if(shape.equals("rectangle")){
                Rectangle rectangle = new Rectangle();
                rectangle.draw();
            }else if(shape.equals("flower")){
                Flower flower = new Flower();
                flower.draw();
            }
        }
    }

    public static void drawShapes2(){
        Shape[] shapes = {new Circle(), new Rectangle(),
                new Flower(), new Rectangle(), new Circle()};

        for(Shape shape: shapes){
            shape.draw();
        }
    }
}
