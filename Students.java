
import java.util.ArrayList;

public class Students {

    private ArrayList<Student> students;

    public Students() {
        students = new ArrayList<Student>();
        students.add(new Student("Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", "13697480", "Full-Time", 48, 4000, false));
        students.add(new Student("Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", "14517880", "Part-Time", 24, 0, false));
        students.add(new Student("Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", "13267102", "Full-Time", 48, 0, true));
        students.add(new Student("Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney 2100", "13678020", "Full-Time", 48, 0, false));
        students.add(new Student("Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", "13972870", "Full-Time", 48, 8000, false));
        students.add(new Student("Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", "13859610", "Part-Time", 24, 0, true));
    }


    public void addStudent(String name, String email, String phone, String address, String ID, String type, int credits, double scholarship, boolean deduction) {
        students.add(new Student(name, email, phone, address, ID, type, credits, scholarship, deduction));
        System.out.println(name + " record has been created.");
    }

    public Student viewStudent(String name) {
        for (Student student : students){
            if (student.hasName(name)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void viewStudents() {
        Utils.studentHeader();
        for (Student student : students) {
            student.viewStudent();
        }
        System.out.format("+----------------------+---------------------------+------------+------------+%n");
    }

    public void viewReport() {
        for (Student student : students) {
            Slip slip = new Slip(student);
            slip.printSlip();
        }
    }

    public double getTotalTuition() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getTotalFee();
        }
        return sum;
    }
    public double getTotalScholarship() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getScholarship();
        }
        return sum;
    }
    public double getTotalNetFee() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getNetFee();
        }
        return sum;
    }
    public double getTotalDeduction() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getDeduction();
        }
        return sum;
    }
}

