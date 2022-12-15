package xpath;

import org.openqa.selenium.By;

public class Element {
    private Element() { }

    public static By classNameContains(String classname) {
        return By.xpath("//*[contains(@class,'" + classname + "')]");
    }
}
