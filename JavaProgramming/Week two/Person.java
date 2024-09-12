public class Person {
    //Declaring Instance Variable
    private String name;
    private int age;
    private int height;

    // Constructor
    /*    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }*/
    public Person(){
        this.name = "Unknown";
        this.age = 0;
        this.height = 0;
    }

    // Setter or Mustators
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    // Getters or accessor
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getHeight() {
        return height;
    }

}