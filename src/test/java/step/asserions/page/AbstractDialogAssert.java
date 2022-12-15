package step.asserions.page;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.CheckReturnValue;
import page.common.Popup;

import static com.codeborne.selenide.Selenide.$;


public class AbstractDialogAssert<SELF extends AbstractDialogAssert<SELF, DIALOG>, DIALOG extends Popup>
        extends AbstractObjectAssert<SELF, DIALOG> {

    public AbstractDialogAssert(DIALOG DIALOG, Class<?> selfType) {
        super(DIALOG, selfType);
    }

    private <P extends DIALOG> AbstractDialogAssert(P actual) {
        super(actual, AbstractDialogAssert.class);
    }

    @CheckReturnValue
    public static <P extends Popup> AbstractDialogAssert assertThat(P actual) {
        return new AbstractDialogAssert(actual);
    }

    public SELF dialogIsClosed() {
        if ($(actual.getHeader()).exists()) {
            throw new AssertionError("On product page dialog must be closed");
        }
        return myself;
    }
}
