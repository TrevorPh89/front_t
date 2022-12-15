package step.page.module;

import lombok.AllArgsConstructor;
import page.modal.CreateModuleDialog;
import step.asserions.page.dialog.CreateModuleDialogAssert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static step.asserions.page.PageAssertions.assertThat;

@AllArgsConstructor
public class CreateModuleDialogStep {
    private CreateModuleDialog createModuleDialog;

    public CreateModuleDialogStep fillNewModuleName(String moduleName) {
        $(createModuleDialog.getInput()).clear();
        $(createModuleDialog.getInput()).sendKeys(moduleName);
        return this;
    }

    public CreateModuleDialogStep pressBtnCreate() {
        $(createModuleDialog.getBtnConfirm()).click();
        return waitUntilDialogClosed();
    }

    // -- BDD --
    public CreateModuleDialogStep when() {
        return this;
    }

    public CreateModuleDialogAssert then() {
        return assertThat(createModuleDialog);
    }

    private CreateModuleDialogStep waitUntilDialogClosed() {
        try {
            $(createModuleDialog.getHeader()).waitUntil(exist.negate(), 2000);
        } catch (Throwable ignore) {}
        return this;
    }
}
