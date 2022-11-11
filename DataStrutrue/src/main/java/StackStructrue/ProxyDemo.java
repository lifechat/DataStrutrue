package StackStructrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
/***
 * 创建动态类及查看其方法列表信息
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
         System.out.println(clazzProxy1.getName());
        System.out.println("--------begin constructor list--------------");
        Constructor[] constructors = clazzProxy1.getConstructors();
        for(Constructor constructor : constructors ){
            String name = constructor.getName();
            StringBuilder sBuilder = new StringBuilder(name);
            sBuilder.append('(');
            Class[] clazzParams = constructor.getParameterTypes();
            for (Class clazzParam : clazzParams){
                sBuilder.append(clazzParam.getName()).append(')');
            }
            if(clazzParams != null && clazzParams.length != 0){
                    sBuilder.deleteCharAt(sBuilder.length()-1);
            }
            sBuilder.append('(');
            sBuilder.deleteCharAt(sBuilder.length()-1);
            System.out.println(sBuilder.toString());
        }
        System.out.println("--------begin methods list--------------");
        Method[] methods = clazzProxy1.getMethods();
        for(Method method : methods){
            String name = method.getName();
            StringBuilder sBuilder = new StringBuilder(name);
            sBuilder.append('(');
            Class[] clazzParams = method.getParameterTypes();
            for(Class clazzParam : clazzParams){
                sBuilder.append(clazzParam.getName()).append(',');
            }
            if(clazzParams != null && clazzParams.length   != 0 )
                sBuilder.deleteCharAt(sBuilder.length()-1);
            sBuilder.append(")");
            System.out.println(sBuilder.toString());
        }
    }
}
