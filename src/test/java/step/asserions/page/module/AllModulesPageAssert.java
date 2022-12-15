package step.asserions.page.module;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.error.ShouldBe;
import org.assertj.core.error.ShouldContain;
import org.assertj.core.error.ShouldNotContain;
import page.modal.CreateModuleDialog;
import page.modal.DeleteModuleDialog;
import page.modal.RenameModuleDialog;
import page.module.AllModulesPage;
import page.module.AllModulesPage.ModuleRow;
import step.asserions.page.AbstractPageAssert;
import step.page.module.AllModulesPageStep;
import step.page.module.CreateModuleDialogStep;
import step.page.module.DeleteModuleDialogStep;
import step.page.module.RenameModuleDialogStep;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static java.util.Comparator.comparing;

public class AllModulesPageAssert extends AbstractPageAssert<AllModulesPageAssert, AllModulesPage> {
    public AllModulesPageAssert(AllModulesPage actual) {
        super(actual, AllModulesPageAssert.class);
    }

    public CreateModuleDialogStep isCoveredByCreateNewModuleDialog() {
        if (!$(page(CreateModuleDialog.class).getHeader()).exists()) {
            throwAssertionError(ShouldBe.shouldBe("Module page", new Condition<>("be covered by dialog \"create new module\"")));
        }
        return new CreateModuleDialogStep(page(CreateModuleDialog.class));
    }

    public AllModulesPageAssert moduleListContainsModule(String moduleName) {
        List<ModuleRow> moduleList = actual.getModuleList();
        if (moduleList.stream().noneMatch(moduleRow -> moduleRow.getModuleName().equals(moduleName))) {
            throwAssertionError(ShouldContain.shouldContain(moduleList, moduleName, moduleName));
        }
        return myself;
    }

    public AllModulesPageAssert modulesSortedByCreationDate() {
        List<ModuleRow> moduleList = actual.getModuleList();
        Assertions.assertThat(moduleList)
                .isSortedAccordingTo(comparing(ModuleRow::getCreationDate).reversed());
        return myself;
    }

    public RenameModuleDialogStep isCoveredByRenameNewModuleDialog() {
        if (!$(page(CreateModuleDialog.class).getHeader()).exists()) {
            throwAssertionError(ShouldBe.shouldBe("Module page", new Condition<>("be covered by dialog \"rename module\"")));
        }
        return new RenameModuleDialogStep(page(RenameModuleDialog.class));
    }

    public DeleteModuleDialogStep isCoveredByDeleteModuleDialog() {
        if (!$(page(DeleteModuleDialog.class).getHeader()).exists()) {
            throwAssertionError(ShouldBe.shouldBe("Module page", new Condition<>("be covered by dialog \"delete module\"")));
        }
        return new DeleteModuleDialogStep(page(DeleteModuleDialog.class));
    }

    public AllModulesPageAssert moduleListDoesNotContainsModule(String moduleName) {
        List<ModuleRow> moduleList = actual.getModuleList();
        if (moduleList.stream().anyMatch(moduleRow -> moduleRow.getModuleName().equals(moduleName))) {
            throwAssertionError(ShouldNotContain.shouldNotContain(moduleList, moduleName, moduleName));
        }
        return myself;
    }

    // -- BDD --
    public AllModulesPageStep and() {
        return new AllModulesPageStep(actual);
    }

    public AllModulesPageAssert that() {
        return this;
    }

    public AllModulesPageStep when() {
        return and();
    }

}
