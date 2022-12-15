package step.asserions.page.module;

import com.codeborne.selenide.Selenide;
import org.assertj.core.error.ShouldBeSame;
import page.module.AllModulesPage;
import page.module.ModulePage;
import step.asserions.page.AbstractPageAssert;
import step.page.BDD;
import step.page.module.ModulePageStep;

import static com.codeborne.selenide.Selenide.$;

public class ModulePageAssert extends AbstractPageAssert<ModulePageAssert, ModulePage> {
    public ModulePageAssert(ModulePage actual) {
        super(actual, ModulePageAssert.class);
    }

    public ModulePageAssert hasModuleName(String moduleName) {
        isNotNull();
        String actualName = $(actual.getTxt_moduleName()).text();
        if (!actualName.equals(moduleName)) {
            throwAssertionError(ShouldBeSame.shouldBeSame(actualName, moduleName));
        }
        return myself;
    }

    public AllModulesPageAssert presentedAllModulesPage() {
        return BDD.when(Selenide.page(AllModulesPage.class))
                .then()
                .isValid();
    }

    public ModulePageAssert presentedModulePage() {
        return isValid();
    }

    // -- BDD --

    public ModulePageStep when() {
        return new ModulePageStep(actual);
    }

    public ModulePageAssert that() {
        return this;
    }
}
