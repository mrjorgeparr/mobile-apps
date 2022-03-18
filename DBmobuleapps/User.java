public class User {
    // definition of relatin attributes

    //id is defined as String to prevent possible overflows when the number of users grows
    private String id;
    private String name;
    private String surname1;
    private String surname2;
    private String email;

    // now we define the cosntructor method
    public User(String id, String name, String surname1, String surname2, String email){
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.email = email;
    }


    //now the getter methods
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname1(){
        return surname1;
    }

    public String getSurname2(){
        return surname2;
    }

    public String getEmail(){
        return email;
    }


    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }
}
