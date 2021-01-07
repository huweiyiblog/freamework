package cn.com.servyou.freamework.jdk8.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2020/12/10 16:39
 * <p>作者: huwy
 */
public class SteamTest {

    public static void main(String[] args) {


       /*

        streamGenerate();

        streamConvert();

        streamWithMap();



        */

        filter();


    }

    //stream流的map使用
    public static  void streamWithMap() {

        //转换大写
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu");
        System.out.println("转换之前的数据：" + list);
        List<String> list2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("转换之后的数据：" + list2);

        //转换数据类型
        list = Arrays.asList("1", "2", "3");
        List<Integer> list3 = list.stream().map(Integer::valueOf).collect(Collectors.toList());;
        System.out.println(list3);

        //获取平方
        List<Integer> list4 = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        List<Integer> list5 = list4.stream().map(n -> n*n).collect(Collectors.toList());
        System.out.println("平方的数据：" + list5);

    }

    //stream流的之间的转换
    public static void streamConvert() {
        Stream<String> stream = Stream.of("a", "b", "c");

        //转换成array
       String [] strArray = stream.toArray(String[]::new);

       System.out.println("stream to array:" + strArray);

        //转换成collection
        stream = Stream.of("a1", "b1", "c1");
        List<String> list1 = stream.collect(Collectors.toList());
        list1.forEach(k -> {
            System.out.println(k);
        });

        stream = Stream.of("1", "2", "3");
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        list2.forEach(k -> {
            System.out.println("k:" + k);
        });

        stream = Stream.of("1", "2", "1");
        Set set = stream.collect(Collectors.toSet());
        set.forEach(k -> {
            System.out.println("set :" + k);
        });
       // Set set1 = stream.collect(Collectors.toCollection(HashSet::new));

        //转换成 String
        stream = Stream.of("a", "b", "c");

        String str = stream.collect(Collectors.joining());
        System.out.println(str);

    }


    public static  void filter(){

        List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");
        System.out.println("过滤之前:" + list);
       List<String> result = list.stream().filter(str->!"李四".equals(str)).collect(Collectors.toList());
        System.out.println("过滤之后：" + result);
         /***********************************************/

        //通过与findAny得到 if/else的值
        String result1 = list.stream().filter(str->"李四".equals(str)).findAny().orElse("找不到李四");
        System.out.println(result1); //李四

        String result2 = list.stream().filter(str ->"王麻子".equals(str)).findAny().orElse("找不到王麻子");
        System.out.println(result2);//找不到王麻子

        /***********************************************/
        //返回boolean 值
        String name = "李四";
        boolean hasTrue = list.stream().filter(str->"李四".equals(str)).allMatch(str -> name.equals(str));
        System.out.println(hasTrue); //true

        /***********************************************/
        //通过与mapToInt计算和
        List<User> lists = new ArrayList<>();
        lists.add(new User(6, "张三"));
        lists.add(new User(2, "李四"));
        lists.add(new User(3, "王五"));
        lists.add(new User(1, "张三"));
        //计算这个list种出现"张三"id的值
        int sum = lists.stream().filter(u -> "张三".equals(u.getName())).mapToInt(u->u.getId()).sum();
        System.out.println("sum:" + sum);

        /***********************************************/
        //latMap 方法用于映射每个元素到对应的结果，一对多。
        String worlds = "The way of the   future";
        List<String> list2 = new ArrayList<>();
        list2.add(worlds);

        List<String> list3 = list2.stream().flatMap(str ->Stream.of(str.split(" ")))
                .filter(world -> world.length() > 0).collect(Collectors.toList());

        list2.stream().flatMap(str->Stream.of(str.split(" ")))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        /**
         * stream流的limit使用， limit方法用于获取指定数量的流
         */

        //获取钱N条数的数据
        Random rd = new Random();
        System.out.println("取到的前三条数据：");
        rd.ints().limit(3).forEach(System.out::println);

        //skip表示的是扔掉前n个元素
        List<User> list4 = new ArrayList<>();
        list4.add(new User(1, "zs"));
        list4.add(new User(2, "ls"));
        list4.add(new User(3, "ww"));
        list4.add(new User(4, "mz"));
        list4.stream().limit(3)
                .skip(2)
                .forEach(u->{System.out.println(u.getName());}); //ww


        /**
         * stream 流的sort使用
         */

        List<User> list5 = new ArrayList<>();
        list5.add(new User(3, "zs"));
        list5.add(new User(2, "ls"));
        list5.add(new User(1, "ww"));
        list5.add(new User(4, "mz"));
        System.out.println("排序前的数据：");
        list5.forEach(rs->System.out.println(rs.getName()));

        System.out.println("排序后的数据:");
        List<User> list6 = list5.stream()
                .sorted((u1, u2) -> u1.getId().compareTo(u2.getId()))
                .collect(Collectors.toList());
        list6.forEach(u->System.out.println(u.getName()));

        /**
         * stream 流的peek使用
         */

        //peek对每个元素执行操作并返回一个新的Stream
        Stream.of("one", "two", "three").peek(u-> System.out.println(u));

        /**
         * Stream流的parallel使用
         * parallelStream 是流并行处理程序的代替方法。
         */

        List<String> strings = Arrays.asList("a", "", "c", "", "e","", " ");
        //获取空字符串的数据
        long count = strings.parallelStream()
                .filter(string -> string.isEmpty())
                .count();
        System.out.println("long:" + count); // 3


        /**
         * stream 流的max/min/distinct使用
         */
        List<String> list13 = Arrays.asList("zhangsan","lisi","wangwu","xuwujing");

        int maxLines = list13.stream().mapToInt(String::length)
                .max().getAsInt();
        int minLines = list13.stream().mapToInt(String::length)
                .min().getAsInt();
        System.out.println("最长字符串的长度：" + maxLines
                + ", 最短字符串的长度："+ minLines); // 8 , 4




        /**
         * 得到去重之后的数据
         */

        //得到去重后的数据,并且根据长度倒序排列
        String lines = "good,good,study,day,day,up";

        List<String> list14 = new ArrayList<>();
        list14.add(lines);

        List<String> words = list14.stream().flatMap(str -> Stream.of(str.split(",")))
                .distinct().sorted((u1, u2) -> u2.length() - u1.length()).collect(Collectors.toList());

        words.forEach(System.out::println);


        /**
         *
         * stream 流的match使用
         *
         * allMatch：Stream 中全部元素符合则返回 true ;
         *
         * anyMatch：Stream 中只要有一个元素符合则返回 true;
         *
         * noneMatch：Stream 中没有一个元素符合则返回 true。
         *
         */

        List<User> list7 = new ArrayList<>();
        list7.add(new User(3, "zs"));
        list7.add(new User(2, "ls"));
        list7.add(new User(1, "ww"));
        list7.add(new User(4, "mz"));

        boolean all = list7.stream()
                .allMatch(u -> u.getId() > 0 && u.getId() > 3);
        System.out.println("是否所有ID都大于3：" + all);

        boolean any = list7.stream()
                .anyMatch(u -> u.getId() > 3);
        System.out.println("至少有一个ID大于3：" + any);

        boolean none = list7.stream()
                .noneMatch(u-> u.getId() > 3);
        System.out.println("没有一个ID大于3：" + none);

        /**
         * stream流的reduce使用
         *
         * reduce主要作用是吧stream元素组合起来进行操作
         */

        //字符串连接
        String concat = Stream.of("A", "B", "C", "D")
                .reduce(",", String::concat);
        System.out.println("字符串拼接:" + concat); // ,ABCD

        //得到最小值
        double minValue = Stream.of(-4.0, 1.0, 3.0, -2.0).reduce(Double::min).get();
        System.out.println("最小值:" + minValue); //-4.0

        //求和
        int sumValue = Stream.of(1,2,3,4).reduce((i, j) -> i+j).get();
        System.out.println("无起始值求和：" + sumValue); // 10

        //sumValue = Stream.of("1", "2", "3").mapToInt(Integer::valueOf).reduce(Integer::sum).getAsInt();
        sumValue = Stream.of(1, 3, 5).reduce(4, Integer::sum);
        System.out.println("有起始值求和:" + sumValue); // 13

        //过滤拼接：

        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce(String::concat).get();
        System.out.println("过滤和字符串连接：" + concat);

        /**
         *
         * Stream流的iterate使用
         * iterate 跟 reduce 操作很像，接受一个种子值，和一个UnaryOperator（例如 f）。
         * 然后种子值成为 Stream 的第一个元素，
         * f(seed) 为第二个，f(f(seed)) 第三个，以此类推。
         * 在 iterate 时候管道必须有 limit 这样的操作来限制 Stream 大小。
         */

        //生成一个等差队列
        Stream.iterate(2,n->n+2).limit(5).forEach(n -> System.out.println(n));//2 4  6 8 10


        /**
         *
         * Stream流的groupingBy/partitioningBy使用
         *
         * groupingBy：分组排序；
         *
         * partitioningBy：分区排序。
         *
         */

        List<User> userList = new ArrayList<>();
        userList.add(new User(10, "王五", "上海"));
        userList.add(new User(12, "王麻子", "北京"));
        userList.add(new User(11, "张三", "重庆"));
        userList.add(new User(10, "小李子", "上海"));

       Map<Integer, List<User>> map =  userList.stream().collect(Collectors.groupingBy(User::getId));
        /**  根据ID分组
         * key:10,[User{id=10, name='王五', addr='上海'}, User{id=10, name='小李子', addr='上海'}]
         * key:11,[User{id=11, name='张三', addr='重庆'}]
         * key:12,[User{id=12, name='王麻子', addr='北京'}]
         */
        map.forEach((k, v) -> {
            System.out.println("key:" + k + "," + v.toString());
        });

        /**
         *
         * 根据ID+addr 进行分组
         *
         * key: 12#北京     value: [User{id=12, name='王麻子', addr='北京'}]
         * key: 10#上海     value: [User{id=10, name='王五', addr='上海'}, User{id=10, name='小李子', addr='上海'}]
         * key: 11#重庆     value: [User{id=11, name='张三', addr='重庆'}]
         *
         */
       /* Map<String, List<User>> groupbys = userList.stream().collect(Collectors.groupingBy(user -> new groupBy<String, User>() {
            @Override
            public String groupKey(User user) {
                return user.getId()+"#"+user.getAddr();
            }
        }.groupKey(user)));*/

        Map<String, List<User>> groupbys = userList.stream().collect(Collectors.groupingBy((user -> { return user.getId() +"#" + user.getAddr();})));

        //String str = "hwy";
        groupBy<String, String> bys = str -> {return str+"123";};
        System.out.println(bys.groupKey("hwy"));

        System.out.println("========开始根据多个字段进行分组=======");
        groupbys.forEach((k, v) -> {
            System.out.println("key: " + k + "     value: " + v.toString());
        });

        System.out.println("=======开始进行partitioningby 分区==============");

        /** 根据ID> 10 进行分区
         * id> 10:[User{id=12, name='王麻子', addr='北京'}, User{id=11, name='张三', addr='重庆'}]
         * id <= 10:[User{id=10, name='王五', addr='上海'}, User{id=10, name='小李子', addr='上海'}]
         */
        Map<Boolean, List<User>> partList = userList.stream()
                .collect(Collectors.partitioningBy(p -> p.getId() > 10));

        System.out.println("id> 10:" + partList.get(true));
        System.out.println("id <= 10:" + partList.get(false));


        /**
         *Stream流的summaryStatistics使用
         *
         * IntSummaryStatistics 用于收集统计信息(如count、min、max、sum和average)的状态对象
         *
         * max:12
         * min:10
         * avg:10.75
         * sum:43
         */
        IntSummaryStatistics iss = userList.stream().flatMap( u -> Stream.of(u.getId())).mapToInt(Integer::intValue).summaryStatistics();

        System.out.println("max:" + iss.getMax());
        System.out.println("min:" + iss.getMin());
        System.out.println("avg:" + iss.getAverage());
        System.out.println("sum:" + iss.getSum());




    }









    @FunctionalInterface
    public interface groupBy<K, V> {
       K groupKey(V v);
    }



    public static class  User{

       private  Integer id;

       private String name;

       private String addr;

        public User(Integer id, String name) {
            this.name = name;
            this.id = id;
        }

        public User(Integer id, String name, String addr) {
            this.id = id;
            this.name = name;
            this.addr = addr;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", addr='" + addr + '\'' +
                    '}';
        }
    }

    //构造stream流的方式
    public static void   streamGenerate() {
        Stream stream = Stream.of("a", "b", "c");

        String [] strArray = new String[] {"a", "b", "c"};

        stream = Stream.of(strArray);

        stream = Arrays.stream(strArray);

        stream = Arrays.asList(strArray).stream();
    }
}
