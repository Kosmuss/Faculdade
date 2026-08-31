//feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)


package LPR1.LPR2;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

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

    @Override
    public String toString() {
        return "Student[" + super.toString() + ",program=" + program + ",year=" + year + ",fee=" + fee + "]";
    }
}

class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + ",school=" + school + ",pay=" + pay + "]";
    }
}

public class TP01_Ex03 {
    public static void main(String[] args) {
        Student student = new Student("Igor Cristiano bezerra", "rua maria cristina, 50", "ADS", 2026, 0.0);
        
        System.out.println(student.toString());
        student.setProgram("Analise e Desenvolvimento de Sistemas");
        student.setYear(2027);
        student.setFee(0.0);
        student.setAddress("rua maria cristina, 50");
        
        System.out.println(student.getName());
        System.out.println(student.getAddress());
        System.out.println(student.getProgram());
        System.out.println(student.getYear());
        System.out.println(student.getFee());

        Staff staff = new Staff("Igor Cristiano bezerra", "rua maria cristina, 50", "IFSP", 8000.00);
        
        System.out.println(staff.toString());
        staff.setSchool("Instituto Federal de São Paulo");
        staff.setPay(8500.00);
        staff.setAddress("rua maria cristina, 50");
        
        System.out.println(staff.getName());
        System.out.println(staff.getAddress());
        System.out.println(staff.getSchool());
        System.out.println(staff.getPay());
    }
}