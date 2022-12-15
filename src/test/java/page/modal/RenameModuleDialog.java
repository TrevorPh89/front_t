package page.modal;

import lombok.Getter;


@Getter
public class RenameModuleDialog extends AbstractDialog {
    public RenameModuleDialog() {
        super("Enter module name",
              "Module name",
              "Cancel",
              "Rename");
    }
}
