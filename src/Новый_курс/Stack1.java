package Новый_курс;

import java.util.Stack;
//Stack-аналогия со стопкой блинов: последний блин кладем и его же и едим
public class Stack1 {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(5);//добавляем первый элемент
        stack.push(3);
        stack.push(1);// добавляем последний элемент первый на вывод

        System.out.println(stack.peek());//выводим последний элемент стэка без удаления
        System.out.println(stack.pop());//удаляем последний элемент стэка и выводи на печать
        while (!stack.empty()) {//пока стэк не пустой выводим поледовательно удаляемые элементы
            System.out.println(stack.pop());
        }

    }
}
