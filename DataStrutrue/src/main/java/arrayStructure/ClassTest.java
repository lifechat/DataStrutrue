package arrayStructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        String str1 = "abc";
        Class cls1 = str1.getClass();
        Class cls2 = String.class;
        Class cls3= Class.forName("java.lang.String");
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);

        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);

        Constructor constructor = Class.forName("java.lang.String").getConstructor();
        System.out.println(constructor);

        ReflectPoint pt1 = new ReflectPoint(3,5);
        Field fieldy = pt1.getClass().getField("y");
        System.out.println(fieldy.get(pt1));
        Field fieldx = pt1.getClass().getDeclaredField("x");
        fieldx.setAccessible(true);
        System.out.println(fieldx.get(pt1));

        changeFileds(pt1);
        System.out.println(pt1);
    }

    private static void changeFileds(Object obj1) throws IllegalAccessException {
        Field[] fields = obj1.getClass().getFields();
        for(Field field:fields){
            if(field.getType() == String.class){
                String oldValue = (String) field.get(obj1);
                String newValue = oldValue.replace('b','a');
                field.set(obj1,newValue);
            }
        }
    }
}
