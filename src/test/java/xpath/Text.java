package xpath;

import org.openqa.selenium.By;

public class Text {
    private Text() { }

    public static By span(String name) {
        return By.xpath("//span[contains(.,'" + name + "')]");
    }
}
