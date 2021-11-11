# Scanner

The scanner is a project written on Java that uses the DFA (Deterministic Finite Automaton) as the basis for designing and implementing the scanner. The program has a scan function that scans an input file for valid and invalid tokens. If the token is valid the scan function returns the token type, otherwise returns an error flag.

## How to compile the source code

The .txt file will be located in the same folder as the java file. Be sure to download JDK to run the executable.
```bash
to access: C:\Users\Your_Drive\Desktop\Project1>

to run: C:\Users\ Your_Drive\Desktop\Project1>java project
```
If the output is incorrect, please check the file name in the code


## Usage

Example Input File: foo.txt with the following content:

```java
read
/* foo
bar */
*
five 5
```
Example Commandline: 
```java
scanner foo.txt
```
Example Output: 
```java
(read, times, id, number)
```

## Prepared by
Miguel Cruz, Isman Daiyrov and Minoshun Renganathan

## Acknowledgement
Thanks to Peter Adamopoulos and Zanxiang Wang for useful discussions.
