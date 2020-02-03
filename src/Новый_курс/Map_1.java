package Новый_курс;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;
//map переводится как карта или отображение (в piton-словарь)
public class Map_1 {
    public static void main(String[] args) {
        Map<Integer,String> g =new HashMap<>();//слева указан интерфейс Map который реализует
        //класс HashMap
        g.put(1, "Один");//метод принимает на вход два аргумента, где первый аргумент это
        //ключ (1), а второй это значение ("Один"). Пара ключ-значение это Entry(структура данных)
        g.put(2, "Два");//объект класса Entry
        g.put(3, "Три");//объект класса Entry

        System.out.println(g);
        g.put(3, "Новое значение для ключа три");//после вставки нового значения для ключа три
        //старое перезаписывается (т.е в map не может быть дубликатов ключей)
        System.out.println(g);

        System.out.println(g.get(1));//метод get()-получение значения по ключу если пары
        // ключ значение нет вернется null
        for (Map.Entry<Integer,String> x : g.entrySet()) {//метод entrySet() возвращает все объекты класса
            //Entry для нашего HashMap g.
            System.out.println(x.getKey()+":"+x.getValue());//два метода класса Entry для получения
            // ключа и значения. Элементы (пары) в классе HashMap не имеют порядка(!) и привыводе может возни
            //кать абсолютно случайный порядок. Т.о класс HashMap используется когда порядок пар не важен.
                   }

    }

}
