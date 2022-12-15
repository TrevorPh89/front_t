package tests.modules;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import page.module.AllModulesPage;
import tests.AbstractTest;

import static com.codeborne.selenide.Selenide.page;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static step.page.BDD.when;

@Slf4j
public class Work_with_modules extends AbstractTest {
    @Test
    public void work_with_modules() {
        String moduleName = randomAlphabetic(10);
        String newModuleName = randomAlphabetic(10);

        when(page(AllModulesPage.class))
                .clickBtnCreateNewModule()
                .then()
                .isCoveredByCreateNewModuleDialog()

                .when()
                .fillNewModuleName(moduleName)
                .pressBtnCreate()
                .then()
                .dialogIsClosed()
                .and()
                .then()
                .presentedModulePage()
                .that().hasModuleName(moduleName)

                .when()
                .clickLogo()
                .then()
                .presentedAllModulesPage()
                .that().moduleListContainsModule(moduleName)
                .modulesSortedByCreationDate()

                .when()
                .clickButtonRenameModule(moduleName)
                .then()
                .isCoveredByRenameNewModuleDialog()

                .when()
                .fillNewModuleName(newModuleName)
                .pressBtnRename()
                .then()
                .dialogIsClosed()
                .and()
                .moduleListContainsModule(newModuleName)
                .moduleListDoesNotContainsModule(moduleName)

                .and().when()
                .clickButtonDeleteModule(newModuleName)
                .then()
                .isCoveredByDeleteModuleDialog()

                .when()
                .pressBtnDelete()
                .then()
                .dialogIsClosed()
                .and().then()
                .moduleListDoesNotContainsModule(newModuleName);
    }
}
