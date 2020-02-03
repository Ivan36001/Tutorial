package Аннотации_Рефлексия;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scanner=new Scanner(System.in);
        Class classObject1=Class.forName(scanner.next());//получаем первую строку (название класса 1) и создаем объект
        //класса Class
        Class classObject2=Class.forName(scanner.next());//получаем вторую строку после разделителя (пробел) и создаем
        //объект класса класс
       String methodName=scanner.next();

        Method m=classObject1.getMethod(methodName,classObject2);//для объекта класса Class вызываем метод methodName
        //в качестве аргументов у которого classObject2-получили объект класса Method
        Object o1=classObject1.newInstance();//создаем объект первого класса
        Object o2=classObject2.getConstructor(String.class).newInstance("Наш новый поток");//создаем объект второго
        //класса и в качестве аргументов конструктору передаем строку "Наша строка"
        m.invoke(o1,o2);//вызываем наш метод на объекте o1 с аргументом о2
        System.out.println(o1);
    }
}//запускаем, затем в консоли пишем java.lang.Thread java.lang.String setName
//Т.о создается объект класса Thread, объект класса String (строка), вызывается метод setName() которому в качестве аргумента
//поставляем объект класса String (нашу строку)
