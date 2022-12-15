package step.page.module;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.Keys;
import page.modal.RenameModuleDialog;
import step.asserions.page.dialog.RenameModuleDialogAssert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.repeat;
import static step.asserions.page.PageAssertions.assertThat;

@AllArgsConstructor
public class RenameModuleDialogStep {
    private RenameModuleDialog renameModuleDialog;

    public RenameModuleDialogStep fillNewModuleName(String moduleName) {
        SelenideElement input = $(renameModuleDialog.getInput());
        String keys = repeat(Keys.BACK_SPACE.charAt(0), ofNullable(input.val()).orElse("").length());
        input.sendKeys(keys, moduleName);
        return this;
    }

    public RenameModuleDialogStep pressBtnRename() {
        $(renameModuleDialog.getBtnConfirm()).click();
        return waitUntilDialogClosed();
    }

    // -- BDD --
    public RenameModuleDialogStep when() {
        return this;
    }

    public RenameModuleDialogAssert then() {
        return assertThat(renameModuleDialog);
    }

    private RenameModuleDialogStep waitUntilDialogClosed() {
        try {
            $(renameModuleDialog.getHeader()).waitUntil(exist.negate(), 2000);
        } catch (Throwable ignore) {}
        return this;
    }
}
