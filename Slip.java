
public class Slip {

    private String name;
    private double totalFee;
    private double scholarship;
    private double netFee;
    private double deduction;

    public Slip(Student student) {
        this.name = student.getName();
        this.totalFee = student.getTotalFee();
        this.scholarship = student.getScholarship();
        this.netFee = student.getNetFee();
        this.deduction = student.getDeduction();
    }

    public void printSlip() {
        System.out.format(Utils.tmsFormat, name, totalFee, scholarship, netFee, deduction);
    }

    public boolean hasStudent(Student student) {
        return this.name.equals(student.getName());
    }
}

