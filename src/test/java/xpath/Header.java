package xpath;

import org.openqa.selenium.By;

public class Header {
    private Header() { }

    public static By h3(String name) {
        return By.xpath("//h3[contains(.,'" + name + "')]");
    }
}
