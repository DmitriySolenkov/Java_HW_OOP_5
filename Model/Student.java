package Model;

public class Student {
    protected String name;
    protected String surname;
    protected String group;
    protected int age;

    public Student(String name, String surname, String group, int age) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    protected void setGroup(String group) {
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student " + name + " " + surname + ", group=" + group + ", age=" + age;
    }

};