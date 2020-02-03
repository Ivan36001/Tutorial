package Новый_курс;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Linked_list2 {
    public static void main(String[] args) {
        List<Integer> linkedlist=new LinkedList<>();// реализует интерфейс List
        List <Integer> arraylist=new ArrayList<>();
        time(linkedlist);
        time(arraylist);//гораздо быстрее считывается
    }
    private static void time (List<Integer> x) {//типы совпадают еще один плюс использования
        //названия интерфейса слева при создании объектов в методе main.
        for (int i = 0; i <10000 ; i++) {//заполняем элементами
            x.add(i);
        }
            long start=System.currentTimeMillis();
            for (int i = 0; i <10000 ; i++) {//считываем элементы
                x.get(i);
            }
            long end=System.currentTimeMillis();
            System.out.println(end-start);
        }
    }
