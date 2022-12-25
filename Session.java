public class Session {
    private Faculties faculties;

    public static void main(String[] args) {
        Session session = new Session();
        session.useLogin();
    }
    
    public Session() {
        faculties = new Faculties();
    }
    
    private void useLogin() {
        menuLogin();
        char choice;
        while ((choice = choiceLogin()) != 'X') {
            if (choice == 'L') {
                Faculty faculty = faculties.verifyDetails();
                if (faculty != null) {
                    faculty.useAdmin();
                    System.out.println("\n" + "TMS Tuition Management System:");
                    choice = choiceLogin();
                    break;
                }
                else {
                    System.out.println("Incorrect faculty details!");
                }
            }
            else {
                menuLogin();
            }
            
        }
        System.out.println("\n" + "Session Terminated!");
    }
    
    private void menuLogin() {
        System.out.println("Tuition Management System:\n" +
        "L- Login\n" +
        "X- Exit");
    }
    
    private char choiceLogin() {
        return Utils.choice("Command (L/X)");
    }
}

