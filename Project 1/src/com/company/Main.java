package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public static void scannerFunc() {
        char letter = 'a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'|'i'|'j'|'k'|'l'|'m'|'n'|'o'|'p'|'q'|'r'|'s'|'t'|'u'|'v'|'w'|'x'|'y'|'z';
        int digit = 0|1|2|3|4|5|6|7|8|9;
        String words = " "; //to read the file and get all the strings
        String[] array = {}; //to hold all the elements of words once its split
        int[] numArray = IntStream.range(1, 100).toArray(); //hold all numbers from 1-100
        ArrayList<String> output = new ArrayList<String>(); //only for output

        File readFile = new File("fileName.txt");

        while (readFile != null) {
            words = readFile.toString();
        }

        array = words.split(words);

        int current_state = 0;

        for (int i = 0; i < array.length; i++) {

            // Start state
            if ((array[i].equals(' ') | array[i].equals('\t') | array[i].equals("\n"))) {
                current_state = 1;    // start state
                continue;
            }

            // Division token
            if (array[i].equals('/')){
                current_state = 2;	// div state
                output.add("div");

                // Comment tokens
                if (array[i].equals('/')) {
                    current_state = 3;	// new line or non-newline state
                    current_state = 1;  // continue to state #1 (start)
                }else if(array[i].equals('*')) {
                    current_state = 4;	// non-* state

                    if(array[i].equals('*')) {
                        current_state = 5; 	// non- | or* state
                    } else if(array[i].equals('/')){
                        current_state = 1;
                        continue;
                    }
                    current_state = 1;	//start
                }
            }

            // Lparen token
            if(array[i].equals('(')){
                current_state = 6;
                output.add("lparen");
                continue;
            }

            // Rparen token
            if(array[i].equals(')')){
                current_state = 7;
                output.add("rparen");
                continue;
            }

            // Plus token
            if(array[i].equals('+')){
                current_state = 8;
                output.add("plus");
                continue;
            }

            // Minus token
            if(array[i].equals('-')){
                current_state = 9;
                output.add("minus");
                continue;
            }

            // Times token
            if(array[i].equals('*')){
                current_state = 10;
                output.add("times");
                continue;
            }

            // Semicolon token
            if(array[i].equals(':')){
                current_state = 11;
                output.add("semicolon");

                // Assign token
                if(array[i].equals('=')){
                    current_state = 12;
                    output.add("assign");
                    continue;
                }
            }

            // Period token
            if(array[i].equals('.')){
                current_state = 13;
                output.add("period");

                // Number token
                if(array[i].equals(String.valueOf(digit))){
                    current_state = 15;
                    output.add("digit");
                    if(array[i].equals(String.valueOf(digit)) && array[i+1].equals(String.valueOf(digit))){
                        current_state = 15;
                        output.add("number");
                    }
                }
            }

            // Number token
            if(array[i].equals(String.valueOf(digit))){
                current_state = 14;
                output.add("digit");
                if(array[i].equals(String.valueOf(digit)) && array[i+1].equals(String.valueOf(digit))){
                    current_state = 15;
                    output.add("number");
                }
            }

            // ID or keyword token
            if(array[i].equals(String.valueOf(letter))){
                current_state = 16;
                output.add("id");
                if(array[i].equals(String.valueOf(letter)) && array[i+1].equals(String.valueOf(letter))){
                    current_state = 16;
                    output.add("number");
                }
            }

            // Read token
            if (array[i].equals("read")) {
                output.add("read");
            }

            // Write token
            if (array[i].equals("write")) {
                output.add("write");
            }
        }
    }

    public static void main(String[] args) {
        scannerFunc();
        System.out.println("Done");
    }
}