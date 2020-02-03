package Новый_курс;

import java.util.ArrayList;
//ДИНАМИЧЕСКИЙ МАССИВ
public class ArayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();//справа Integer можно не писать, слева лучше
        // писать название интерфейса реализуемого ArrayList-ом (List<Integer> list = new ArrayList<>();)
        // для последующего удобного преобразования в др. класс реализующий
        // интерфейс  List (list=new Linkedlist<>();),
        //по умолчанию размер AL равен 10 ,если требуется больше можно указать значение
        //в скобках (ArrayList<Integer> list = new ArrayList<>(1000))
        for (int i = 0; i < 10; i++) {
            list.add(i);// метод добавляет элемент в ArrayList
        }
        System.out.println(list);
        System.out.println(list.get(3));//метод получает элемент из ArrayList
        //получаем именно элемент 3 а не 2(который идет 3-им по счету)
        System.out.println(list.get(9));
        System.out.println(list.size()+"Размер");//возвращает размер ArrayList
        //Способы перебора всех элементов ArrayList-а:
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(i);

        }
        for (Integer x: list)
            System.out.println(x);
        list.remove(5);//удаление элемента (происходит с последующим смещением элементов
        // справа от удаляемого влево, что требует много ресурсов при удалении элемента до
        // примерно середины ArrayList-а)
        System.out.println(list);
    }
}
//ArrayList использует для реализации обычный массив который при необходимости
//заменяется на больший с копированием  в него элементов из старого массива
//для просмотра реализации класса: ПКМ по классу--->go to--->Implementation
