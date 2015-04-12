package model.level;

import com.opencsv.CSVReader;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Lauri on 12.4.2015.
 */
public class Bounds extends Polygon {
    /**
     * Loads a bounds object from a CSV file. The file must have bound points on separate lines of two coordinates, for
     * example:
     *
     * <PRE>
     *     100, 100
     *     100, 300
     *     300, 300
     *     300, 100
     * </PRE>
     *
     * @param filename name of the CSV file
     * @throws IOException if no file is found or can't be read
     */
    public static Bounds load(String filename) throws IOException {
        try(CSVReader reader = new CSVReader(new FileReader(filename))) {
            Bounds bounds = new Bounds();
            for (String[] line : reader.readAll()) {
                bounds.addPoint(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            }
            return bounds;
        }
    }
}
