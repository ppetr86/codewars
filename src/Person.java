public class Person {

  public String firstName;
  public String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public static void main(String[] args) {
    int i = 0;
    String s = "apple";
    Person p = new Person("Jonh", "Doe");

    doSomething(i, s, p);

    System.out.println(i);
    System.out.println(s);
    System.out.println(p);
  }

  public static void doSomething(int i, String s, Person p) {
    i = 5;
    s = "banana";
    p.lastName = "Rambo";
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}
