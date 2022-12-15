package page.modal;

import lombok.Getter;


@Getter
public class DeleteModuleDialog extends AbstractPopup {

    public DeleteModuleDialog() {
        super("Are you sure you want to delete Module?",
              "Cancel",
              "Delete");
    }
}
