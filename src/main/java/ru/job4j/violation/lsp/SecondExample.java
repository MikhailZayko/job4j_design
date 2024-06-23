package ru.job4j.violation.lsp;

/**
 * Подкласс Square изменяет поведение методов setWidth и setHeight,
 * так что они больше не работают независимо друг от друга, как в суперклассе Rectangle.
 * Это нарушает LSP, так как объект Square не может корректно заменить объект Rectangle.
 */

public class SecondExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Area: " + rectangle.getArea());
    }
}

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}



