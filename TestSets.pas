PROGRAM TestSets;

TYPE
    digits = SET OF 0..9;
    letters = SET OF char;
    Color = (Red, Green, Blue, Black);
    ColorSet = SET OF Color;

    digits_wrong  = SET TUPLE;
    letters_wrong = SET char;
    reals_wrong   = SET OF real;
VAR
    smallNums: SET OF 1..100;
    namedDigits : digits;

    unnamedDigits : SET OF 1..5;
    flags : SET OF boolean;


BEGIN
END.
