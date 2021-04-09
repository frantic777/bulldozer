package com.oracle.bulldozer.domain;

public class Map {
    private final LandType[][] map;

    public Map(LandType[][] map) {
        this.map = map;
    }

    public LandType getLandType(int x, int y) {
        return map[y][x];
    }

    public int getWidth() {
        return map[0].length;
    }

    public int getHeight() {
        return map.length;
    }
}
