package com.ziluck.iastate.mis320final.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "web_user")
public class WebUser {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email(message = "Please provide a valid Email")
    @NotEmpty(message = "Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<WebRole> getWebRoleListButMakeItHaveASuperWeirdNameSoThereIsNoWayThatJPAOrHibernateCanTryAnySortOfFunnyBusinessOnHere() {
        WebRole role = new WebRole();
        role.setName("ADMIN");
        return Collections.singletonList(role);
    }
}
