package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ArraySizeLongerException, ArraySizeSmallException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitArray = input.split(",");
        if (splitArray.length > 6) {
            throw new ArraySizeLongerException();
        } else if (splitArray.length < 6) {
            throw new ArraySizeSmallException();
        }

        String name = null;
        String surname = null;
        String patronymic = null;
        String dateBirth = null;
        String  telephone = null;
        String gender = null;

        for (String item: splitArray) {
            if (item.length() == 1) {
                gender = item;
            } else if (item.contains(".")) {
                dateBirth = item;
            } else if (item.matches("[0-9]+")) {
                telephone = item;
            } else {
                if (surname == null) {
                    surname = item;
                } else if (name == null) {
                    name = item;
                } else {
                    patronymic = item;
                }
            }
        }

        try {
            File file = new File("E://учеба//Программист Специализация//Исключения в программировани//3 семинар//hw//HomeWork//src//main//java//org//example//" + surname + ".txt");
            if (file.createNewFile()){
                System.out.println("файл создан");
            }
            FileWriter writer = new FileWriter(file, true);
            writer.write(surname + name + patronymic + dateBirth + telephone + gender);
            writer.flush();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}