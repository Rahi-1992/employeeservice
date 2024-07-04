package com.virtusaemployee.servicesImpl;

import com.virtusaemployee.Repositories.EmployeeRepository;
import com.virtusaemployee.entities.VEmployee;
import com.virtusaemployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<VEmployee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Optional<VEmployee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public VEmployee addEmployee(VEmployee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Optional<VEmployee> updateEmployeeById(VEmployee vemployee, int id) {
        Optional<VEmployee> existingEmployee= employeeRepository.findById(id);
        try {
            if (existingEmployee.isPresent()) {
                return Optional.of(employeeRepository.save(vemployee));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return Optional.ofNullable(vemployee);
    }

    @Override
    public void deleteEmployee(int eid) {
        try{
            this.employeeRepository.deleteById(eid);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(" employee is not Delete");
        }

    }
}
