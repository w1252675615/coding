package AlgorithmsBook.week1.Assignment1_Percolation;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Person {
    private String Name;
    private int Age;
    public Person(String name, int age){
        checkNotNull(name,"Name shouldn't be null");
        checkArgument(name.length() > 0,"Name String shouldn't be \"\"");
        checkArgument(age > 0, "Age should bigger than zero");
        this.Name = name;
        this.Age = age;
    }

    public static void main(String[] args) {
        Person zhangsan = new Person(null,10);
        //Person lisi = new Person("lisi",-1);
        //Person wangwu = new Person("",10);
        //Person normal = new Person("normal",10);

    }
}
