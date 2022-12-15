package step.page.module;

import lombok.AllArgsConstructor;
import page.module.AllModulesPage;
import step.asserions.page.PageAssertions;
import step.asserions.page.module.AllModulesPageAssert;

import static com.codeborne.selenide.Selenide.$;

@AllArgsConstructor
public class AllModulesPageStep {
    private AllModulesPage allModulesPage;

    public AllModulesPageStep clickBtnCreateNewModule() {
        $(allModulesPage.getBtn_createNewModule()).click();
        return this;
    }

    public AllModulesPageStep clickButtonRenameModule(String moduleName) {
        return clickModuleAction(moduleName, "Rename");
    }

    public AllModulesPageStep clickButtonDeleteModule(String moduleName) {
        return clickModuleAction(moduleName, "Delete");
    }

    // -- BDD --
    public AllModulesPageAssert then() {
        return PageAssertions.assertThat(allModulesPage);
    }

    public AllModulesPageStep when() {
        return this;
    }

    private AllModulesPageStep clickModuleAction(String moduleName, String action) {
        allModulesPage.getModuleActionButton(moduleName).click();
        $(allModulesPage.getButton(action)).click();
        return this;
    }
}
