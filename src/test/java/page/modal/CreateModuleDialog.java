package page.modal;

import lombok.Getter;


@Getter
public class CreateModuleDialog extends AbstractDialog {

    public CreateModuleDialog() {
        super("Enter module name",
              "Module name",
              "Cancel",
              "Create");
    }
}
