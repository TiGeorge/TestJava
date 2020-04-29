package streams;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "ccc", "dd");
        // to list
        List<String> result = list.stream().collect(toList());
        // to collection
        LinkedList<String> res1 = list.stream().collect(toCollection(LinkedList::new));
        // to set
        Set<String> set = list.stream().collect(toSet());
        // to map WITHOUT DUPLICATES
        Map<String, Integer> map = list.stream().collect(toMap(a -> a, String::length));
        Map<String, Integer> map2 = list.stream().collect(toMap(Function.identity(), String::length));
        // to map WITH DUPLICATES
        List<String> list2 = Arrays.asList("a", "bb", "ccc", "dd", "bb");
        Map<String, Integer> map1 = list2.stream().collect(toMap(Function.identity(), String::length, (a, b) -> a));
        // collectingAndThen, to unmodifiable collections
        List<String> list1 = list.stream().collect(collectingAndThen(toList(), List::copyOf));
        List<String> list3 = list.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));
        // joining
        String s = list.stream().collect(joining());
        System.out.println(s);
        String s2 = list.stream().collect(joining("-", "[", "}"));
        System.out.println(s2);
        // counting
        long i = list.stream().collect(counting());
        // summarizing double/long/int
        DoubleSummaryStatistics statistics = list.stream().collect(summarizingDouble(String::length));
        double sum = statistics.getSum();
        double average = statistics.getAverage();
        // averaging D/L/I
        Double aver = list.stream().collect(averagingLong(String::length));
        // summing D/L/I
        Integer collect = list.stream().collect(summingInt(String::length));
        // maxBy, minBy
        Optional<String> collect1 = list.stream().collect(maxBy(Comparator.naturalOrder()));
        // groupingBy
        Map<Integer, List<String>> collect2 = list.stream().collect(groupingBy(String::length));
        Map<Integer, Set<String>> collect3 = list.stream().collect(groupingBy(String::length, toSet()));
        TreeMap<Integer, Set<String>> collect4 = list.stream().collect(groupingBy(String::length, TreeMap::new, toCollection(TreeSet::new)));
        // partitioning
        Map<Boolean, List<String>> collect5 = list.stream().collect(partitioningBy(st -> st.length() < 3));
        Map<Boolean, Set<String>> collect6 = list.stream().collect(partitioningBy(s1 -> s1.length() > 2, toSet()));
        // mapping
        Map<Boolean, Set<Integer>> collect7
                = list.stream().collect(partitioningBy((String s1) -> s1.length() > 2,
                mapping(String::length,
                        toSet())));
        List<Integer> collect8 = list.stream().collect(mapping(String::length, toList()));
    }
}

class TestReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        Integer reduce3 = list.parallelStream().reduce(0, Integer::sum, Integer::sum);
        System.out.println(reduce3);

        List<String> strings = Arrays.asList("a", "s", "d", "q", "w");
        String reduce1 = strings.stream().reduce("", String::concat);
        System.out.println(reduce1);
        String reduce2 = strings.stream().reduce("", (a, b) -> a.toUpperCase() + b.toUpperCase());
        System.out.println(reduce2);

        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        Integer reduce4 = users.stream().reduce(0, (Integer a, User b) -> a + b.getAge(), Integer::sum);

    }
}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}