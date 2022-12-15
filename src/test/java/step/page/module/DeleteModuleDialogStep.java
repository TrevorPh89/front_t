package step.page.module;

import lombok.AllArgsConstructor;
import page.modal.DeleteModuleDialog;
import step.asserions.page.dialog.DeleteModuleDialogAssert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static step.asserions.page.PageAssertions.assertThat;

@AllArgsConstructor
public class DeleteModuleDialogStep {
    private DeleteModuleDialog deleteModuleDialog;

    public DeleteModuleDialogStep pressBtnDelete() {
        $(deleteModuleDialog.getBtnConfirm()).click();
        return waitUntilDialogClosed();
    }

    // -- BDD --
    public DeleteModuleDialogStep when() { return this; }

    public DeleteModuleDialogAssert then() {
        return assertThat(deleteModuleDialog);
    }

    private DeleteModuleDialogStep waitUntilDialogClosed() {
        try {
            $(deleteModuleDialog.getHeader()).waitUntil(exist.negate(), 2000);
        } catch (Throwable ignore) {}
        return this;
    }
}
