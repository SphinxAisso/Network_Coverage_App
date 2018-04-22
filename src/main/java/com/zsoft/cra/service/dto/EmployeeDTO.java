package com.zsoft.cra.service.dto;


import com.zsoft.cra.domain.Authority;
import com.zsoft.cra.domain.Employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A DTO for the Employee entity.
 */
public class EmployeeDTO extends UserDTO implements Serializable {

    private String id;

    @NotNull
    @Size(min = 8)
    private String code;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        super.setId(employee.getAccount().getId());
        this.id = employee.getId();
        this.code = employee.getCode();
        setLogin(employee.getAccount().getLogin());
        setFirstName(employee.getAccount().getFirstName());
        setLastName(employee.getAccount().getLastName());
        setEmail(employee.getAccount().getEmail());
        setActivated(employee.getAccount().getActivated());
        setImageUrl(employee.getAccount().getImageUrl());
        setLangKey(employee.getAccount().getLangKey());
        setCreatedBy(employee.getCreatedBy());
        setCreatedDate(employee.getCreatedDate());
        setLastModifiedBy(employee.getLastModifiedBy());
        setLastModifiedDate(employee.getLastModifiedDate());
        setAuthorities(employee.getAccount().getAuthorities().stream()
            .map(Authority::getName)
            .collect(Collectors.toSet()));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return super.getId();
    }

    public void setAccountId(String id) {
        super.setId(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmployeeDTO employeeDTO = (EmployeeDTO) o;
        if (employeeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), employeeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            "login='" + getLogin() + '\'' +
            ", firstName='" + getFirstName() + '\'' +
            ", lastName='" + getLastName() + '\'' +
            ", email='" + getEmail() + '\'' +
            ", imageUrl='" + getImageUrl() + '\'' +
            ", activated=" + isActivated() +
            ", langKey='" + getLangKey() + '\'' +
            ", createdBy=" + getCreatedBy() +
            ", createdDate=" + getCreatedDate() +
            ", lastModifiedBy='" + getLastModifiedBy() + '\'' +
            ", lastModifiedDate=" + getLastModifiedDate() +
            ", authorities=" + getAuthorities() +
            "}";
    }
}
