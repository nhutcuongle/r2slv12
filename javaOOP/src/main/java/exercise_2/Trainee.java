package exercise_2;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    // Constructors
    public Trainee() {
    }

    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            System.out.println("ID cannot be empty!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty!");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            this.gender = gender;
        } else {
            System.out.println("Gender must be male or female!");
        }
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age >= 6) {
            this.age = age;
        } else {
            System.out.println("Age must be >= 6!");
        }
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-18s | %-6s | %3d", id, name, gender, age);
    }
}
