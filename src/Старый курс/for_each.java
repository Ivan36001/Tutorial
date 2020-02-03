public class for_each {
    public static void main(String[] args) {
        String[] words=new String[3];
        words[0]="Привет";
        words[1]="Пока";
        words[2]="java";
        for(String g: words){//g-переменная принемающая значение того что лежит в ячейке массива
            System.out.println(g);
        }


    }
}
class For_each_numbers{
    public static void main(String[] args) {
        int[]n={5,4,10};
        int sum=0;
        for(int p: n){//p=5,p=4,p=9
          sum=sum+p;
            System.out.println(sum);
        }

    }
}
