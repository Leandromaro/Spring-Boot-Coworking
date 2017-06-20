package hello.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by leandromaro on 19/6/17.
 */
@Entity
public class UserData {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String lastName;
    private String email;
    private int identificationNumber;

    public UserData(String name, String lastName, String email, int identificationNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
