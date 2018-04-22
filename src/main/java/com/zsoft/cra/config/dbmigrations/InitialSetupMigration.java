package com.zsoft.cra.config.dbmigrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.zsoft.cra.domain.Authority;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.security.AuthoritiesConstants;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        Authority employeeAuthority = new Authority();
        employeeAuthority.setName(AuthoritiesConstants.EMPLOYEE);
        Authority managerAuthority = new Authority();
        managerAuthority.setName(AuthoritiesConstants.MANAGER);
        mongoTemplate.save(adminAuthority);
        mongoTemplate.save(userAuthority);
        mongoTemplate.save(employeeAuthority);
        mongoTemplate.save(managerAuthority);
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        Authority employeeAuthority = new Authority();
        employeeAuthority.setName(AuthoritiesConstants.EMPLOYEE);
        Authority managerAuthority = new Authority();
        managerAuthority.setName(AuthoritiesConstants.MANAGER);

        //The System user
        User systemUser = new User();
        systemUser.setId("user-0");
        systemUser.setLogin("system");
        systemUser.setPassword("$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG");
        systemUser.setFirstName("");
        systemUser.setLastName("System");
        systemUser.setEmail("system@localhost");
        systemUser.setActivated(true);
        systemUser.setLangKey("en");
        systemUser.setCreatedBy(systemUser.getLogin());
        systemUser.setCreatedDate(Instant.now());
        systemUser.getAuthorities().add(adminAuthority);
        systemUser.getAuthorities().add(userAuthority);
        systemUser.getAuthorities().add(managerAuthority);
        mongoTemplate.save(systemUser);

        User adminUser = new User();
        adminUser.setId("user-2");
        adminUser.setLogin("admin");
        adminUser.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
        adminUser.setFirstName("admin");
        adminUser.setLastName("Administrator");
        adminUser.setEmail("admin@localhost");
        adminUser.setActivated(true);
        adminUser.setLangKey("en");
        adminUser.setCreatedBy(systemUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        adminUser.getAuthorities().add(managerAuthority);
        mongoTemplate.save(adminUser);

        User userUser = new User();
        userUser.setId("user-3");
        userUser.setLogin("user");
        userUser.setPassword("$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K");
        userUser.setFirstName("");
        userUser.setLastName("User");
        userUser.setEmail("user@localhost");
        userUser.setActivated(true);
        userUser.setLangKey("en");
        userUser.setCreatedBy(systemUser.getLogin());
        userUser.setCreatedDate(Instant.now());
        userUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(userUser);

        User employerUser = new User();
        employerUser.setId("user-4");
        employerUser.setLogin("manager");
        employerUser.setPassword("$2a$10$HQ6xWTISYS/Rdbq8vS5lKOE90F63d40OaivlpJ.rnIKwJ8gXdHjm6");
        employerUser.setFirstName("");
        employerUser.setLastName("Manager");
        employerUser.setEmail("manager@localhost");
        employerUser.setActivated(true);
        employerUser.setLangKey("fr");
        employerUser.setCreatedBy(systemUser.getLogin());
        employerUser.setCreatedDate(Instant.now());
        employerUser.getAuthorities().add(userAuthority);
        employerUser.getAuthorities().add(managerAuthority);
        mongoTemplate.save(employerUser);
    }
}
