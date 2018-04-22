package com.zsoft.cra.service.mapper;

import com.zsoft.cra.domain.Authority;
import com.zsoft.cra.domain.Employee;
import com.zsoft.cra.service.dto.EmployeeDTO;
import com.zsoft.cra.service.dto.UserDTO;
import com.zsoft.cra.service.util.ConverterUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity Employee and its DTO EmployeeDTO.
 */
@Service
public class EmployeeMapper {

    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(employee);
    }

    public List<UserDTO> employeesToEmployeeDTOs(List<Employee> employees) {
        return employees.stream()
            .filter(Objects::nonNull)
            .map(this::employeeToEmployeeDTO)
            .collect(Collectors.toList());
    }

    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        } else {
            Employee employee = new Employee();
            employee.setCode(employeeDTO.getCode());
            employee.setId(employeeDTO.getId());
            employee.getAccount().setLogin(employeeDTO.getLogin());
            employee.getAccount().setFirstName(employeeDTO.getFirstName());
            employee.getAccount().setLastName(employeeDTO.getLastName());
            employee.getAccount().setEmail(employeeDTO.getEmail());
            employee.getAccount().setImageUrl(employeeDTO.getImageUrl());
            employee.getAccount().setActivated(employeeDTO.isActivated());
            employee.getAccount().setLangKey(employeeDTO.getLangKey());
            Set<Authority> authorities = ConverterUtil.authoritiesFromStrings(employeeDTO.getAuthorities());
            if (authorities != null) {
                employee.getAccount().setAuthorities(authorities);
            }
            return employee;
        }
    }

    public List<Employee> employeeDTOsToEmployee(List<EmployeeDTO> employeeDTOs) {
        return employeeDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::employeeDTOToEmployee)
            .collect(Collectors.toList());
    }


}
