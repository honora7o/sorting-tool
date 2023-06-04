package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataProcessor {

    public DataProcessor() {
    }

    public static <T> ArrayList<T> readDataIntoArray(Scanner scanner, DataType dataType) {
        ArrayList<T> data = new ArrayList<>();

        switch (dataType) {
            case NUMBER, LONG -> {
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        Integer number = scanner.nextInt();
                        data.add((T) number);
                    } else {
                        String nonNumericInput = scanner.next();
                        System.out.println("\"" + nonNumericInput + "\" is not a number. It will be skipped.");
                    }
                }
            }
            case WORD -> {
                while (scanner.hasNextLine()) {
                    String currLine = scanner.nextLine();

                    String[] lineSplitInWords = currLine.split("\\s+");
                    for (String word : lineSplitInWords) {
                        if (!word.isEmpty()) { // empty spaces do not count as words
                            data.add((T) word);
                        }
                    }
                }
            }
            case LINE -> {
                while (scanner.hasNextLine()) {
                    String currLine = scanner.nextLine();
                    data.add((T) currLine);
                }
            }
        }

        return data;
    }

    public static ArrayList<Integer> sortNumberData(ArrayList<Integer> numbers, SortingType sortingType) {
        ArrayList<Integer> sortedNumbers;

        if (sortingType == SortingType.NATURAL) {
            sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
        } else if (sortingType == SortingType.BY_COUNT) {
            sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            Collections.sort(sortedNumbers, (n1, n2) -> Collections.frequency(numbers, n1) - Collections.frequency(numbers, n2));
        } else {
            sortedNumbers = new ArrayList<>(numbers);
        }

        return sortedNumbers;
    }

    public static ArrayList<String> sortStringData(ArrayList<String> strings, SortingType sortingType) {
        ArrayList<String> sortedStrings;

        if (sortingType == SortingType.NATURAL) {
            sortedStrings = new ArrayList<>(strings);
            //sorts all lines from longest to shortest; sorts it alphabetically if same length
            Collections.sort(strings, (s1, s2) -> {
                int lengthComparison = Integer.compare(s2.length(), s1.length());
                if (lengthComparison == 0) {
                    return s1.compareTo(s2);
                }
                return lengthComparison;
            });

            return sortedStrings;
        } else if (sortingType == SortingType.BY_COUNT) {
            sortedStrings = new ArrayList<>(strings);
            //sorts list by ascending order
            Collections.sort(sortedStrings);
            //sorts list by frequency (count)
            Collections.sort(sortedStrings, (l1, l2)
                    -> Collections.frequency(strings, l1) - Collections.frequency(strings, l2));
            return sortedStrings;
        } else {
            sortedStrings = new ArrayList<>(strings);
        }

        return sortedStrings;
    }
}