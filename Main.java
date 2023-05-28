import java.util.*;
import java.io.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> studentsArr = new ArrayList<Student>();
    public static ArrayList<Teacher> teachersArr = new ArrayList<Teacher>();
    public static ArrayList<Quiz> questionsArr = new ArrayList<Quiz>();
    public static ArrayList<Teacher> advanceTeachers = new ArrayList<Teacher>();
    public static ArrayList<Teacher> intermediateTeachers = new ArrayList<Teacher>();
    public static ArrayList<Teacher> beginnerTeachers = new ArrayList<Teacher>();

    public static enum LEVELS {
        Advance, Intermediate, Beginner
    }

    public static void main(String[] args) {

        teachersArr.add(new Teacher("Ahmed", 40, LEVELS.Advance, "From 6 To 8 PM", "12341234"));
        teachersArr.add(new Teacher("Khaled", 40, LEVELS.Intermediate, "From 4 To 6 PM", "43214321"));
        teachersArr.add(new Teacher("Noura", 40, LEVELS.Beginner, "From 2 To 4 PM", "11223344"));

        questionsArr.add(new Quiz("Sheep Can Fly", false));
        questionsArr.add(new Quiz("Dogs Have Four Legs", true));
        questionsArr.add(new Quiz("Fish Live In Water ", true));
        questionsArr.add(new Quiz("There Are Twelve Day In Fortnight", false));
        questionsArr.add(new Quiz("There Are 26 Letters In The English Alphabetic", true));

        Sys.mainMenu();

    }
}