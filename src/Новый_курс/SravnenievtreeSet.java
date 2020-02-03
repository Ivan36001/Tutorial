package Новый_курс;

import java.util.*;

public class SravnenievtreeSet {
    public static void main(String[] args) {
        List<Persons> peopleList=new ArrayList<>();
        Set<Persons> peopleSet=new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        System.out.println(peopleList);
        System.out.println(peopleSet);


    }
    private static void addElements (Collection collection){//можем так делать так как Set и List реализуют интерфейс
        //Collection (полиморфизм)
        collection.add(new Persons (3, "Bob"));//создаем новые объекты согласно конструктора и добавляем в колекцию
        collection.add(new Persons (10, "Tom"));
        collection.add(new Persons (4, "Kakatiya"));
        collection.add(new Persons (7, "George"));

    }
}
 class Persons implements Comparable<Persons> {//реализуем интерфейс Comparable (и ниже его метод compareTo()) для того
    //чтобы наш TreeSet знал в каком порядке добавлять элементы
    private int id;
    private String name;

    public Persons(int id, String name) {
        this.id = id;
        this.name = name;
    }

     @Override
     public String toString() {//переопределим метод для того чтобы выводить человеков на экран
         return "Persons{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 '}';
     }

     public int getId() {
         return id;
     }

     @Override
     public boolean equals(Object o) {//2-я проверка на равенство объектов
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Persons persons = (Persons) o;
         if (id !=persons.id) return false;
         return name !=null ? name.equals(persons.name): persons.name==null;
     }

     @Override
     public int hashCode() {//1-ая проверка на равенство объектов
         int result=id;
         result =31 * result + (name !=null ? name.hashCode():0);
         return result;
     }

     @Override
     public int compareTo(Persons o) {//задаем порядок сортировки
         if(this.id>o.getId()){//сравниваем текущий объект с каким-то другим
             return 1;
         }else if(this.id<o.getId()){//сравниваем текущий объект с каким-то другим
             return -1;
         } else {
             return 0;
         }
     }
 }