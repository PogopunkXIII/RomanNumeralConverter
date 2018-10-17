# RomanNumeralConverter
converting Roman Numerals to Integers

The Program.java class has a method called r2i(String roman) which converts a string representing a roman numeral to an integer. A rough overview of the algorithm as follows:

1. Normalize string input. Cut out whitespace, convert everything to upper.
2. Check if the string has anything in it, if not return 0.
3. Convert string into a stack of RomanDigits, an Enum value representing the roman digit values. the stack makes it simpler to work with the data, and the enum makes ordinal comparison easier for future work and error checking. This also serves as a change to parse the entire input string for non-viable characters.
4. Begin a loop processing the digits from highest order to smallest order
5. For every digit, check to make sure the last digit we used as a decrementing digit is not the same as the current to be processed for error checking ("XLXX" is an incorrect format, it should be represented as "LX")  
6. Check if the next digit is larger, if it is figure out how much we're decrementing the digit by and return that value. Also serves as a change to change for formatting discrepancies (you can't have a "VX" sequence nor a "IC" sequence of digits)
7. Check to see if we're doing a decremental modification and if the last digit parsed is the same as the decrementing digit, if so that's a formatting error("XXXL" is an incorrect format, should be represented by "LX"). Otherwise check if the digit we're parsing is the same as the last digit and keep a running tally of the same digit parsed for error checking (you can't have more than three of the same digit in a sequence "XXXX" should be represented as "XL", and "VV" should be represented as "X")
8. If we're modifying the next digit, we need save the decrementing digit (for error checking), and take the next digit for proper parsing.
9. Finally, take the digit, and the modifying value, and add it to a running total for the parsed roman numeral.
10. Repeat steps 4-9 for all roman numeral digits
11. Output the integer representation of the roman numeral.
