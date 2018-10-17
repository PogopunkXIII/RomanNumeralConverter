
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

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
    public void test41() {
        int output = converterProg.r2i("XLI");

        assertEquals(41, output);
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

    @Test(expected = InvalidLetterException.class)
    public void InvalidGibberish() {
        int output = converterProg.r2i("oliu2y3ojhsadoif8723i4uhasjdhfASDFas'dujklrghwer@#");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadI() {
        int output = converterProg.r2i("IIII");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadV() {
        int output = converterProg.r2i("VVVV");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadX() {
        int output = converterProg.r2i("XXXX");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadL() {
        int output = converterProg.r2i("LLLL");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadC() {
        int output = converterProg.r2i("CCCC");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadD() {
        int output = converterProg.r2i("DDDD");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatQuadM() {
        int output = converterProg.r2i("MMMM");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatSixMs() {
        int output = converterProg.r2i("MMMMMM");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrementingIV() {
        int output = converterProg.r2i("IIIV");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrementingIV() {
        int output = converterProg.r2i("IVII");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrementingIX() { int output = converterProg.r2i("IIIX"); }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrementingIX() {
        int output = converterProg.r2i("IXII");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrementingXL() {
        int output = converterProg.r2i("XXXL");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrementingXL() {
        int output = converterProg.r2i("XLXX");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrementingXD() {
        int output = converterProg.r2i("XXXD");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrementingXD() {
        int output = converterProg.r2i("XDXX");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrementingCD() {
        int output = converterProg.r2i("CCCD");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrementingCD() {
        int output = converterProg.r2i("CDCC");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatFollowingDecrementingCM() {
        int output = converterProg.r2i("CCCM");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatLeadingDecrementingCM() {
        int output = converterProg.r2i("CMCC");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementorIL() {
        int output = converterProg.r2i("IL");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementorIC() {
        int output = converterProg.r2i("IC");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementorID() {
        int output = converterProg.r2i("ID");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementorIM() {
        int output = converterProg.r2i("IM");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementorXD() {
        int output = converterProg.r2i("XD");
    }

    @Test(expected = InvalidFormatException.class)
    public void invalidFormatWrongDecrementorXM() {
        int output = converterProg.r2i("XM");
    }

    @Test
    public void masterFunctionalTest() {
        Vector<String> allRomans1To3999 = generateAllRomans();

        for(int i = 1; i <= 3999; i++) {
            //System.out.println( "Testing roman: " + allRomans1To3999.get(i - 1) + " vs " + i);
            assertEquals(i, converterProg.r2i(allRomans1To3999.get(i-1)));
        }
    }

    private Vector<String> generateAllRomans() {
        Vector<String> output = new Vector<>();

        for(int i = 1; i <= 3999; i++) {
            output.add(generateRomanNumeral(i));
        }

        return output;
    }

    private String generateRomanNumeral(int i) {
        StringBuilder output = new StringBuilder();

        while(i > 0) {
            if((i - 1000) >= 0) {
                output.append("M");
                i = i - 1000;
            } else if((i - 900) >= 0) {
                output.append("CM");
                i = i - 900;
            } else if((i - 500) >= 0) {
                output.append("D");
                i = i - 500;
            } else if((i - 400) >= 0) {
                output.append("CD");
                i = i - 400;
            } else if((i - 100) >= 0) {
                output.append("C");
                i = i - 100;
            } else if((i - 90) >= 0) {
                output.append("XC");
                i = i - 90;
            } else if((i - 50) >= 0) {
                output.append("L");
                i = i - 50;
            } else if((i - 40) >= 0) {
                output.append("XL");
                i = i - 40;
            } else if((i - 10) >= 0) {
                output.append("X");
                i = i - 10;
            } else if((i - 9) >= 0) {
                output.append("IX");
                i = i - 9;
            } else if((i - 5) >= 0) {
                output.append("V");
                i = i - 5;
            } else if((i - 4) >= 0) {
                output.append("IV");
                i = i - 4;
            } else if((i - 1) >= 0) {
                output.append("I");
                i = i - 1;
            }
        }

        return output.toString();
    }
}
