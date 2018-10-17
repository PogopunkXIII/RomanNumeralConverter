
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanConverterTests {
    private Program converterProg;

    @Before
    public void setUp() {
        this.converterProg = new Program();
    }

    @Test
    public void test1() {
        int output = converterProg.r2i("I");

        assertEquals(1, output);
    }

    @Test
    public void test5() {
        int output = converterProg.r2i("V");

        assertEquals(5, output);
    }

    @Test
    public void test10() {
        int output = converterProg.r2i("X");

        assertEquals(10, output);
    }

    @Test
    public void test50() {
        int output = converterProg.r2i("L");

        assertEquals(50, output);
    }

    @Test
    public void test100() {
        int output = converterProg.r2i("C");

        assertEquals(100, output);
    }

    @Test
    public void test500() {
        int output = converterProg.r2i("D");

        assertEquals(500, output);
    }

    @Test
    public void test1000() {
        int output = converterProg.r2i("M");

        assertEquals(1000, output);
    }

    @Test
    public void test4() {
        int output = converterProg.r2i("IV");

        assertEquals(4, output);
    }

    @Test
    public void test9() {
        int output = converterProg.r2i("IX");

        assertEquals(9, output);
    }

    @Test
    public void test40() {
        int output = converterProg.r2i("XL");

        assertEquals(40, output);
    }

    @Test
    public void test90() {
        int output = converterProg.r2i("XC");

        assertEquals(90, output);
    }

    @Test
    public void test400() {
        int output = converterProg.r2i("CD");

        assertEquals(400, output);
    }

    @Test
    public void test900() {
        int output = converterProg.r2i("CM");

        assertEquals(900, output);
    }

    @Test
    public void test2() {
        int output = converterProg.r2i("II");

        assertEquals(2, output);
    }

    @Test
    public void test20() {
        int output = converterProg.r2i("XX");

        assertEquals(20, output);
    }

    @Test
    public void test200() {
        int output = converterProg.r2i("CC");

        assertEquals(200, output);
    }

    @Test
    public void test2000() {
        int output = converterProg.r2i("MM");

        assertEquals(2000, output);
    }

    @Test
    public void test6() {
        int output = converterProg.r2i("VI");

        assertEquals(6, output);
    }

    @Test
    public void test11() {
        int output = converterProg.r2i("XI");

        assertEquals(11, output);
    }

    @Test
    public void test15() {
        int output = converterProg.r2i("XV");

        assertEquals(15, output);
    }

    @Test
    public void test1234() {
        int output = converterProg.r2i("MCCXXXIV");

        assertEquals(1234, output);
    }

    @Test
    public void test1616() {
        int output = converterProg.r2i("MDCXVI");

        assertEquals(1616, output);
    }

    @Test
    public void test3999() {
        int output = converterProg.r2i("MMMCMXCIX");

        assertEquals(3999, output);
    }

    @Test
    public void test0() {
        int output = converterProg.r2i("");

        assertEquals(0, output);
    }

    @Test
    public void lowerCaseInput() {
        int output = converterProg.r2i("i");
        assertEquals(1, output);
        output = converterProg.r2i("iv");
        assertEquals(4, output);
        output = converterProg.r2i("v");
        assertEquals(5, output);
        output = converterProg.r2i("ix");
        assertEquals(9, output);
        output = converterProg.r2i("x");
        assertEquals(10, output);
        output = converterProg.r2i("xl");
        assertEquals(40, output);
        output = converterProg.r2i("l");
        assertEquals(50, output);
        output = converterProg.r2i("xc");
        assertEquals(90, output);
        output = converterProg.r2i("c");
        assertEquals(100, output);
        output = converterProg.r2i("cd");
        assertEquals(400, output);
        output = converterProg.r2i("d");
        assertEquals(500, output);
        output = converterProg.r2i("cm");
        assertEquals(900, output);
        output = converterProg.r2i("m");
        assertEquals(1000, output);
        output = converterProg.r2i("mmmcmxcix");
        assertEquals(3999, output);
        output = converterProg.r2i("mccxxxiv");
        assertEquals(1234, output);
    }

    @Test
    public void inputWithSpaces() {
        int output = converterProg.r2i("i");
        assertEquals(1, output);
        output = converterProg.r2i("i v");
        assertEquals(4, output);
        output = converterProg.r2i("v");
        assertEquals(5, output);
        output = converterProg.r2i("ix");
        assertEquals(9, output);
        output = converterProg.r2i("x");
        assertEquals(10, output);
        output = converterProg.r2i("x l");
        assertEquals(40, output);
        output = converterProg.r2i("l");
        assertEquals(50, output);
        output = converterProg.r2i("xc");
        assertEquals(90, output);
        output = converterProg.r2i("c");
        assertEquals(100, output);
        output = converterProg.r2i("cd");
        assertEquals(400, output);
        output = converterProg.r2i("d");
        assertEquals(500, output);
        output = converterProg.r2i("cm");
        assertEquals(900, output);
        output = converterProg.r2i("m");
        assertEquals(1000, output);
        output = converterProg.r2i("mmm cmxci x");
        assertEquals(3999, output);
        output = converterProg.r2i("mccx xxiv      ");
        assertEquals(1234, output);
        output = converterProg.r2i(" ");
        assertEquals(0, output);
        output = converterProg.r2i("   ");
        assertEquals(0, output);
        output = converterProg.r2i("    ");
        assertEquals(0, output);
    }

    @Test(expected = InvalidLetterException.class)
    public void InvalidLetter() {
        int output = converterProg.r2i("A");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrement() {
        int output = converterProg.r2i("XXXL");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrement() {
        int output = converterProg.r2i("XLXX");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuads() {
        int output = converterProg.r2i("XXXX");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementor() {
        int output = converterProg.r2i("XM");
    }


}
