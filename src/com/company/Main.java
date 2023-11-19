package com.company;

import java.time.Year;
import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Film film15 = new Film("Терминатор 2: Судный день",Year.of(1991),8.7f,95087);
        Film film2 = new Film("Побег из Шоушенка",Year.of(1994),9.0f,121231);
        Film film3 = new Film("Форрест Гамп",Year.of(1994),9.0f,127251);
        Film film4 = new Film("1+1",Year.of(2011),9.0f,352368);
        Film film5 = new Film("Список Шиндлера",Year.of(1993),8.9f,43050);
        Film film6 = new Film("Интерстеллар",Year.of(2014),8.9f,104647);
        Film film7 = new Film("Властелин колец: Возвращение короля",Year.of(2003),8.9f,41040);
        Film film8 = new Film("Бойцовский клуб",Year.of(1999),8.9f,247733);
        Film film9 = new Film("Криминальное чтиво",Year.of(1994),8.8f,114725);
        Film film10 = new Film("Иван Васильевич меняет профессию",Year.of(1973),8.8f,152157);
        Film film11 = new Film("Властелин колец: Две крепости",Year.of(2002),8.8f,38513);
        Film film12 = new Film("Властелин колец: Братство Кольца",Year.of(2001),8.8f,55202);
        Film film13 = new Film("Король Лев",Year.of(1994),8.7f,76523);
        Film film14 = new Film("Остров проклятых",Year.of(2009),8.7f,167684);
        Film film1 = new Film("Зеленая миля",Year.of(1999),9.2f,126498);

        Film list[] = {film15,film2,film3,film4,film5,film6,film7,film8,film9,film10,film11,film12,film13,film14,film1};

        int max = 0;

        for (Film film : list){
            if (film.name.length() > max){
                max = film.name.length();
            }
        }
        System.out.println("По какому полю сортировать?");
        System.out.println("1)По названию");
        System.out.println("2)По году выпуска");
        System.out.println("3)По рейтингу");
        System.out.println("4)По просмотрам");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            System.out.println(choice);
        } else {
            System.out.println("Вы ввели не целое число");
        }

        switch (choice){
            case 1:     for (int i = 0; i < list.length; i++){ // по алфавиту
                        int j_max = i;
                            for(int j = i+1; j < list.length; j++){
                                if(list[j].name.charAt(0) < list[j_max].name.charAt(0)){
                                    j_max = j;
                                }
                            }
                        Film temp = list[i];
                        list[i] = list[j_max];
                        list[j_max] = temp;
                        } break;

            case 2:     for (int i = 0; i < list.length; i++){ // по году
                        int j_max = i;
                            for(int j = i+1; j < list.length; j++){
                                if(list[j_max].released.isAfter(list[j].released)){
                                    j_max = j;
                                }
                            }
                        Film temp = list[i];
                        list[i] = list[j_max];
                        list[j_max] = temp;
                        } break;

            case 3:     for (int i = 0; i < list.length; i++){ // по оценке
                        int j_max = i;
                            for(int j = i+1; j < list.length; j++){
                                if(list[j_max].rating < list[j].rating){
                                    j_max = j;
                                }
                            }
                        Film temp = list[i];
                        list[i] = list[j_max];
                        list[j_max] = temp;
                        } break;

            case 4:     for (int i = 0; i < list.length; i++){ // по просмотрам
                        int j_max = i;
                            for(int j = i+1; j < list.length; j++){
                                if(list[j_max].views < list[j].views){
                                    j_max = j;
                                }
                            }
                        Film temp = list[i];
                        list[i] = list[j_max];
                        list[j_max] = temp;
                        } break;
            default: break;
        }

        try(FileWriter writer = new FileWriter("Films.txt", false))
        {
           for(Film film: list){
               writer.write(film.name);
               for(int i = film.name.length(); i < max; i++){
                   writer.write(" ");
               }
               writer.write("|  " + film.released + " г.  |  " + film.rating + "  |  " + film.views + " просмотров");

               writer.append('\n');

           }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}