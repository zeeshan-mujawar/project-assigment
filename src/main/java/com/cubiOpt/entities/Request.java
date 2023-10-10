package com.cubiOpt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request")
public class Request {

    @Id
    @Column(name = "request_id")
    private long requestId;

    private String status;

    @ManyToOne
    @JoinColumn(name = "from_desk_id", referencedColumnName = "desk_id")
    private Desk fromDesk;

    @ManyToOne
    @JoinColumn(name = "to_desk_id", referencedColumnName = "desk_id")
    private Desk toDesk;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    @PrePersist
    private void setDefaultValues() {
        if (status == null) {
            status = "In progress";
        }
    }
}
