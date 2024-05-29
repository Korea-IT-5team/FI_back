package com.project.back.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="reservation")
@Table(name="reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {
    @Id
    private Integer reservationNumber;
    private Boolean reservationStatus;
    private String reservationUserEmailId;
    private String reservationUserName;
    private Integer reservationRestaurantId;
    private String reservationRestaurantName;
    private String  reservationDate;
    private String reservationTime;
    private Integer reservationPeople;
    private String cancellationReason;
}
