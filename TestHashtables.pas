PROGRAM TestHashtables;

TYPE
    IntToString = HASHTABLE [integer] OF string;
    CharToReal = HASHTABLE [char] OF real;
    BoolToInt = HASHTABLE [boolean] OF integer;

VAR
    table1 : HASHTABLE [integer] OF char;
    table2 : HASHTABLE [char] OF boolean;
    table3 : HASHTABLE [boolean] OF real;

BEGIN
END.