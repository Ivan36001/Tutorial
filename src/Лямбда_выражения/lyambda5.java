package Лямбда_выражения;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lyambda5 {
    public static void main(String[] args) {
        int[]arr=new int[10];
        List<Integer> list=new ArrayList<>();


        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

       // for (int i = 0; i <10 ; i++) {//без использованилямбда-выражений
       //   arr[i]=arr[i]*2;
       //   list.set(i, list.get(i)*2);//при помощи get() получаем элемент, умножаем на 2 и помещаем в list
       //        }


        //с использованием лямбда-выражений:
       arr=Arrays.stream(arr).map(a->a*2).toArray();//метод stream() преобразует arr в поток (не тот что в многопоточности) и на этом потоке
        //уже можно вызывать метод map() который делает отображение логика которого написана в скобках() при этом получается
        //уже новый поток, который при помощи метода toArray() преобразуем обратно в массив
        list=list.stream().map(a->a*2).collect(Collectors.toList());


        System.out.println(list);
        System.out.println(Arrays.toString(arr));
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

}
