package Лямбда_выражения;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lyambda4 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Ytllo");
        list.add("Ytl");
        list.add("Ytllo446");
        list.add("Ytllogdsgsgs");
        list.add("Ytllos");


        list.sort(new Comparator<String>() {//раньше
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });





        list.sort((s1,s2) -> {//с использованием лямбда-выражений. Можно так же записать Comparator<String> comparator=(s1,s2) ->...
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            } else {
                return 0;
            }
        });

        System.out.println(list);
    }
}




