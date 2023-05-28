import java.util.*;

public class Student extends Person {

    private int score;
    private int id;
    private Teacher teacher ; 

    Student(String name, int age, int score , Teacher teacher) {
        super(name, age);
        this.score = score;
        this.id = idGenerator() ;
        this.teacher = teacher ; 
    }

    public Teacher getTeacher() {
        return this.teacher ;
    }

    public int getScore() {
        return this.score;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {

        return age;
    }

    private int idGenerator() {
        Random r = new Random();
        return r.nextInt(1000) + 1 ; 
    }

}