import { browser, element, by } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';

describe('Employee e2e test', () => {

    let navBarPage: NavBarPage;
    let employeeDialogPage: EmployeeDialogPage;
    let employeeComponentsPage: EmployeeComponentsPage;

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Employees', () => {
        navBarPage.goToEntity('employee');
        employeeComponentsPage = new EmployeeComponentsPage();
        expect(employeeComponentsPage.getTitle())
            .toMatch(/craApp.employee.home.title/);

    });

    it('should load create Employee dialog', () => {
        employeeComponentsPage.clickOnCreateButton();
        employeeDialogPage = new EmployeeDialogPage();
        expect(employeeDialogPage.getModalTitle())
            .toMatch(/craApp.employee.home.createOrEditLabel/);
        employeeDialogPage.close();
    });

    it('should create and save Employees', () => {
        employeeComponentsPage.clickOnCreateButton();
        employeeDialogPage.setCodeInput('code');
        expect(employeeDialogPage.getCodeInput()).toMatch('code');
        employeeDialogPage.save();
        expect(employeeDialogPage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class EmployeeComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('zs-employee div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class EmployeeDialogPage {
    modalTitle = element(by.css('h4#myEmployeeLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    codeInput = element(by.css('input#field_code'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setCodeInput = function(code) {
        this.codeInput.sendKeys(code);
    };

    getCodeInput = function() {
        return this.codeInput.getAttribute('value');
    };

    save() {
        this.saveButton.click();
    }

    close() {
        this.closeButton.click();
    }

    getSaveButton() {
        return this.saveButton;
    }
}
