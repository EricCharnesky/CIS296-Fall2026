import java.io.Serializable;

public class Major implements Serializable {
    private String name;
    private String college;
    private int creditsRequired;

    public Major(String name, String college, int creditsRequired) {
        this.name = name;
        this.college = college;
        this.creditsRequired = creditsRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getCreditsRequired() {
        return creditsRequired;
    }

    public void setCreditsRequired(int creditsRequired) {
        this.creditsRequired = creditsRequired;
    }
}
