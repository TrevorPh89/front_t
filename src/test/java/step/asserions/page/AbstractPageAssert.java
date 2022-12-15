package step.asserions.page;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.CheckReturnValue;
import page.common.Page;
import page.common.SelfValidatable;


public class AbstractPageAssert<SELF extends AbstractPageAssert<SELF, PAGE>, PAGE extends Page>
        extends AbstractObjectAssert<SELF, PAGE> {

    public AbstractPageAssert(PAGE page, Class<?> selfType) {
        super(page, selfType);
    }

    private <P extends PAGE> AbstractPageAssert(P actual) {
        super(actual, AbstractPageAssert.class);
    }

    @CheckReturnValue
    public static <P extends Page> AbstractPageAssert assertThat(P actual) {
        return new AbstractPageAssert(actual);
    }

    public SELF isValid() {
        try {
            ((SelfValidatable) actual).validate();
        } catch (ClassCastException e) {
            throw new RuntimeException("tested object " + actual.getClass() + " is not implement SelfValidatablePage interface! Use other validations or implement it");
        }
        return myself;
    }
}
