package Новый_курс;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
//SET-МНОЖЕСТВА
public class Set_множества {//не может хранить дубликатов элементов
    public static void main(String[] args) {//классы очень похожи на классы
        //реализующие интерфейс Map:
        Set<String> hashSet=new HashSet<>();//внутри не гарантируется никакого порядка
        Set<String>linkedHashSet=new LinkedHashSet<>();//в каком порядке пары добавлены в таком
        //в таком они и вернутся
        Set<String>treeSet=new TreeSet<>();//пары сортируются по ключу natural order (по
        //естественному порядку) для чисел это от меньшего к большему, для строк-лексикографический порядок
        //т.е. аа<аб

        hashSet.add ("Alice");//метод добавляющий эл-ты отличается от Map( там put)
        hashSet.add ("Tim");
        hashSet.add ("Bob");
        hashSet.add ("Cot");
        hashSet.add ("Jack");
        hashSet.add ("Tim");//дублирование элемента при выводе игнорируется
        for(String name: hashSet){
            System.out.println(name);
        }
        System.out.println();

        linkedHashSet.add ("Alice");
        linkedHashSet.add ("Tim");
        linkedHashSet.add ("Bob");
        linkedHashSet.add ("Cot");
        linkedHashSet.add ("Jack");
        for(String name: linkedHashSet){
            System.out.println(name);
        }
        System.out.println();

        treeSet.add ("Alice");
        treeSet.add ("Tim");
        treeSet.add ("Bob");
        treeSet.add ("Cot");
        treeSet.add ("Jack");
        for(String name: treeSet){
            System.out.println(name);
        }

        System.out.println();
        System.out.println(hashSet.contains("Bob"));//метод возвращает true если эл-т есть в Set
        //и false если его нет. Работает очень быстро. Т.о. если нам нужно узнавать есть ли элемент
        //в каком либо множестве или нет лучше использовать Set чем List
        System.out.println(hashSet.isEmpty());//метод возвращает true если Set пустой, false-есть эл-ты
        System.out.println(treeSet);//мы можем не использовать цикл for each для вывода
        //элементов Set а просто воспользоватся System.out.println() т.к. все классы реализующие
        //интерфейс Set также реализуют метод toString()
    }
}

class MathOperations {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(0);//В скобочках не примитивы, а объекты класса Integer
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2=new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        // union-объединение множеств
        Set<Integer> union =new HashSet<>(set1);//В классе HashSet есть перегруженный
        //конструктор который принимает на вход сущ. множество и строит новое множество
        // с теми же элементами, union-объединение
        union.addAll(set2);//объединили множества (без дублирования элементов)
        System.out.println(union);


        //intersection-пересечение множеств
        Set<Integer> intersection =new HashSet<>(set1);
        intersection.retainAll(set2);//в пересечение попадают только те элементы которые содержатся
        //в обоих множествах
        System.out.println(intersection);


        //difference-разность множеств
        Set<Integer> difference =new HashSet<>(set1);
        difference.removeAll(set2);//из множества set1 удалятся все элементы множества set2 (которые
        //попадают в пересечение)
        System.out.println(difference);
    }
}
