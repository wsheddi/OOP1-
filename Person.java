abstract public class Person {
    
    String name ; 
    int age ; 

    Person(String name , int age){
        this.name = name;
        this.age = age;
    }

    Person(){} ; 

    abstract public String getName() ; 
    abstract public int getAge() ;


}