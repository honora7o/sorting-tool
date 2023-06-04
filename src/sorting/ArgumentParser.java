package sorting;

import java.io.File;
import java.util.HashMap;

public class ArgumentParser {
    private SortingType sortingType;
    private static final String ARG_SORTING_TYPE = "-sortingType";
    private DataType dataType;
    private static final String ARG_DATA_TYPE = "-dataType";
    private File inputFile;
    private static final String ARG_INPUT_FILE = "-inputFile";
    private File outputFile;
    private static final String ARG_OUTPUT_FILE = "-outputFile";
    HashMap<String, String> argsMap;

    public ArgumentParser() {
        this.sortingType = SortingType.NATURAL;
        this.dataType = DataType.WORD;
        this.inputFile = null;
        this.outputFile = null;
        this.argsMap = new HashMap<>();
    }

    public void parseArgumentsIntoMap(String[] args) {
        String currKey = null;

        try {
            for (String arg : args) {
                if (arg.equals(ARG_DATA_TYPE) || arg.equals(ARG_SORTING_TYPE)
                        || arg.equals(ARG_INPUT_FILE) || arg.equals(ARG_OUTPUT_FILE)) {   //if current arg is valid, set is a curr key
                    currKey = arg;                                                        //to be passed as key in the args hashmap
                } else if (currKey != null) {
                    argsMap.put(currKey, arg);
                    currKey = null;
                } else {
                    throw new CustomExceptions.InvalidArgumentException(arg);   //if current arg being read is not a valid arg or
                }                                                               //parameter, throws InvalidArgumentException
            }
        } catch (CustomExceptions.InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void parseDataType() {
        try {
            String dataTypeValue = this.argsMap.get(ARG_DATA_TYPE);
            if (dataTypeValue != null) {
                switch (dataTypeValue) {
                    case "long" -> setDataType(DataType.LONG);
                    case "number" -> setDataType(DataType.NUMBER);
                    case "line" -> setDataType(DataType.LINE);
                }
            } else if (this.argsMap.containsKey(ARG_DATA_TYPE)) {
                throw new CustomExceptions.DataTypeException();
            }
        } catch (CustomExceptions.DataTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void parseSortingType() {
        // checks if -sortingType is passed, and if there is any valid
        // value attached to it
        try {
            String sortingTypeValue = this.argsMap.get(ARG_SORTING_TYPE);
            if (sortingTypeValue != null) {
                if (sortingTypeValue.equals("byCount")) {
                    setSortingType(SortingType.BY_COUNT);
                } else if (sortingTypeValue.equals("natural")) {
                    setSortingType(SortingType.NATURAL);
                } else {
                    throw new CustomExceptions.SortingTypeException();
                }
            }
        } catch (CustomExceptions.SortingTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public void parseInputFile() {
        try {
            if (this.argsMap.containsKey(ARG_INPUT_FILE)) {
                String inputFileParam = this.argsMap.get(ARG_INPUT_FILE);
                if (inputFileParam == null) {
                    throw new CustomExceptions.InputFileException();
                } else {
                    setInputFile(new File(this.argsMap.get(ARG_INPUT_FILE)));
                }
            }
        } catch (CustomExceptions.InputFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void parseOutputFile() {
        try {
            if (this.argsMap.containsKey(ARG_OUTPUT_FILE)) {
                String outputFileParam = this.argsMap.get(ARG_OUTPUT_FILE);
                if (outputFileParam == null) {
                    throw new CustomExceptions.OutputFileException();
                } else {
                    setOutputFile(new File(this.argsMap.get(ARG_OUTPUT_FILE)));
                }
            }
        } catch (CustomExceptions.OutputFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }
}