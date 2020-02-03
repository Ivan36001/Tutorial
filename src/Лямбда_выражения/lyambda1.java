package Лямбда_выражения;
//Лямбда выражения-это способ передать кусок кода в метод или в качестве аргументов в конструктор. Позволяют обойтись
// без использования анонимных классов. Это метод без названия(анонимная функция).


interface Executable {
    void execute();
}
class Runner {
    public void run (Executable g) {//в качестве аргументов принимает объект клсасса реализующий интерфейс Executable
   g.execute();
    }
}
class ExecutableImplementation implements Executable{//первый способ передать реализацию интерфейса Executable в качестве
    //аргументов методу run()

    @Override
    public void execute() {
        System.out.println("Hello");

    }
}

public class lyambda1 {
    public static void main(String[] args) {
        Runner runner=new Runner();
        runner.run(new ExecutableImplementation());//первый способ передать аргумент

        runner.run(new Executable() {// второй способ-анонимный класс реализующий интерфейс Executable
            @Override
            public void execute() {
                System.out.println("Hello");

            }
        });
        runner.run(()-> System.out.println("Hello"));//третий способ-просто передаем метод без названия (который реализует
        // метод  execute)-лямбда выражение

    }
}
