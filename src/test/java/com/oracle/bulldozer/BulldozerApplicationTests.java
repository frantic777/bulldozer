package com.oracle.bulldozer;

import com.oracle.bulldozer.domain.LandType;
import com.oracle.bulldozer.domain.Map;
import com.oracle.bulldozer.domain.exceptions.IncorrectMapException;
import com.oracle.bulldozer.services.MapReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BulldozerApplicationTests {
    @Test
    @DisplayName("Test loading correct map")
    void testLoadCorrectMap(@Autowired MapReader mapReader) throws IOException {
        InputStream input = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("TestMap1.txt"));
        Map map = mapReader.readMap(new BufferedReader(new InputStreamReader(input)));
        //Make sure the map size is correct
        assertEquals(5, map.getHeight());
        assertEquals(10, map.getWidth());
        //Check random squares
        assertEquals(LandType.PlainLand, map.getLandType(0, 0));
        assertEquals(LandType.PreservedTree, map.getLandType(7, 1));
        assertEquals(LandType.PlainLand, map.getLandType(9, 4));
        assertEquals(LandType.RockyGround, map.getLandType(1, 3));
    }

    @Test
    @DisplayName("Test loading map with incorrect row width")
    void testLoadMapIncorrectRowWidth(@Autowired MapReader mapReader) {
        assertThrows(IncorrectMapException.class, () -> {
            InputStream input = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("TestMapIncorrectWidth.txt"));
            mapReader.readMap(new BufferedReader(new InputStreamReader(input)));
        });
    }
}
