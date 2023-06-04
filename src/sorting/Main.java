package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArgumentParser argParser = new ArgumentParser();
        UserInterface ui = new UserInterface();

        argParser.parseArgumentsIntoMap(args);

        argParser.parseDataType();
        DataType dataType = argParser.getDataType();

        argParser.parseSortingType();
        SortingType sortingType = argParser.getSortingType();

        argParser.parseInputFile();
        File inputFile = argParser.getInputFile();

        argParser.parseOutputFile();
        File outputFile = argParser.getOutputFile();

        ArrayList<?> data;
        ArrayList<?> sortedData;

        if (inputFile == null) {
            data = DataProcessor.readDataIntoArray(scanner, dataType);
        } else {
            try (Scanner fileScanner = new Scanner(inputFile)) {
                data = DataProcessor.readDataIntoArray(fileScanner, dataType);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }

        switch (dataType) {
            case NUMBER, LONG -> {
                ArrayList<Integer> numbers = (ArrayList<Integer>) data;
                sortedData = DataProcessor.sortNumberData(numbers, sortingType);
                ui.outputSortedNumberData((ArrayList<Integer>) sortedData, sortingType, outputFile);
            }
            case LINE -> {
                ArrayList<String> lines = (ArrayList<String>) data;
                sortedData = DataProcessor.sortStringData(lines, sortingType);
                ui.outputSortedLineData((ArrayList<String>) sortedData, sortingType, outputFile);
            }
            case WORD -> {
                ArrayList<String> words = (ArrayList<String>) data;
                sortedData = DataProcessor.sortStringData(words, sortingType);
                ui.outputSortedWordData((ArrayList<String>) sortedData, sortingType, outputFile);
            }
        }
    }
}
