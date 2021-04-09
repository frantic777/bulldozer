package com.oracle.bulldozer.domain;

public enum LandType {
    PlainLand('o'), RockyGround('r'), Tree('t'), PreservedTree('T');

    private final char symbol;

    LandType(char t) {
        this.symbol = t;
    }

    public static LandType fromChar(char ch) {
        for (LandType value : LandType.values()) {
            if (value.getSymbol() == ch)
                return value;
        }
        throw new IllegalArgumentException(String.format("Character '%c' does not represent correct land type", ch));
    }

    public char getSymbol() {
        return symbol;
    }
}
