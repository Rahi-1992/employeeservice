package com.virtusaemployee.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Virtusa_Emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int emp_id;
    @Column(name = "E_Name")
    private String emp_name;
    @Column(name = "Department")
    private String emp_Department;
    @Column(name = "Designation")
    private String emp_designation;

}
