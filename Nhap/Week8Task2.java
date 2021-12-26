package Nhap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8Task2 {
    /** Test pointer. */
    public String nullPointerEx() throws NullPointerException {
        String s = null;
        return s;
    }

    /** Throw Exception. */
    public String nullPointerExTest() {
        String error = "Không có lỗi";
        try {
            String s = nullPointerEx();
            s = s.concat("omg");
        } catch (NullPointerException e) {
            error = "Lỗi Null Pointer";
        }
        return error;
    }

    /** Test array. */
    public int arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        int[] a = new int[2];
        return a[2];
    }

    /** Throw Exception. */
    public String arrayIndexOutOfBoundsExTest() {
        String error = "Không có lỗi";
        try {
            int check = arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            error = "Lỗi Array Index Out of Bounds";
        }
        return error;
    }

    /** Test division. */
    public int arithmeticEx() throws ArithmeticException {
        return 25 / 0;
    }

    /** Throw Exception. */
    public String arithmeticExTest() {
        String error = "Không có lỗi";
        try {
            int check = arithmeticEx();
        } catch (ArithmeticException e) {
            error = "Lỗi Arithmetic";
        }
        return error;
    }

    /** Test file. */
    public FileReader fileNotFoundEx() throws FileNotFoundException {
        FileReader fileReader = new FileReader("omg.txt");
        return fileReader;
    }

    /** Throw Exception. */
    public String fileNotFoundExTest() {
        String error = "Không có lỗi";
        try {
            FileReader check = fileNotFoundEx();
        } catch (FileNotFoundException e) {
            error = "Lỗi File Not Found";
        }
        return error;
    }

    /** Test file. */
    public FileReader ioEx() throws IOException {
        FileReader fileReader = new FileReader("omg.txt");
        return fileReader;
    }

    /** Throw Exception. */
    public String ioExTest() {
        String error = "Không có lỗi";
        try {
            FileReader check = fileNotFoundEx();
        } catch (IOException e) {
            error = "Lỗi IO";
        }
        return error;
    }
}