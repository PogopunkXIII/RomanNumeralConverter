import java.util.Stack;

public class Program {
    int r2i(String roman) {


        String normalizedRoman = normalizeInput(roman);

        if (normalizedRoman.isEmpty()) { return 0; }

        //parse the input string into a stack of enum types
        Stack<RomanDigit> romanStack = createStack(normalizedRoman);

        //prepare for parsing the input into an integer
        int output = 0;
        int letterCount = 1;
        int modifier = 0;
        int maxNumberOfConsecutiveLetters = 1;
        RomanDigit currentDigit = null;
        RomanDigit lastDigit = null;
        RomanDigit lastDecrementingDigit = null;

        //loop while we're not done parsing all of the stack
        while(!romanStack.isEmpty()) {
            //pop the top digit
            currentDigit = romanStack.pop();

            maxNumberOfConsecutiveLetters = setMaxLetterCount(currentDigit);

            //if the last decrementing digit is the same as the current digit that means there's a formatting problem
            if(lastDecrementingDigit == currentDigit) {
                throw new InvalidFormatException("a decrementing digit was also used a normal digit");
            }

            //if there's more than 1 item left:
            //determine if we're trying to decrement the next digit, or if we're handling this digit on it's own
            if(romanStack.size() >= 1) {modifier = decrementingValue(currentDigit, romanStack.peek());}


            //if we're doing a decremental modification...
            if(modifier != 0) {

                //and the decrementing digit is the same as the last digit parsed normally then it's a formatting error
                if(lastDigit == currentDigit) {
                    throw new InvalidFormatException("a decrementing digit was also used as a normal digit");
                }
                //otherwise we just need to track the digit doing the decrementing for error checking purposes
                else {
                    lastDecrementingDigit = currentDigit;
                    currentDigit = romanStack.pop();
                }
            }
            //otherwise we just need to make sure we're keeping track of how many of the same digit we're seeing
            else if(lastDigit == currentDigit) {
                letterCount++;
            }
            //otherwise we're resetting the digit count
            else {
                letterCount = 1;
            }

            //check to make sure we're not just getting a ton of the same letter, there should only ever be 3 in a row
            if(letterCount >= maxNumberOfConsecutiveLetters) {
                throw new InvalidFormatException("Too Many of the same letter in this roman numeral");
            }

            //add the digit to the output value, taking the modifier into account
            output += currentDigit.getValue() - modifier;

            //set the current digit to the last digit
            lastDigit = currentDigit;
            modifier = 0;
        }

        return output;
    }

    private String normalizeInput(String rawRoman) {
        String output = rawRoman.replaceAll("\\s", "");

        return(output.toUpperCase());
    }

    private Stack<RomanDigit> createStack(String in) {
        Stack<RomanDigit> output = new Stack<RomanDigit>();

        int lastIndex = in.length() - 1;
        RomanDigit digit;

        for(int i = lastIndex; i >= 0; i--){

            switch(in.charAt(i)){
                case 'I':
                    digit = RomanDigit.I;
                    break;
                case 'V':
                    digit = RomanDigit.V;
                    break;
                case 'X':
                    digit = RomanDigit.X;
                    break;
                case 'L':
                    digit = RomanDigit.L;
                    break;
                case 'C':
                    digit = RomanDigit.C;
                    break;
                case 'D':
                    digit = RomanDigit.D;
                    break;
                case 'M':
                    digit = RomanDigit.M;
                    break;
                default:
                    throw new InvalidLetterException(in.charAt(i) + " is not a valid roman numeral character");
            }

            output.push(digit);
        }

        return output;
    }

    private int decrementingValue(RomanDigit current, RomanDigit next) {
        int digitOffset = current.ordinal() - next.ordinal();
        int output = 0;

        //if the next item we're getting is larger than the current
        if(digitOffset >= -2 && digitOffset < 0)
        {
            switch(current) {
                case I:
                case X:
                case C:
                    output = current.getValue();
                    break;
                default:
                    throw new InvalidFormatException(current.toString() + " Is not a valid decrementing digit.");
            }
        }
        //otherwise if the next digit is the same, or larger than the next digit we're not decrementing the value
        else if((current.ordinal() - next.ordinal()) >= 0) {
            output = 0;
        }
        //otherwise something is really weird, like the decrementing digit doesn't make sense
        else {
            throw new InvalidFormatException(current.toString() + " is not a proper decrementing digit for " + next.toString());
        }

        return output;
    }

    private int setMaxLetterCount(RomanDigit digit) {
        int output = 0;

        switch (digit) {
            case I:
            case X:
            case C:
            case M:
                output = 4;
                break;
            case V:
            case L:
            case D:
                output = 2;
                break;
        }

        return output;
    }
}
