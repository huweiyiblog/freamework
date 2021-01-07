package cn.com.servyou.freamework.jdk8.Default;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/8 16:54
 * <p>作者: huwy
 */
public class DefalutTest {

    /**
     * 描述：jdk8之前，接口里面只能有抽象方法，不能有任何方法实现的。
     * jdk8里面打破了这个规定，引入了新的关键字default,使用default修饰方法，可以在接口里面定义具体的方法实现。接口里面可以定义两种方法实现。默认方法和静态方法。
     * 也就是接口中可以包含方法体，这打破了Java之前版本对接口的语法限制，从而使得接口在进行扩展的时候，不会破坏与接口相关的实现类代码。
     *
     * 作用：往现存接口中添加新的方法，即不强制那些实现了该接口的类也同时实现这个新加的方法。
     */
    public class DefalutServiceImpl implements DefalutService {

        @Override
        public void run() {
        }

        @Override
        public void eat() {
        }
    }

    public class DefalutServiceImpl2 implements DefalutService {

        @Override
        public void run() {
        }

        @Override
        public void eat() {
        }

        @Override
        public void breath() {
            System.out.println("11111");
        }
    }

    public interface DefalutService {

        void run();

        void eat();

        default void breath() {
            System.out.println("这是defalut 方法");
        }
    }


    public static void main(String[] args) {
     DefalutTest defalutTest = new DefalutTest();
     defalutTest.defaultTest();
    }

    public void defaultTest() {
        DefalutService defalutService = new DefalutServiceImpl2();
        defalutService.breath();
    }

}
