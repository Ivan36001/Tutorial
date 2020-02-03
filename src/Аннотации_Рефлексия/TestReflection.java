package Аннотации_Рефлексия;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();//создаем объект класса Person для последующего вызова на нем метода getClass()
        // который возвращает объект класса CLass
        Class personClass = Person.class;//первый способ получить объект класса Class
        Class personClass2 = person.getClass();//2-ой способ
        Class personClass3 = Class.forName("Аннотации_Рефлексия.Person");//3-ий способ
      //Суть рефлексии: работаем с классом как с обычным объектом т.е используем для него различные методы:
        Method[] methods = personClass.getMethods();//Method-это класс который мы импортируем. Получаем все методы объекта
        //класса Class т.е класса Person и даже методы класса Object
        for (Method method : methods) {
            System.out.println(method.getName() + "," + method.getAnnotatedReturnType() + "," + Arrays.toString(method.getParameterTypes()));
//выводим на экран для каждого метода его имя, тип возвращаемого значения и типы параметров которые на вход принимает метод
            Field[] fields=personClass.getFields();//Field-класс. Получаем все поля класса Person
            for(Field field: fields){
                System.out.println(field.getName()+","+field.getType());//не выведится ничего т.к поля приватные
            }
            Field[] fields1=personClass.getDeclaredFields();//Field-класс. Получаем все поля класса Person
            for(Field field: fields1){
                System.out.println(field.getName()+","+field.getType());//вывидутся поля т.к используем getDeclaredFields()
            }

            Annotation[]annotations=personClass.getAnnotations();
            for(Annotation annotation: annotations){
                if (annotation instanceof Autor){//если у класса есть аннотация Author выводим Yes
                    System.out.println("Yes");
                }
            }

        }
    }
}//многие фрейморки при помощи рефлексии работают с классами как с обычними объектами и получают доступ к полям и методам