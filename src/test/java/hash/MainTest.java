package hash;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

  @Test
  public void printHashTable() {
    String userInput = String.format(
        "2%s13 9%s44 45 49 70 27 73 92 97 95%s7 8%s35 12 2 17 19 51 88 86",
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(bais);

    String expected = String.format(
        "0 -> \\%s1 -> 27 -> 92 -> \\%s2 -> \\%s3 -> \\%s4 -> 95 -> \\%s5 -> 44 -> 70 -> \\%s6 -> 45 -> 97 -> \\%s7 -> \\%s8 -> 73 -> \\%s9 -> \\%s10 -> 49 -> \\%s11 -> \\%s12 -> \\%s%s0 -> 35 -> \\%s1 -> \\%s2 -> 2 -> 51 -> 86 -> \\%s3 -> 17 -> \\%s4 -> 88 -> \\%s5 -> 12 -> 19 -> \\%s6 -> \\",
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator());
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    try{
        Main.main(null);
    }catch(IOException ex){
        System.out.println("Test failed " + ex.getMessage());
    }

    String[] lines = baos.toString().split(System.lineSeparator());
    String actual = "";
    for(int i = 0; i < lines.length; i++) {
        if(i != 0){
            actual += "\n";
        }
        actual += lines[i];
    }

    // checkout output
    Assert.assertEquals(expected,actual);
  }
}
