package cn.com.servyou.freamework.jdk8.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/10 16:42
 * <p>作者: huwy
 */
public class LambdaTest {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        map.forEach((k,v) -> {
            System.out.println("k="+k+", v="+v);
        });


        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.method();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (int a) ->{
            System.out.println("noReturnOneParam param:" + a);
        };
        noReturnOneParam.method(6);

        //多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a, int b ) ->{
            System.out.println("NoReturnMultiParam param:{" + a + "," + b + "}");
        };
        noReturnMultiParam.method(6, 8);

        //无参有返回值
        ReturnNoParam returnNoParam = () ->{
            System.out.println("ReturnNoParam");
            return 1;
        };


        //一个参数有返回值
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("ReturnOneParam param:" + a);
            return 1;
        };

        int res2 = returnOneParam.method(6);
        System.out.println("return:" + res2);








    }

    /**无参无返回值*/
    @FunctionalInterface
    public interface NoReturnNoParam {
        void method();
    }

    /**一个参数无返回*/
    @FunctionalInterface
    public interface NoReturnOneParam {
        void method(int a);
    }

    /**多参数无返回*/
    @FunctionalInterface
    public interface NoReturnMultiParam {
        void method(int a, int b);
    }

    /*** 无参有返回*/
    @FunctionalInterface
    public interface ReturnNoParam {
        int method();
    }

    /**一个参数有返回值*/
    @FunctionalInterface
    public interface ReturnOneParam {
        int method(int a);
    }

    /**多个参数有返回值*/
    @FunctionalInterface
    public interface ReturnMultiParam {
        int method(int a, int b);
    }




}
