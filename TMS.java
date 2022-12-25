import java.util.ArrayList;


public class TMS {
    private double totalTuition;
    private double totalScholarship;
    private double totalNetFee;
    private double totalDeduction;
    private double bas;
    private String name;
    private Students students;
    private ArrayList<Slip> slips;
    private Faculty faculty;
    
    public TMS(Faculty faculty, Students students) {
        this.faculty = faculty;
        this.name = faculty.getName();
        this.students = students;
        slips = new ArrayList<Slip>();  
    }

    public void useTMS() {
        menuTMS();
        char choice;
        while ((choice = choiceTMS()) != 'X') {
            switch(choice) {
                case 'F' : findSlip(); break;
                case 'V' : viewTMS(); break;
                case 'A' : archiveReport(); break;
                case 'R' : retrieveReport(); break;
                case 'S' : showLog(); break;
                default : menuTMS();
            }
        }
    }

    private void retrieveReport() {
        faculty.retrieveReport();
    }

    private void archiveReport() {
        faculty.archiveReport(this);
    }

    private void showLog() {
        faculty.showLog();   
    }

    
    private void findSlip() {
        String name = Utils.string("Name");
        Student student = students.viewStudent(name);
        if (student != null) {
            System.out.println("Tuition Slip:");
            Slip slip = new Slip(student);
            Utils.slipHeader();
            slip.printSlip();
            System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
        }
        else {
            System.out.println("Tuition slip does not exist for " + name + "!");
        }
    }

    private void menuTMS() {
        System.out.println("TMS Menu: \n" + 
        "F- Find Tuition Slip\n" +
        "V- View TMS Report\n" +
        "A- Archive TMS Report\n" +
        "R- Retrieve TMS Report\n" +
        "S- Show TMS Log\n" +
        "X- Close");
    }

    private char choiceTMS() {
        return Utils.choice("Session Admin: " + this.name + " - Menu Commands (F/V/A/R/S/X)");
    }

    public Students getStudents() {
        return this.students;
    }

    public void viewTMS() {
        System.out.println("TMS Report: ");
        Utils.slipHeader();
        students.viewReport();
        System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
        totalTuition = students.getTotalTuition();
        totalScholarship = students.getTotalScholarship();
        totalNetFee = students.getTotalNetFee();
        totalDeduction = students.getTotalDeduction();
        bas = totalScholarship + totalDeduction;
        System.out.print("\n");
        System.out.format("+--------------------+-------------+%n");
        System.out.format(Utils.sumFormat, "Total Tuition", totalTuition);
        System.out.format(Utils.sumFormat, "Total Scholarship", totalScholarship);
        System.out.format(Utils.sumFormat, "Total NetFee", totalNetFee);
        System.out.format(Utils.sumFormat, "Total Deduction", totalDeduction);
        System.out.format(Utils.sumFormat, "Total Bas", bas);
        System.out.format("+--------------------+-------------+%n");
    }
}

