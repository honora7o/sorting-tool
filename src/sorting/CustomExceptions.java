package sorting;

public class CustomExceptions {

    public static class InvalidArgumentException extends Exception {

        public InvalidArgumentException(String invalidArgument) {
            super("\"" + invalidArgument + "\" is not a valid parameter. It will be skipped.");
        }
    }

    public static class DataTypeException extends Exception {
        public DataTypeException() {
            super("No data type defined!");
        }
    }

    public static class SortingTypeException extends Exception {
        public SortingTypeException() {
            super("Invalid or no sorting type defined!");
        }
    }

    public static class InputFileException extends Exception {
        public InputFileException() {
            super("No input file defined!");
        }
    }

    public static class OutputFileException extends Exception {
        public OutputFileException() {
            super("No output file defined!");
        }
    }
}