package Новый_курс;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
//MAP-ОТОБРАЖЕНИЯ
public class LinkedHashMapAndTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> hashMap=new HashMap<>();//внутри не гарантируется никакого порядка
        Map<Integer,String> linkedHashMap=new LinkedHashMap<>();//в каком порядке пары добавлены в таком
        //в таком они и вернутся
        Map<Integer,String> treeMap=new TreeMap<>();//пары сортируются по ключу natural order (по
        //естественному порядку) для чисел это от меньшего к большему, для строк-лексикографический порядок
        //т.е. аа<аб
        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);

    }
    public static void testMap(Map<Integer,String> map){//т.к. все три класса реализуют интерфейс Map
        //мы можем подставлять их на вход метода в качестве аргумента
        map.put(3, "Petr");
        map.put(10, "Bob");
        map.put(5, "Jack");
        map.put(11, "Denials");
        map.put(2, "Petr");//дублирование значения допускается
        for(Map.Entry<Integer,String> g : map.entrySet()){
            System.out.println(g.getKey()+":"+g.getValue());
                    }
        System.out.println();
    }
}
