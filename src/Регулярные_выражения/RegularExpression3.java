package Регулярные_выражения;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression3 {
    public static void main(String[] args) {
        String text="shdfksfhj dsfjs jdshfjshd kdsksld joe@gmail.com dksklj jsdfks" +
                "kfdsjflkjljdfkjf djfkjsj tim@yandex.ru djsfkljjf ksjfklsdj";

        Pattern email=Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");//так как в классе Pattern приватный конструктор
        //мы не можем создавать объект этого класса при помощи new, для создания объекта этого класса мы должны исполь-
        //использовать статический метод этого класса compile() который возвращает объект этого класса. Данный паттерн
        //создания объектов наз. Factory Method

        Matcher matcher=email.matcher(text);//получаем объект класса Matcher при вызове метода matcher() на объекте
        //класса Pattern. В качестве аргумента методу передаем наш текст.

        while (matcher.find()){//этот метод ищет соответствие в тексте нашему паттерну и возвращает true когда его
            // находит (цикл сработает два раза)
            System.out.println(matcher.group());//метод возвращает то что было найдено методом find()

            System.out.println(matcher.group(1));}//выводи на печать группу 1

        //Метод group()  в качестве аргумента может принимать также номер группы. Группа-это выражение находящееся в
        // скобках-() нашего регулярного выражения. Добустим нам надо получить только имена из найденных адресов. Для этого
        //создадаим группу 1 поставив в скобки ту часть регулярного выражения которое отвечает за имя. И поставим в качестве
        //аргумента методу group() номер группы 1


    }
}
