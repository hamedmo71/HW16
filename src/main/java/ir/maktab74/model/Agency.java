package ir.maktab74.model;


import ir.maktab74.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Agency extends BaseEntity<Long> implements Serializable {

    @Column(unique = true,nullable = false)
    private String agencyName;

    @Column(unique = true,nullable = false)
    private String agencyCode;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "agency")
    private List<Travel> travelList;

    @Override
    public String toString() {
        return
                "'" + agencyName + '\'';
    }
}
