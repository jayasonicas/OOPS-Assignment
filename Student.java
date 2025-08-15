public class Student {
    String name;
    int age;

    // Constructor using "this" to refer to the current instance
    public Student(String name, int age) {
        this.name = name; // Refers to instance variable
        this.age = age;   // Refers to instance variable
    }

    // Method using "this" to refer to the current instance
    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

    public static void main(String[] args) {
        // First student
        Student s1 = new Student("Alice", 20);
        s1.display();

        System.out.println(); // blank line for clarity

        // Second student
        Student s2 = new Student("Bob", 22);
        s2.display();
    }
}
