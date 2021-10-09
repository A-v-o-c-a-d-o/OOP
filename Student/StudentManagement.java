package Student;

public class StudentManagement {
    Student[] students = new Student[100];
    private int size = 0;

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    public void addStudent(Student newStudent) {
        students[size] = newStudent;
        size++;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public void removeStudent(String id) {
        int k = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId().equals(id)) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return;
        }
        
        while (students[k] != null) {
            students[k] = students[k + 1];
            k++;
        }

        size--;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public String studentsByGroup() {
        String ans = "";
        String currentGroup = "";

        for (Student i: students) {
            if (i == null) {
                break;
            }

            if (!i.getGroup().equals(currentGroup)) {
                ans += i.getGroup() + "\n";
                currentGroup = i.getGroup();
            }
            ans += i.getInfo() + "\n";
        }
        return ans;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Tuan Anh", "20021286", "20021286@vnu.edu.vn");
        Student s3 = new Student(s2);
        StudentManagement sm = new StudentManagement();

        sm.addStudent(s1);
        sm.addStudent(s2);
        sm.addStudent(s3);
        sm.removeStudent("20021286");

        System.out.println(sm.studentsByGroup());
    }
}
