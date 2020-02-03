package Новый_курс;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// ИНТЕРФЕЙС Comparator
public class InerfacComparator {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(8);
        numbers.add(3);
        numbers.add(11);
        numbers.add(4);
        numbers.add(3);
        Collections.sort(numbers);//метод является статическим и одним из множества полезных методов
        //класса Collections он сортирует по естественному порядку (заранее определенному для классов
        //Integer и String)
        System.out.println(numbers);


        List<String> animals = new ArrayList<>();
        animals.add("dfg");
        animals.add("df");
        animals.add("dfgt");
        animals.add("dfger");
        animals.add("dfgerert");
        animals.add("dfgert");
        Collections.sort(animals, new StringLengthComparator());//вариация метода sort() котрая принимает на вход второй аргумент:
        //объект класса StringLengthComparator который реализует интерфейс Comparator
        System.out.println(animals);//теперь сортировка будет такой как мы задали в методе compare()


        List<Integer> numberss = new ArrayList<>();
        numberss.add(5);
        numberss.add(8);
        numberss.add(3);
        numberss.add(11);
       numberss.add(3);
        Collections.sort(numberss, new BackwardsIntegerComparator());
        System.out.println(numberss);

    }
}

class StringLengthComparator implements Comparator<String> {//реализуем параметризованный интерфейс Comparator

    @Override//ПКМ Generate->Implement Methods->compare()
    public int compare(String o1, String o2) {//в этом методе есть своя конвенция: он возвращает целое число
        if (o1.length() > o2.length()) {//и по нему java понимает какой объект меньше, а какой  больше:
                return 1;                                  //o1 < o2 ---> 1; o1 > o2 ---> -1; o1=o2 ---> 0

        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }

    }
}
class BackwardsIntegerComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        } else {
            return 0;
        }
    }

}
