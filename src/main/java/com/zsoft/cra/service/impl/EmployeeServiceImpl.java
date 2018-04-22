package com.zsoft.cra.service.impl;

import com.zsoft.cra.domain.Authority;
import com.zsoft.cra.domain.Employee;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.repository.AuthorityRepository;
import com.zsoft.cra.repository.EmployeeRepository;
import com.zsoft.cra.repository.UserRepository;
import com.zsoft.cra.service.EmployeeService;
import com.zsoft.cra.service.UserService;
import com.zsoft.cra.service.dto.EmployeeDTO;
import com.zsoft.cra.service.dto.UserDTO;
import com.zsoft.cra.service.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


/**
 * Service Implementation for managing Employee.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final UserService userService;

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final CacheManager cacheManager;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserService userService,
                               UserRepository userRepository, AuthorityRepository authorityRepository,
                               EmployeeMapper employeeMapper, CacheManager cacheManager) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.userService = userService;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.cacheManager = cacheManager;
    }

    /**
     * Save a employee.
     *
     * @param employeeDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        log.debug("Request to save Employee : {}", employeeDTO);
        User user = null;
        user = userService.createUser((UserDTO) employeeDTO);
        Employee employee = new Employee(user, employeeDTO.getCode());
        return employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public Optional<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO) {
        return Optional.of(employeeRepository
            .findOne(employeeDTO.getId()))
            .map(employee -> {
                User account = employee.getAccount();
                account.setLogin(employeeDTO.getLogin());
                account.setFirstName(employeeDTO.getFirstName());
                account.setLastName(employeeDTO.getLastName());
                account.setEmail(employeeDTO.getEmail());
                account.setImageUrl(employeeDTO.getImageUrl());
                account.setActivated(employeeDTO.isActivated());
                account.setLangKey(employeeDTO.getLangKey());
                Set<Authority> managedAuthorities = account.getAuthorities();
                managedAuthorities.clear();
                employeeDTO.getAuthorities().stream()
                    .map(authorityRepository::findOne)
                    .forEach(managedAuthorities::add);
                userRepository.save(account);
                employee.setCode(employeeDTO.getCode());
                employee = employeeRepository.save(employee);
                log.debug("Changed Information for Employee: {}", employee);
                return employee;
            })
            .map(EmployeeDTO::new);
    }

    /**
     * Get all the employees.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Employees");
        return employeeRepository.findAll(pageable)
            .map(employeeMapper::employeeToEmployeeDTO);
    }

    /**
     * Get one employee by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public EmployeeDTO findOne(String id) {
        log.debug("Request to get Employee : {}", id);
        Employee employee = employeeRepository.findOne(id);
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    /**
     * Delete the employee by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Employee : {}", id);
        employeeRepository.delete(id);
    }
}
