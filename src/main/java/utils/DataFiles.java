package utils;

import lombok.Getter;

/**
 * Enum with data files names for each day
 */
@Getter
public enum DataFiles {

    DAY1("Day1File.txt"),
    DAY2("Day2File.txt"),
    DAY3("Day3File.txt");

    private final String fileName;

    DataFiles(String fileName){
        this.fileName = fileName;
    }


}
