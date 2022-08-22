package ir.maktab74.model;

import ir.maktab74.base.entity.BaseEntity;
import ir.maktab74.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity<Long> implements Serializable {

    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String mobileNumber;

    @OneToMany (mappedBy = "user")
    private List<Ticket> tickets;

    public User(String firstName, String lastName, String username, String password, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public User(String firstName, String lastName, String username, String password, Gender gender, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }


}
