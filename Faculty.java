
public class Faculty {

    private String name;
    private String email;
    private String password;
    private Students students;
    private TMSLog tmsLog;

    
    public Faculty(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        students = new Students();
        tmsLog = new TMSLog();
    }

    public void useAdmin() {
        menuAdmin();
        char choice;
        while ((choice = choiceAdmin()) != 'X') {
            switch(choice) {
                case 'C' : addStudent(); break;
                case 'R' : viewStudent(); break;
                case 'U' : updateStudent(); break;
                case 'D' : deleteStudent(); break;
                case 'V' : viewStudents(); break;
                case 'T' : TMS tms = new TMS(this, this.students);
                tms.useTMS(); 
                System.out.println("\n" + "Faculty Menu:");
                break;
                default : menuAdmin();
            }
        }
    }

    private void addStudent() {
        String name = Utils.string("Name");
        String email = Utils.string("Email");
        String phone = Utils.string("Phone");
        String address = Utils.string("Address");
        String ID = Utils.string("ID");
        String type = Utils.string("Type");
        int credits = Utils.number("Credits");
        double scholarship = Utils.amount("Scholarship($)");
        boolean deduction = Utils.check("Deduction Code");
        students.addStudent(name, email, phone, address, ID, type, credits, scholarship, deduction);
    }

    private void viewStudent() {
        String name = Utils.string("Name");
        Student student = students.viewStudent(name);
        if (student != null) {
            Utils.studentHeader();
            student.viewStudent();
            System.out.format("+----------------------+---------------------------+------------+------------+%n");
        }
        else {
            System.out.println(name + " record does not exist!");
        }
    }

    private void updateStudent() {
        String nameOld = Utils.string("Name");
        Student student = students.viewStudent(nameOld);
        if (student != null) {
            System.out.println("Updating " + nameOld + " record: ");
            String nameNew = Utils.string("Name");
            String email = Utils.string("Email");
            String phone = Utils.string("Phone");
            String address = Utils.string("Address");
            String type = Utils.string("Type");
            int credits = Utils.number("Credits");
            double scholarship = Utils.amount("Scholarship($)");
            boolean deduction = Utils.check("Deduction Code");
            student.updateStudent(nameNew, email, phone, address, type, credits, scholarship, deduction);
            System.out.println(nameOld + " record has been updated.");
        }
        else {
            System.out.println(nameOld + " record does not exist!");
        }
    }

    private void deleteStudent() {
        String name = Utils.string("Name");
        Student student = students.viewStudent(name);
        if (student != null) {
            this.students.deleteStudent(student);
            System.out.println(name + " record has been deleted.");
        }
        else {
            System.out.println(name + " record does not exist!");
        }
    }

    private void viewStudents() {
        students.viewStudents();
    }

    public boolean hasDetails(String email, String password) {
        return (this.email.equals(email) && this.password.equals(password));
    }

    private void menuAdmin() {
        System.out.println("Admin Menu: \n" + 
        "C- Add Student\n" +
        "R- View Student\n" +
        "U- Update Student\n" +
        "D- Delete Student\n" +
        "V- View Students\n" +
        "T- TMS Menu\n" +
        "X- Logout");
    }

    public String getName() {
        return this.name;
    }

    private char choiceAdmin() {
        return Utils.choice("Session Admin: " + this.name + " - Menu Commands (C/R/U/D/V/T/X)");
    }

    public void archiveReport(TMS tms){
        System.out.println("TMS record is created as:" +this.name + (tmsLog.getSize() + 1));
        tmsLog.archiveReport(tms);
    }

    public void showLog() {
        tmsLog.showLog(this.name);
    }

    public void retrieveReport() {
        tmsLog.retrieveReport(this.name);
    }
}

