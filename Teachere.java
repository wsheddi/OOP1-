import java.util.ArrayList;

public class Teacher extends Person {

    public Main.LEVELS level;
    private String availability ; 
    private String password ;
    ArrayList<Student> studentsArr = new ArrayList<Student>();

    Teacher(String name, int age, Main.LEVELS level , String availability , String password) {
        super(name, age);
        this.level = level;
        this.availability = availability;
        this.password = password;
    }

    Teacher() {
    };

    public String getPassword(){
        return this.password;
    }

    public String getAvailability(){
        return this.availability;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void displayStudents() {
        for (int i = 0; i < this.studentsArr.size(); i++) {
            System.out.println(this.studentsArr.get(i).getName());
        }
    }

}