package page.modal;

import org.openqa.selenium.By;
import xpath.Input;


public abstract class AbstractDialog extends AbstractPopup {
    private String header, fieldPlaceholder, cancelText, confirmText;

    AbstractDialog(String header, String fieldPlaceholder, String cancelText, String confirmText) {
        super(header, cancelText, confirmText);
        this.fieldPlaceholder = fieldPlaceholder;
    }

    public By getInput() {
        return Input.placeholder(fieldPlaceholder);
    }
}
