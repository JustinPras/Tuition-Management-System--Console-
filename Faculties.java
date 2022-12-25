import java.util.ArrayList;

public class Faculties {

    private ArrayList<Faculty> faculties;

    public Faculties() {
        faculties = new ArrayList<Faculty>();
        faculties.add(new Faculty("John Smith", "john.smith@uts.com", "user222"));
        faculties.add(new Faculty("Jane Tyler", "jane.tyler@uts.com", "super123"));
    }

   public Faculty verifyDetails() {
        String email = Utils.string("Email");
        String password = Utils.string("Password");
        for (Faculty faculty : faculties) {
            if (faculty.hasDetails(email, password)) {
                return faculty;
            }
        }
        return null;
   }

}

