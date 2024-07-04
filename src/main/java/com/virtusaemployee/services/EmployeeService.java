package com.virtusaemployee.services;

import com.virtusaemployee.entities.VEmployee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    public List<VEmployee> getAllEmployees();

    public Optional<VEmployee> getEmployeeById(int id);

    VEmployee addEmployee(VEmployee employee);

    Optional<VEmployee> updateEmployeeById(VEmployee vemployee, int id);

    void deleteEmployee(int eid);
}
