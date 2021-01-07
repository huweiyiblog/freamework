package cn.com.servyou.freamework.jdk8.Function;

import java.util.function.Function;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/24 14:55
 * <p>作者: huwy
 */
public class FunctionTest {

    /**
     *
     * Java8内置的四大函数接口。
     *
     */

    public static void main(String[] args) {

        /**
         * Consumer<T> : 消费型接口：有入参，无返回值
         *
         *  void accept(T t);
         */

        consumerTest();


        /**
         *
         * Supplier<T> : 供给型接口：无入参，有返回值
         *
         *  T get();
         *
         */

        supplierTest();

        /**
         *
         * Function<T, R> : 函数型接口：有入参，有返回值
         *
         * R apply(T t);
         *
         */

        funTest();

        /**
         *
         * Predicate<T> : 断言型接口：有入参，有返回值，返回值类型确定是boolean
         *
         * boolean test(T t);
         *
         */

        PredicateTest();

    }

    private static void PredicateTest() {


    }

    private static void funTest() {

        System.out.println("===============Function<T, R> : 函数型接口：有入参，有返回值==============");
        Function<Integer, Integer> func = p -> p * 100;
        System.out.println(func.apply(100)); // 100


    }

    private static void supplierTest() {


    }

    private static void consumerTest() {
        System.out.println("===============Function<T, R> : 函数型接口：有入参，有返回值==============");
        /**
         * 用途：因为没有出餐，常用于打印，发送短信等消费动作
         */



    }

    public static  void testOperator(){

        OperFunction<Integer, Integer, String> operFunction = (i, str) -> i + Integer.parseInt(str);

        System.out.println(operFunction.operator(1, "123"));

        //加
        System.out.println("加：" + operator(1, 2, (x, y) ->  x+y));

        //减
        System.out.println("减：" + operator(3, 2, (x, y) -> x-y));

        //乘
        System.out.println("乘：" + operator(3,2,(x, y) -> x*y));

        //除
        System.out.println("除：" + operator(6, 2, (x, y) -> x/y));

    }


    public static Integer operator(Integer a, Integer b,
                                   OperFunction<Integer, Integer, Integer> of) {
        return of.operator(a, b);
    }




    @FunctionalInterface
    public interface OperFunction<R, K, V> {
        R operator(K k, V v);
    }
}
