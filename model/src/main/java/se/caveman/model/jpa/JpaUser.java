package se.caveman.model.jpa;

import javax.persistence.Entity;

@Entity
public class JpaUser extends AbstractEntity {

    private String username;
    private String password;

    protected JpaUser(){}

    public JpaUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
