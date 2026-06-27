class Student{
    int marks;
    Student(int m){
        this.marks = m;
    }
}

public class Test {
    public static void fun(Student s){
        s.marks = 50;
        s = new Student(100);
    }
    public static void main(String[] args) {
        Student s = new Student(150);
        fun(s);
        System.out.println(s.marks);
    }
}
