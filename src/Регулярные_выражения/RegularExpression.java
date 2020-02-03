package Регулярные_выражения;

public class RegularExpression {
    public static void main(String[] args) {
    String a="5";
        System.out.println(a.matches("\\d"));//одна цифра

     String b="43";
        System.out.println(b.matches("\\d+"));//одна или более цифр

    String c="";
        System.out.println(c.matches("\\d*"));//ноль или более цифр

     String d="-345";
        System.out.println(d.matches("-?\\d*"));//ноль или один символ - до


        String e="-346";
        System.out.println(e.matches("(-|\\+)\\d*"));//плюс или минус (исключающее или) до любого числа от нуля
        //когда используем специальный символ + ,чтобы указатать что это обычный + пишем \\+ (с \\d верно обратное-
        //переводим обычный символ в специальный


       String f="g356";
        System.out.println(f.matches("[a-zA-Z]\\d+"));//все английские буквы до цифры от 1 до бесконечности
        //[0-9]<=>\\d; [abcdf]<=>(a|b|c|d|f)

        String g="ggfhshsgs356";
        System.out.println(g.matches("[a-zA-Z]+\\d+"));//до цифры любое количество английских букв

        String h="13333ggfh3333shs1111gs356";
        System.out.println(h.matches("[a-zA-Z13]+\\d+"));


        String z="Hello";
        System.out.println(h.matches("[^abcd]*"));//любое множество букв не содержащих abcd


        String url="http://www.google.com";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));//  .-это любой символ, \\.-обычная точка

        String m="56";
        System.out.println(m.matches("\\d{2}"));//2 символа до

        String x="564536";
        System.out.println(x.matches("\\d{2,}"));//от 2-ух и более символов до


        String n="5645";
        System.out.println(n.matches("\\d{2,4}"));//от 2-ух до 4-ех символов до

    }

}
