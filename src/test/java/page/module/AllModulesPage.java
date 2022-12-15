package page.module;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.common.Page;
import page.common.SelfValidatable;
import xpath.Button;
import xpath.Element;
import xpath.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

@Getter
public class AllModulesPage implements SelfValidatable, Page {
    private final By btn_createNewModule = Button.name("New module");
    private final By btn_loadFromFile = Button.name("Download from file...");
    private final By txt_allModulesHeader = Header.h3("All modules");

    private final By tbl_allModules = Element.classNameContains("Modules_Table_container__");

    @Override
    public void validate() throws AssertionError {
        assertThat($(btn_createNewModule).exists()).as("button \"New module\" exists").isTrue();
        assertThat($(btn_loadFromFile).exists()).as("button \"Download from file\" exists").isTrue();
        assertThat($(txt_allModulesHeader).exists()).as("form \"All modules\" exists").isTrue();
    }

    public List<ModuleRow> getModuleList() {
        List<WebElement> elements = $(tbl_allModules)
                .findElement(By.xpath(".//tbody"))
                .findElements(By.className("MuiTableRow-root"));
        return elements.stream()
                .map(ModuleRow::from)
                .collect(Collectors.toList());
    }

    public ModuleRow getModule(Predicate<ModuleRow> moduleRowPredicate) {
        return getModuleList().stream()
                .filter(moduleRowPredicate)
                .findFirst()
                .orElseThrow(() -> new AssertionError("module not found on page!"));
    }

    public WebElement getModuleActionButton(String moduleName) {
        return $(tbl_allModules)
                .findElement(By.xpath("//tbody/tr/td[position()=1 and contains(.,'" + moduleName + "')]/following-sibling::td[position()=4]"));
    }

    @Wither
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class ModuleRow {
        String moduleName;
        String status;
        LocalDateTime creationDate;
        String author;

        static ModuleRow from(WebElement webElement) {
            String DATE_TIME_PATTERN = "M/dd/yyyy, h:mm:ss a";
            List<WebElement> elements = webElement.findElements(By.xpath(".//a"));
            return new ModuleRow()
                    .withModuleName(elements.get(0).getText())
                    .withStatus(elements.get(1).getText())
                    .withCreationDate(LocalDateTime.parse(elements.get(2).getText(), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                    .withAuthor(elements.get(3).getText());
        }

    }

}
