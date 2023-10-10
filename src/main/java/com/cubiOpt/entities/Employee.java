package com.cubiOpt.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "name")
    private String name;


//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<Request> requests = new ArrayList<>();
}

