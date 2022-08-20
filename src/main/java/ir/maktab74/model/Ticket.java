package ir.maktab74.model;


import ir.maktab74.base.entity.BaseEntity;
import ir.maktab74.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity<Long> implements Serializable {

    @Column(nullable = false)
    private String customerFirstName;
    @Column(nullable = false)
    private String customerLastName;
    @Column(unique = true, nullable = false)
    private String customerNationalCode;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private double price;

    @Column(nullable = false,unique = true)
    private String ticketId;

    @ManyToOne
    private Travel travel;

    @ManyToOne
    private User user;


}
