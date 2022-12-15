package page.module;


import lombok.Getter;
import org.openqa.selenium.By;
import page.common.Page;
import page.common.SelfValidatable;
import xpath.Element;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

@Getter
public class ModulePage implements SelfValidatable, Page {
    private final By txt_moduleName = Element.classNameContains("ModuleName_moduleName__");
    private final By img_logo = Element.classNameContains("LogoLink_wrapper__");

    @Override
    public void validate() throws AssertionError {
        assertThat($(txt_moduleName).exists()).as("button \"New module\" exists").isTrue();
    }
}
