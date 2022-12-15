package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.common.Page;
import page.module.AllModulesPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static step.asserions.page.AbstractPageAssert.assertThat;

public class AbstractTest {
    private Page page;

    @BeforeClass
    public void setUpConfig() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        baseUrl = "";
    }

    @BeforeMethod
    public void setUp() {
        page = open("modules", AllModulesPage.class);
        assertThat(getPage()).isValid();
    }

    public <P extends Page> P getPage() {
        return (P) page;
    }
}
