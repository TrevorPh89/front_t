package xpath;

import org.openqa.selenium.By;

public class Button {
    private Button() { }

    public static By name(String name) {
        return By.xpath("//button[contains(.,'" + name + "')]");
    }
}
