package cn.com.servyou.freamework.annotation;

import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/30 9:50
 * <p>作者: huwy
 */
public class AnnotationTest {

    public static void main(String[] args) {
        AnnotationTest test = new AnnotationTest();

    }



    @Data
    public class UserInfo {

        @DbColumn(fieldName = "id")
        private Integer id;

        @DbColumn(fieldName = "name")
        private String name;

        @DbColumn(fieldName = "addr")
        private String addr;

        @DbColumn(fieldName = "email")
        private String email;

    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DbColumn {

        String fieldName() default "";
    }
}
