package Лямбда_выражения;



interface Executable3 {
    int execute3(int x);
}
class Runner3 {
    public void run3 (Executable3 e) {
        int a=e.execute3(10);
        System.out.println(a);
    }
}

public class lyambda3 {
    public static void main(String[] args) {
        Runner3 runner3=new Runner3();

        runner3.run3(new Executable3() {
            @Override
            public int execute3(int x) {
                return x+5;
            }
        });
        runner3.run3((int x)->x+5);
       //  runner3.run3((x)->x+5);
        // runner3.run3(x->x+5);т.е можем даже не писать круглые скобки когда у нас один аргумент

    }
}//в лямбда выражениях мы можем реализовать только один метод в отличие от анонимных классов (т.к. в лямбда выражениях
//метод не имееет названия и мы не будем знать какой метод интерфейса реализуем)
//Лямбда выражения могут использовать только переменные final или не изменяемые в ходе выполнения программы.
//в лямбда-выражениях нельзя повторять название уже созданной переменной в отличие от методов в анонимных классах (т.к.
//у этих методов есть своя область видимости)
