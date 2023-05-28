public class Sys {

    public static void mainMenu() {
        for(int i = 0 ; i < 50 ; i++){
            System.out.println();
        }

        System.out.println("< Welcome To English Courses For Children >");
        System.out.println(
                "Out Course Encourage Children To Learn And Experiment With\nLanguage In Safe, Supportive And Stimulating Classroom Environment .\n");


        System.out.println("1 - Sign Up As Student . ");
        System.out.println("2 - Sign In As Teacher . ");
        System.out.println("0 - Exit System");
        System.out.print("What Would You Like To Do : ");
        int choice = Main.scanner.nextInt();
        switch (choice) {
            case 1:
                createStudent();
                break;
            case 2:
                teacherMenu();
                System.out.print("Press Anything To Exit ... ");
                Main.scanner.nextLine();
                Main.scanner.nextLine();
                break;
            case 0:
                choice = 0;
        }

        if (choice != 0) {
            mainMenu();
        }

        

    }

    public static int teacherIndex(String name, String password) {
        int index = -1;

        for (int i = 0; i < Main.teachersArr.size(); i++) {
            if (Main.teachersArr.get(i).getName().equals(name)
                    && Main.teachersArr.get(i).getPassword().equals(password)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void teacherMenu() {
        System.out.print("Please Enter Your Name : ");
        String name = Main.scanner.next();
        System.out.print("Please Enter Your Password : ");
        String password = Main.scanner.next();
        int index = teacherIndex(name, password);

        if (index != -1) {
            System.out.println("Welcome Teacher " + Main.teachersArr.get(index).getName());
            System.out.println("Those Are Your Students " + Main.teachersArr.get(index).getAvailability());
            for (int i = 0; i < Main.teachersArr.get(index).studentsArr.size(); i++) {
                System.out.println(
                        "Student Number " + (i + 1) + " : " + Main.teachersArr.get(index).studentsArr.get(i).getName());
            }
        } else {
            System.out.println("Wrong Name Or Password!\nPlease Try Again.");
            teacherIndex(name, password);
        }

    }

    public static void createStudent() {
        System.out.print("Please Enter Your Name : ");

        Main.scanner.nextLine();
        String name = Main.scanner.nextLine();
        System.out.print("Please Enter Your Age : ");
        int age = Main.scanner.nextInt();
        int score = studentQuiz();
        sortTeachers();
        Main.studentsArr.add(new Student(name, age, score, selectingTeacher(score)));
        sortStudents();
    }

    public static void sortStudents() {
        for (int i = 0; i < Main.studentsArr.size(); i++) {
            for (int j = 0; j < Main.teachersArr.size(); j++) {

                if (Main.studentsArr.get(i).getTeacher().equals(
                        Main.teachersArr.get(j))) {
                    Main.teachersArr.get(j).studentsArr.add(Main.studentsArr.get(i));
                }

            }
        }
    }

    public static int studentQuiz() {
        int score = 0;
        System.out.println("You Are Going To Have A Small Quiz Will Decide Your Level In English \nLet's Start");

        boolean answer;
        for (int i = 0; i < Main.questionsArr.size(); i++) {
            System.out.print(
                    "Question Number " + (i + 1) + " " + Main.questionsArr.get(i).getQuestion() + " ?  ( T / F ) : ");
            String trueOrFalse = Main.scanner.next();
            answer = (trueOrFalse.equalsIgnoreCase("T")) ? true : false;
            if (answer == Main.questionsArr.get(i).getAnswer()) {
                score += 1;
            }
        }

        return score;
    }

    public static void sortTeachers() {
        for (int i = 0; i < Main.teachersArr.size(); i++) {
            if (Main.teachersArr.get(i).level == Main.LEVELS.Advance)
                Main.advanceTeachers.add(Main.teachersArr.get(i));
            if (Main.teachersArr.get(i).level == Main.LEVELS.Intermediate)
                Main.intermediateTeachers.add(Main.teachersArr.get(i));
            if (Main.teachersArr.get(i).level == Main.LEVELS.Beginner)
                Main.beginnerTeachers.add(Main.teachersArr.get(i));
        }
    }

    public static Teacher selectingTeacher(int score) {
        score = score / (Main.questionsArr.size() / score) ; 
        String typeOfClass = (score == 3) ? "Intermediate" : (score > 3) ? "Advance" : "Beginner";
        System.out.println("You Are At " + typeOfClass + " Class");
        System.out.println("Now Please Select Your Teacher ");
        if (score >= 4) {
            for (int i = 0; i < Main.advanceTeachers.size(); i++) {
                System.out.println(Main.advanceTeachers.get(i).getName() + " Available "
                        + Main.advanceTeachers.get(i).getAvailability() + " Index ( " + i + " ) ");
            }
            System.out.print("Please Enter The Teachers Index : ");
            int index = Main.scanner.nextInt();
            return Main.advanceTeachers.get(index);
        } else if (score == 3) {
            for (int i = 0; i < Main.intermediateTeachers.size(); i++) {
                System.out.println(Main.intermediateTeachers.get(i).getName() + " Available "
                        + Main.intermediateTeachers.get(i).getAvailability() + " Index ( " + i + " ) ");
            }
            System.out.print("Please Enter The Teachers Index : ");
            int index = Main.scanner.nextInt();
            return Main.intermediateTeachers.get(index);
        } else if (score < 3) {
            for (int i = 0; i < Main.beginnerTeachers.size(); i++) {
                System.out.println(Main.beginnerTeachers.get(i).getName() + " Available "
                        + Main.beginnerTeachers.get(i).getAvailability() + " Index ( " + i + " ) ");
            }
            System.out.print("Please Enter The Teachers Index : ");
            int index = Main.scanner.nextInt();
            return Main.beginnerTeachers.get(index);
        }

        return new Teacher();
    }

}