package Лямбда_выражения;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//ПОЛЕЗНЫЕ МЕТОДЫ ДЛЯ КОЛЛЕЕКЦИЙ И МАССИВОВ
public class lyambda6 {
    public static void main(String[] args) {
        int[]arr1=new int[10];
        List<Integer> list1=new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        //метод map()
        arr1=Arrays.stream(arr1).map(a->3).toArray();
        list1=list1.stream().map(a->a*2).collect(Collectors.toList());


        System.out.println(Arrays.toString(arr1));
        System.out.println(list1);

        arr1=Arrays.stream(arr1).map(a->a+1).toArray();
        System.out.println(Arrays.toString(arr1));

        //метод filter()
        int[]arr2=new int[10];
        List<Integer> list2=new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2=Arrays.stream(arr2).filter(a->a%2==0).toArray();//оставляем только четные числа в нашем новом массиве
        list2=list2.stream().filter(a->a%2==0).collect(Collectors.toList());//оставляем только четные числа в нашем новом листе

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        //метод forEach()
        Arrays.stream(arr2).forEach(a-> System.out.println(a));//проходимся по каждому элементу и выводим его на печать
        list2.stream().forEach(a-> System.out.println(a));//проходимся по каждому элементу и выводим его на печать


        //метод reduce() (пер. уменьшение)-из всех элементов коллекции или массива получаем один (по заданной логике)
        //это может быть сумма, произведение всех элементов или др.
        int[]arr3=new int[10];
        List<Integer> list3=new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        int summa=Arrays.stream(arr3).reduce((acc,b)->acc+b).getAsInt();//b-текущий элемент,acc-аккумулятор (накапливает сумму)
        //метод getAsInt() переводит поток в число
        int proizvedenie=list3.stream().reduce((acc,b)->acc*b).get();

        System.out.println(summa);
        System.out.println(proizvedenie);

    }
    private static void fillList (List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }
    private static void fillArr(int[]arr){
        for (int i = 0; i <10 ; i++) {
            arr[i]=i+1;
        }
    }

}//Вышеприведенные методы могут следовать друг за другом через точку после создания потока на нашей коллекции или массиве
// с последующим преобразованием обратно



