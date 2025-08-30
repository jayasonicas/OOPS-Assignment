public class Person {
	
    private String name;
    private int age;

    public Person(String name, int age) {
    	System.out.println("Jaya Sonica S");
    	System.out.println("2117240070125");
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
