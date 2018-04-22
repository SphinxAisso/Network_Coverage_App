package com.zsoft.cra.service;

import com.zsoft.cra.service.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Employee.
 */
public interface EmployeeService {

    /**
     * Save a employee.
     *
     * @param employeeDTO the entity to save
     * @return the persisted entity
     */
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);


    /**
     * Update a employee.
     *
     * @param employeeDTO the entity to update
     * @return the updated entity or new entity if does'nt exist
     */
    Optional<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO);


    /**
     * Get all the employees.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<EmployeeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" employee.
     *
     * @param id the id of the entity
     * @return the entity
     */
    EmployeeDTO findOne(String id);

    /**
     * Delete the "id" employee.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
