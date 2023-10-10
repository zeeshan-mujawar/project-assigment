package com.cubiOpt.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "desk")
public class Desk {

    @Id
    @Column(name = "desk_id")
    private String deskId;

    @Column(name = "occupancy_status")
    private String occupancyStatus;

    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;
}

