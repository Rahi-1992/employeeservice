package com.virtusaemployee.Repositories;

import com.virtusaemployee.entities.VEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<VEmployee,Integer> {

}
