package pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by katgr on 19.11.2017.
 */
@Table(name = "USERS")
@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASS")
    private String pass;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_ROLE")
    private String userRole;

    public Users(String userName, String pass, String emai) {
        this.userName = userName;
        this.pass = pass;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
