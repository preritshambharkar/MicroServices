package com.user.service.entities;

import com.user.service.vo.Rating;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long user_Id;

    @Column(name = "FIRST_NAME")
    @NotNull
    private String first_name;

    @Column(name = "Last_NAME" )
    @NotNull
    private String last_name;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE", columnDefinition = "boolean default false")
    private Boolean active = true;

    @Column(name = "ADDRESS")
    private String address;

    @Transient  //not to save that in database
    private List<Rating> ratings = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "user_Id=" + user_Id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob='" + dob + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", address='" + address + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
