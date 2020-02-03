package Новый_курс;

import java.util.Arrays;



// Двусвязный список похож на обычный связный список, только
// элементы в нем хранят ссылки не только на следующий, но и на предыдущий элемент.
// Благодаря этому свойству, можно перемещаться по списку вперед и назад.
//В зависимости от места расположения узла мы можем к нему двигатся как от
//последнего так и от первого узла (как будет быстрее)
// создадим односвязный не параметризованный (Параметризация позволяет создавать
// классы, интерфейсы и методы, в которых тип обрабатываемых данных задается как параметр) LinkedList
public class Linked_list3 {
    private Node head;// объявляем переменную класса Node по умолчанию ссылается на  "null"
    // потом всегда на первый узел
    private int size;//размер нашего связного списка (по умолчанию имеет значение "0")

    public void add(int value) {//метод описывающый логику добавления нового элемента
        if (head == null) {//если это первое добавление
            this.head = new Node(value);//сослали переменную класса Node на новый объект этого класса
            // создали головной узел и присвоили значение которое было подано
        } else {//если добавление не первое
            Node temp = head;//еще одна ссылочная переменная ссылается на head (первый узел)
            while (temp.getNext() != null) {//есть ли следующий элемент в списке?если да товыполняем тело
                //после того как дойдем до конца списка temp.getNext()==null и цикл прекращается и переменная
                //temp указывает на последний узел списка
                temp = temp.getNext();//присваиваем переменной temp значение следующего узла(в то время как head
                //всегда ссылается на первый узел
            }
            temp.setNext(new Node(value));//устанавливаем новый узел после последнего со значением value


        }
        size++;//инкрементируем переменную
    }
    public int get (int index){//метод для получения элементов linkedList
        int currentIndex=0;
        Node temp=head;
        while (temp!=null){
            if (currentIndex==index){
                return temp.getValue();
            }else{
                temp=temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }


    public void remove(int index) {//метод удаляющый элемент из linkedList
        if(index==0){//для случая удаления нулевого элемента
            head=head.getNext();
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if ((currentIndex + 1) == index) {//если мы находимся в предыдущем узле от требуемого
                temp.setNext(temp.getNext().getNext());//меняем ссылку на элемент через один в право
                //таким образом ссылка на след. элемент исчезает и элемент исчезает
                size--;//уменьшаем размер linkedList
                return;//выходим из цикла
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }



    public String toString() {//переопределяем метод toString для вывода массива
        int[] result = new int[size];//создали целочисленный массив размером size(равный размеру списка)
        int index = 0;
        Node temp = head;
        while (temp != null) {//в цикле проходимся по всем элементам списка
            result[index++] = temp.getValue();//добавляем в массив значение текущего узла
            temp = temp.getNext();

        }
        return Arrays.toString(result);//возвращаем строчное представление массива

    }
    class Node {
        private int value;//значение которое хранится в текущем узле
        private Node next;//ссылка на следующий узел

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Linked_list3 g = new Linked_list3();
        g.add(2);
        g.add(5);
        g.add(10);
        g.add(101);
        g.add(3);
        System.out.println(g);
        System.out.println(g.get(1));
        System.out.println(g.get(1));
        System.out.println(g.get(3));//если подставить значение индекса больше или равного size то
        //выполнение программы прекратится на месте данного исключения
        g.remove(0);
        System.out.println(g);


    }
}