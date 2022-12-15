package xpath;

import org.openqa.selenium.By;

public class Input {
    private Input() { }

    public static By placeholder(String placeholder) {
        return By.xpath("//input[@placeholder='" + placeholder + "']");
    }
}
