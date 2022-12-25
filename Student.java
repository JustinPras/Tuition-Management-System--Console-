
public class Student {
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type; 
    private int credits;
    private static double payPerCredit;
    private double totalFee;
    private double netFee;
    private double scholarship;
    private boolean deduction;
    private static double deductionRate;
    private Faculty faculty;

   public Student(String name, String email, String phone, String address, String ID, String type, int credits, double scholarship, boolean deduction) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.credits = credits;
        this.scholarship = scholarship;
        this.deduction = deduction;

        this.payPerCredit = 500;
        this.totalFee = credits * payPerCredit;
        this.deductionRate = 0.10;
        this.netFee = totalFee - scholarship - getDeduction();
   }

   public boolean hasName(String name) {
       return this.name.equals(name);
   }

   public void viewStudent() {
       System.out.format(Utils.studentFormat, name, email, phone, type);
   }

   public void updateStudent(String nameNew, String email, String phone, String address, String type, int credits, double scholarship, boolean deduction) {
        this.name = nameNew;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.credits = credits;
        this.scholarship = scholarship;
        this.deduction = deduction;
   }

    public String getName() {
        return this.name;
    }

    public double getTotalFee() {
        return this.totalFee;
    }

    public double getScholarship() {
        return this.scholarship;
    }

    public double getNetFee() {
        return this.netFee;
    }

    public double getDeduction() {
        if (deduction) {
            return this.totalFee*this.deductionRate;
        }
        return 0;
    }
}


