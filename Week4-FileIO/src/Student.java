import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int number;
    private Major major;

    public Student(String name, int number, Major major) {
        this.name = name;
        this.number = number;
        this.major = major;
    }

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

