package Model;

public class MainModel {
    DataManager dataManager;

    public MainModel() {
        dataManager = dataManager.getInstance();
    }

    public Person login(String id, String password){

        Person p = dataManager.findInstructor(id);

        if ( p == null)
            p = dataManager.findStudent(id);

        if (p == null)
            return null; //User not found

        if (p instanceof Instructor){
            if(((Instructor) p).getM_Password().equals(password))
                return p;
        }
        else {
            if (((Student) p).getM_Password().equals(password))
                return p;
        }
        return null;
    }

    public void register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) {
        Instructor newIns;
        Student newStudent;
        if(instructor) {
            newIns = new Instructor(firstName, lastName, id, phone, email, password);
            dataManager.addInstructor(newIns);
        }
        else{
            newStudent = new Student(firstName,lastName,id,phone,email,password);
            dataManager.addStudent(newStudent);
        }

    }
}
