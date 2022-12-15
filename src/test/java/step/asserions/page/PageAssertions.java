package step.asserions.page;

import page.modal.CreateModuleDialog;
import page.modal.DeleteModuleDialog;
import page.modal.RenameModuleDialog;
import page.module.AllModulesPage;
import page.module.ModulePage;
import step.asserions.page.dialog.CreateModuleDialogAssert;
import step.asserions.page.dialog.DeleteModuleDialogAssert;
import step.asserions.page.dialog.RenameModuleDialogAssert;
import step.asserions.page.module.AllModulesPageAssert;
import step.asserions.page.module.ModulePageAssert;

public class PageAssertions {

    public static AllModulesPageAssert assertThat(AllModulesPage actual) {
        return new AllModulesPageAssert(actual);
    }

    public static CreateModuleDialogAssert assertThat(CreateModuleDialog createModuleDialog) {
        return new CreateModuleDialogAssert(createModuleDialog);
    }

    public static RenameModuleDialogAssert assertThat(RenameModuleDialog renameModuleDialog) {
        return new RenameModuleDialogAssert(renameModuleDialog);
    }

    public static DeleteModuleDialogAssert assertThat(DeleteModuleDialog deleteModuleDialog) {
        return new DeleteModuleDialogAssert(deleteModuleDialog);
    }

    public static ModulePageAssert assertThat(ModulePage modulePage) {
        return new ModulePageAssert(modulePage);
    }

}
