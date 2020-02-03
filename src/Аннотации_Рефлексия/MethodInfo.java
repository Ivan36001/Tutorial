package Аннотации_Рефлексия;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//ограничиваем использование аннотации только методом, можно перечеслять несколько типов где
//мы можем использовать аннотацию :@Target({ElementType.METHOD,ElementType.TYPE}) с помощью фигурных скобок
@Retention(RetentionPolicy.RUNTIME)//аннотация будет видна в ходе выполнения программы
public @interface MethodInfo {//создаем свою аннотацию
    String author() default "Ivan";//использование значения по умолчанию
    int dateOfCreation();//в аннотациях поля записываются со скобками как методы
    String purpose();

}
