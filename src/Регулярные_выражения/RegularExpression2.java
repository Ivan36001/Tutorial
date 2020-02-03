package Регулярные_выражения;

import java.util.Arrays;

//полезные методы использующие регулярные выражения
public class RegularExpression2 {
    public static void main(String[] args) {
        String a="Hello54273487hello74568973hello";
        String[] words=a.split("\\d+");
        System.out.println(Arrays.toString(words));

        String d="Hello29353593453hello583985hello";
        String fg=d.replaceAll("\\d+"," ");
        System.out.println(fg);


        String s="Hello29343535233593453hello583985hello";
        String gf=s.replaceFirst("\\d+","-");
        System.out.println(gf);

    }
}
