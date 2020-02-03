package Новый_курс;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//СВЯЗНЫЙ СПИСОК
public class Linked_list {
    public static void main(String[] args) {
        List <Integer> linkedlist=new LinkedList<>();// реализует интерфейс List
        // и в случае добавления новых элементов на поз. 0 работает быстрее т.к.
        //перемещает целеком всю цепочку узлов в право и добавляет новый элемент на место нулевого узла между
        //головным узлом и сущ.цепочкой (head->нов элемент->сущ. узел смещенный в право->и т.д.)
        //т.о. в linkedlist хранится не массив а цепочка объектов(узлов с сылками между собой)
        List <Integer> arraylist=new ArrayList<>();
        time(linkedlist);
        time(arraylist);//быстрее добавляет элементы (добавление в конец листа [0]->[0][1]->[0][1][2] и т.д.)
    }
    private static void time (List<Integer> x) {//типы совпадают еще один плюс использования
        //названия интерфейса слева при создании объектов в методе main.
        long start=System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {//заполняем элементами
            x.add(i);
            //в случае вставки нового элемента на позицию с индексом 0
            //( x.add(index:0,i);) приходится смещать весь сущ. массив поэлементно вправо
            //и длительность добавления элементов для arraylist-а будет
            //гораздо больше чем для linkedlist
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}



