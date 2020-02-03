package Лямбда_выражения;

interface Executable1 {
    int execute1();
}
class Runner1 {
    public void run1 (Executable1 e) {//в качестве аргументов принимает объект клсасса реализующий интерфейс Executable
       int a=e.execute1();
        System.out.println(a);
    }
}
//Сравнение создания анонимного клсасса и использования лямбда-выражения
public class lyambda2 {
    public static void main(String[] args) {
        Runner1 runner1=new Runner1();

        runner1.run1(new Executable1() {//создали анонимный класс
            @Override
            public int execute1() {//переопределили метод
                return 1;
            }
        });
        runner1.run1(()->5);//можно писать так.Так как лямбда выражение знает сигнатуру метода корого она реализует
        //(int execute1())

    }
}
