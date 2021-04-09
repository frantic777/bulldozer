package com.oracle.bulldozer.services;

import com.oracle.bulldozer.domain.LandType;
import com.oracle.bulldozer.domain.Map;
import com.oracle.bulldozer.domain.exceptions.IncorrectMapException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MapReader {
    public Map readMap(BufferedReader reader) throws IOException {
        List<LandType[]> rows = new ArrayList<>();
        int rowWidth = 0;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            char[] chars = line.toCharArray();
            if (rowWidth == 0) {
                rowWidth = chars.length;
            } else if (rowWidth != chars.length) {
                throw new IncorrectMapException("Number of columns should be equal in every row");
            }
            LandType[] row = new LandType[rowWidth];
            for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
                char symbol = chars[i];
                if (Character.isAlphabetic(symbol)) {
                    LandType landType = LandType.fromChar(symbol);
                    row[i] = landType;
                }
            }
            rows.add(row);
        }
        return new Map(rows.toArray(new LandType[][]{}));
    }
}
