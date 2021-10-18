package Person;

public class Student extends Person {
    private String program;
    
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    private int year;
    private double fee;

    public String toString() {
        return "Student[" + super.toString() + ",program="
        + program + ",year=" + year + ",fee=" + fee + "]";
    }

    /** An especially short bit of Javadoc. */
    public Student(String name, String address,
                String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
}