# sorting-tool

Sorting tool made as personal learning project. Handles two different types of sorting (natural and by count/frequency), three different data types 
(number, line, word) and also two different types of input and output (file and standard cli-based); all parameter dependent. 

Will also handle custom exceptions for different invalid arguments, any type of unwanted situations and unordered parameters.

# Usage

The program accepts the following command-line arguments:

   -dataType <type>: Specifies the data type to be sorted. Available options: long, number, line, word. (Default: word)
   
   -sortingType <type>: Specifies the sorting type. Available options: natural, byCount. (Default: natural)
   
   -inputFile <file>: Specifies the input file containing the data to be sorted. (Default: read from standard input)
   
   -outputFile <file>: Specifies the output file where the sorted data will be written. (Default: write to standard output)

# Examples
  
  Sorting long by count; default input and output (cli):
```bash
java SortingTool -sortingType byCount -dataType long
> 1 -2   33 4
> 42
> 1                 1
Total numbers: 7.
-2: 1 time(s), 14%
4: 1 time(s), 14%
33: 1 time(s), 14%
42: 1 time(s), 14%
1: 3 time(
```  

 Sorting word naturally (default call); default input (cli), outputting to file:

```bash
#data.txt
pineapple     apple
apple   zebra
camera appartment
huge   coding
fun year
learning  about
```

```bash
java SortingTool -outputFile out.txt -inputFile data.txt
```  
  
```bash
#out.txt
Total words: 12
Sorted data: pineapple apple apple zebra camera appartment huge coding fun year learning about 
```   
  
