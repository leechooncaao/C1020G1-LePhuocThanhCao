package models.person;

public class Employee extends Person implements Comparable<Employee> {
    private LevelEmployee level;
    private Position position;
    private double salary;
    private Department department;
    private String idEmployee;

    public Employee(String fullName, String address, String birthDay, String id,
                    String phoneNumber, String email, Gender gender, LevelEmployee level,
                    Position position, double salary, Department department, String idEmployee) {
        super(fullName, address, birthDay, id, phoneNumber, email, gender);
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.department = department;
        this.idEmployee = idEmployee;
    }

    public Employee() {

    }

    public LevelEmployee getLevel() {
        return level;
    }

    public void setLevel(LevelEmployee level) {
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private int getYear(String birthDay) {
        return Integer.parseInt(birthDay.substring(6));
    }

    @Override
    public String toString() {
        return "Employee{idEmployee= " + getIdEmployee()
                + "; fullName= " + getFullName()
                + "; address= " + getAddress()
                + "; birthDay= " + getBirthDay()
                + "; id= " + getId()
                + "; phoneNumber= " + getPhoneNumber()
                + "; email= " + getEmail()
                + "; gender= " + getGender()
                + "; level= " + getLevel()
                + "; position= " + getPosition()
                + "; department= " + getDepartment()
                + "; salary= " + getSalary()
                + " }";
    }

    @Override
    public int compareTo(Employee o) {
        var compareByName = getFullName().compareTo(o.getFullName());
        var compareByYear = getYear(this.getBirthDay()) - getYear(o.getBirthDay());

        if (compareByName == 0)
            return compareByYear;

        return compareByName;
    }
}
