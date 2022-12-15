package page.common;

import org.openqa.selenium.By;
import xpath.Button;

public interface Page {
    default By getButton(String name) {
        return Button.name(name);
    }
}
