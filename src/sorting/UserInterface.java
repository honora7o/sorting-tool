package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class UserInterface {

    public UserInterface() {}

    public void outputSortedNumberData(ArrayList<Integer> sortedNumbers , SortingType sortingType, File outputFile) {
        Integer numberCount = sortedNumbers.size();

        if (outputFile == null) {
            if (sortingType == SortingType.NATURAL) {
                System.out.println("Total numbers: " + numberCount + ".");

                System.out.print("Sorted data: ");
                sortedNumbers.stream().map(Object::toString).forEach(s -> System.out.print(s + " "));
            }

            if (sortingType == SortingType.BY_COUNT) {
                System.out.println("Total numbers: " + numberCount);

                long lastNumberPrinted = sortedNumbers.get(0) + 1; //this is dumb
                for (Integer number : sortedNumbers) {
                    int currNumberCount = Collections.frequency(sortedNumbers, number);

                    if (lastNumberPrinted != number) {
                        lastNumberPrinted = number;
                        System.out.println(number + ": " + currNumberCount + " time(s), "
                                + ((double) currNumberCount / numberCount * 100) + "%).");
                    }
                }
            }
        } else {
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                if (sortingType == SortingType.NATURAL) {
                    printWriter.println("Total numbers: " + numberCount + ".");
                    printWriter.print("Sorted data: ");
                    sortedNumbers.stream()
                            .map(Object::toString)
                            .forEach(number -> printWriter.print(number + " "));
                }

                if (sortingType == SortingType.BY_COUNT) {
                    printWriter.println("Total numbers: " + numberCount);

                    long lastNumberPrinted = sortedNumbers.get(0) + 1;
                    for (Integer number : sortedNumbers) {
                        int currNumberCount = Collections.frequency(sortedNumbers, number);

                        if (lastNumberPrinted != number) {
                            lastNumberPrinted = number;
                            printWriter.println(number + ": " + currNumberCount + " time(s), "
                                    + ((double) currNumberCount / numberCount * 100) + "%).");
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputSortedLineData(ArrayList<String> sortedStrings, SortingType sortingType, File outputFile) {
        int lineCount = sortedStrings.size();

        if (outputFile == null) {
            if (sortingType == SortingType.NATURAL) {
                System.out.println("Total lines: " + lineCount);
                sortedStrings.forEach(System.out::println);
            }

            if (sortingType == SortingType.BY_COUNT) {
                System.out.println("Total lines: " + lineCount);

                String lastLinePrinted = "";
                for (String line : sortedStrings) {
                    int currNumberCount = Collections.frequency(sortedStrings, line);

                    if (!lastLinePrinted.equals(line)) {
                        lastLinePrinted = line;
                        System.out.println(line + ": " + currNumberCount + " time(s), "
                                + ((double) currNumberCount / lineCount * 100) + "%).");
                    }
                }
            }
        } else {
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                if (sortingType == SortingType.NATURAL) {
                    printWriter.println("Total lines: " + lineCount);
                    sortedStrings.forEach(printWriter::println);
                }

                if (sortingType == SortingType.BY_COUNT) {
                    printWriter.println("Total lines: " + lineCount);

                    String lastLinePrinted = "";
                    for (String line : sortedStrings) {
                        int currNumberCount = Collections.frequency(sortedStrings, line);

                        if (!lastLinePrinted.equals(line)) {
                            lastLinePrinted = line;
                            printWriter.println(line + ": " + currNumberCount + " time(s), "
                                    + ((double) currNumberCount / lineCount * 100) + "%).");
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputSortedWordData(ArrayList<String> sortedWords, SortingType sortingType, File outputFile) {
        int wordCount = sortedWords.size();

        if (outputFile == null) {
            if (sortingType == SortingType.NATURAL) {
                System.out.println("Total words: " + wordCount);

                System.out.println("Sorted data: ");
                sortedWords.stream()
                        .forEach(word -> System.out.print(word + " "));
            }

            if (sortingType == SortingType.BY_COUNT) {
                System.out.println("Total words: " + wordCount);

                String lastWordPrinted = "";
                for (String word : sortedWords) {
                    int currWordCount = Collections.frequency(sortedWords, word);

                    if (!lastWordPrinted.equals(word)) {
                        lastWordPrinted = word;
                        System.out.println(word + ": " + currWordCount + " time(s), "
                                + ((double) currWordCount / wordCount * 100) + "%).");
                    }
                }
            }
        } else {
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                if (sortingType == SortingType.NATURAL) {
                    printWriter.println("Total words: " + wordCount);

                    printWriter.print("Sorted data: ");
                    sortedWords.stream()
                            .forEach(word -> printWriter.print(word + " "));
                }

                if (sortingType == SortingType.BY_COUNT) {
                    printWriter.println("Total words: " + wordCount);

                    String lastWordPrinted = "";
                    for (String word : sortedWords) {
                        int currWordCount = Collections.frequency(sortedWords, word);

                        if (!lastWordPrinted.equals(word)) {
                            lastWordPrinted = word;
                            printWriter.println(word + ": " + currWordCount + " time(s), "
                                    + ((double) currWordCount / wordCount * 100) + "%).");
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}