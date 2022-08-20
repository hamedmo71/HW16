package ir.maktab74.model;

import ir.maktab74.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Travel extends BaseEntity<Long> implements Serializable {

    @Column(unique = true,nullable = false)
    private String travelId;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String Model;

    @Column(nullable = false)
    private Integer numberOfSeats;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Date travelDate;

    @OneToMany(mappedBy = "travel")
    private List<Ticket> tickets;


    @ManyToOne
    private Agency agency;


    @Override
    public String toString() {
        return "Vehicle{" +
                "travelId='" + travelId + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", Model='" + Model + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", price=" + price +
                ", TravelDate=" + travelDate +
                ", agency=" + agency +
                '}';
    }
}
