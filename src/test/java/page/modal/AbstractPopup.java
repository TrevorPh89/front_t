package page.modal;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import page.common.Popup;
import xpath.Button;
import xpath.Dialog;


@AllArgsConstructor
public abstract class AbstractPopup implements Popup {
    String header, cancelText, confirmText;

    @Override
    public By getHeader() {
        return Dialog.header(header);
    }

    public By getBtnClose() {
        return Button.name(cancelText);
    }

    public By getBtnConfirm() {
        return Button.name(confirmText);
    }

}
