package hu.gvasko.stringtable;

import hu.gvasko.testutils.categories.UnitTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.function.UnaryOperator;

/**
 * Created by gvasko on 2015.05.07..
 */
@Category(UnitTest.class)
public class KeepIntegerOnlyTest {

    private UnaryOperator<String> op;

    @Before
    public void setUp() {
        op = DefaultFactory.getInstance().keepIntegersOnly();
    }

    @Test
    public void integerRemains() {
        Assert.assertEquals("1234", op.apply("1234"));
    }

    @Test
    public void integerWithSpacesAround() {
        Assert.assertEquals("1234", op.apply("  1234  "));
    }

    @Test
    public void integerWithSpacesInside() {
        Assert.assertEquals("1234", op.apply("12  34"));
    }

    @Test
    public void containsLetters() {
        Assert.assertEquals("1234", op.apply("12Az34"));
    }

    @Test
    public void lettersAround() {
        Assert.assertEquals("1234", op.apply("A1234Z"));
    }

    @Test
    public void nonAlphaAround() {
        Assert.assertEquals("1234", op.apply("++1234**"));
    }

}
