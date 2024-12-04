

public class Child {
    private String fullName;
    private String gender;
    private int age;

    public Child(String fullName, String gender, int age) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName + ", Пол: " + gender + ", Возраст: " + age;
    }
}
