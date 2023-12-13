package org.example;

public class ArraySizeLongerException extends Exception{
    public ArraySizeLongerException() {
        super("Введено слишком много данных");
    }
}
