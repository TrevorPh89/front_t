package xpath;

import org.openqa.selenium.By;

public class Dialog {
    private Dialog() { }

    public static By header(String header) {
        return By.xpath("//div[@role='dialog']//h2[contains(.,'" + header + "')]");
    }
}
