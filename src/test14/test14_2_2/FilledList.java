package test14.test14_2_2;


import java.util.ArrayList;
import java.util.List;

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}


public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {//构造方法 用于该类的初始化
        this.type = type;
    }

/*
    public FilledList() {
    }
*/


    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());//不是说需要一个空的构造方法吗！
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(15));
    }

}


