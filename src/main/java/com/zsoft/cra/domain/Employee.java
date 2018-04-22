package com.zsoft.cra.domain;

import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Employee.
 */
@Document(collection = "employee")
public class Employee extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 8)
    @Field("code")
    @Unique
    private String code;

    @DBRef
    @NotNull
    @Field("account_ref")
    private User account;

    public Employee() {
        this.account = new User();
    }

    public Employee(User account, String code) {
        this.account = account;
        this.code = code;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getAccount() {
        return this.account;
    }

    public void setAccount(User user) {
        this.account = user;
        this.account = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        if (employee.getId() == null || getId() == null) {
            return false;
        }
        return this.getCode().equalsIgnoreCase(employee.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", login='" + account.getLogin() + '\'' +
            ", firstName='" + account.getFirstName() + '\'' +
            ", lastName='" + account.getLastName() + '\'' +
            ", email='" + account.getEmail() + '\'' +
            ", imageUrl='" + account.getImageUrl() + '\'' +
            ", activated='" + account.getActivated() + '\'' +
            ", langKey='" + account.getLangKey() + '\'' +
            ", activationKey='" + account.getActivationKey() + '\'' +
            "}";
    }
}
