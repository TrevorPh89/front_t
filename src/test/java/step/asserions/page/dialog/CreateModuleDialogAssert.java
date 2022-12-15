package step.asserions.page.dialog;

import page.modal.CreateModuleDialog;
import page.module.ModulePage;
import step.asserions.page.AbstractDialogAssert;
import step.page.BDD;
import step.page.module.ModulePageStep;

import static com.codeborne.selenide.Selenide.page;

public class CreateModuleDialogAssert extends AbstractDialogAssert<CreateModuleDialogAssert, CreateModuleDialog> {
    public CreateModuleDialogAssert(CreateModuleDialog dialog) {
        super(dialog, CreateModuleDialogAssert.class);
    }


    public ModulePageStep and() {
        return BDD.when(page(ModulePage.class));
    }

}
