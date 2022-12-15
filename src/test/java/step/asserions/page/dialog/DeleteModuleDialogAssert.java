package step.asserions.page.dialog;

import page.modal.DeleteModuleDialog;
import page.module.AllModulesPage;
import step.asserions.page.AbstractDialogAssert;
import step.page.module.AllModulesPageStep;

import static com.codeborne.selenide.Selenide.page;

public class DeleteModuleDialogAssert extends AbstractDialogAssert<DeleteModuleDialogAssert, DeleteModuleDialog> {
    public DeleteModuleDialogAssert(DeleteModuleDialog dialog) {
        super(dialog, DeleteModuleDialogAssert.class);
    }

    // -- BDD --
    public AllModulesPageStep and() {
        return new AllModulesPageStep(page(AllModulesPage.class));
    }

}
