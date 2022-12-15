package step.page.module;

import lombok.AllArgsConstructor;
import page.module.ModulePage;
import step.asserions.page.PageAssertions;
import step.asserions.page.module.ModulePageAssert;

import static com.codeborne.selenide.Selenide.$;

@AllArgsConstructor
public class ModulePageStep {
    private ModulePage modulePage;

    public ModulePageStep clickLogo() {
        $(modulePage.getImg_logo()).click();
        return this;
    }

    // -- BDD --

    public ModulePageStep when() {
        return this;
    }

    public ModulePageAssert then() {
        return PageAssertions.assertThat(modulePage);
    }
}
