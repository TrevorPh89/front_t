package step.page;

import page.modal.CreateModuleDialog;
import page.module.AllModulesPage;
import page.module.ModulePage;
import step.page.module.AllModulesPageStep;
import step.page.module.CreateModuleDialogStep;
import step.page.module.ModulePageStep;

public class BDD {

    public static ModulePageStep when(ModulePage modulePage) {
        return new ModulePageStep(modulePage);
    }

    public static CreateModuleDialogStep when(CreateModuleDialog createModuleDialog) {
        return new CreateModuleDialogStep(createModuleDialog);
    }

    public static AllModulesPageStep when(AllModulesPage allModulesPage) {
        return new AllModulesPageStep(allModulesPage);
    }
}
