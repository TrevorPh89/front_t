package step.asserions.page.dialog;

import page.modal.RenameModuleDialog;
import page.module.AllModulesPage;
import step.asserions.page.AbstractDialogAssert;
import step.asserions.page.module.AllModulesPageAssert;

import static com.codeborne.selenide.Selenide.page;

public class RenameModuleDialogAssert extends AbstractDialogAssert<RenameModuleDialogAssert, RenameModuleDialog> {
    public RenameModuleDialogAssert(RenameModuleDialog dialog) {
        super(dialog, RenameModuleDialogAssert.class);
    }

    // -- BDD --
    public AllModulesPageAssert and() {
        return new AllModulesPageAssert(page(AllModulesPage.class));
    }

}
