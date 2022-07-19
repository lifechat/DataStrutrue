package arrayStructure;

public class VarableParamter
{
    public static void main(String[] args) {
        System.out.println(add(1,3,4,5));
        System.out.println(add(1,2,3,4,5,6));

        Integer num2 = 12;
        Integer num4 = 12;
        System.out.println(num2 == num4);

        Integer num3 = 129;
        Integer num1 = 129;
        System.out.println(num3 == num1);

        Integer num5 = Integer.valueOf(129);
        Integer num6 = Integer.valueOf(129);
        System.out.println(num5 == num6);
    }


    public static int add(int x,int ...args){
        int sum = 0;
        for (int arg:args) {
            sum += arg;
        }
        return  sum;
    }
}
