package cn.com.servyou.freamework.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/30 9:29
 * <p>作者: huwy
 */
public class AnnotationUtils {

    public static List<Field> getAnnotationFieldsInClass(Class<? extends Annotation> annotation, Class<?> targetClass) {

        List<Field> annotationFieldList = new ArrayList<Field>();

        findAnnotationField(annotationFieldList, annotation, targetClass);

        return annotationFieldList;
    }

    public static void findAnnotationField(List<Field> resultList, Class<? extends Annotation> annotation, Class<?> targetClass){

        //获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段
        Field [] fields = targetClass.getDeclaredFields();

        for (int n = 0; n < fields.length; n++) {
               Field field = fields[n];
               //annotation 是否是在field上，如果在就返回true
            if (field.isAnnotationPresent(annotation)) {
                resultList.add(fields[n]);
            }

        }

    };


}
