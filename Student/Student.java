package Student;

public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    Student() {
        name = "Student";
        id = "000";
        group = "K62CB";
        email = "uet@vnu.edu.vn";
    }

    Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
        group = "K62CB";
    }

    Student(Student s) {
        name = s.name;
        id = s.id;
        group = s.group;
        email = s.email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGroup() {
        return  group;
    }

    public String getEmail() {
        return email;
    
    }
    
    public String getInfo() {
        return name + " - " + id + " - " + group + " - " + email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroup(String group) {
        this. group = group;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}