package Новый_курс;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//То что дает джаве понять что это колекция и что по ней можно проходится
// циклом for-each наз. интерфейсом Iterable (пер. то по чему можно проходиться)
// этот интерфейс имеет всего один метод iterator()-c помощью этого метода у любой коллекции можно
// получить объект класса реализующего интерфейс Iterator для обхода ее элементов
//  (в нем описана логика прохождения по элементам нашей колекции:
// boolean hasNext()-проверяет, есть ли еще элементы, E next()-возвращает текущий элемент
// и переключается на следующий, void remove()-удаляет текущий элемент).
// Все классы и и итерфейсы коллекций реализуют интерфейс Iterable. Если мы хотим проходиться
// по элементам нашего собственного класса циклом for-each мы должны реализовать интерфейсы Iterable и Iterator
public class Iterable1 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
         //До java 5:
        Iterator<Integer> iterator=list.iterator();//вызвали метод iterator() который возвращает объект из нашего list
        //реализующий интерфейс Iterator, а следовательно и его методы позволяющие проходиться по элементам нашего list.
        //тут можно использовать метод iterator.remove();-на вход не принимает аргументов, удаляет текущий элемент
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
         //После java 5:
         for (int x: list){//цикл for-each под капотом имеет ту же работу с итератором как в примере выше, идинственное
             //отличие при работе for-each нельзя использовать метод remove() описанный в интерфейсе Iterator.
             System.out.println(x);

         }
        }
    }



