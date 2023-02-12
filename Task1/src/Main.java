import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner; // Import the Scanner class to read text files
public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        calculator(fileName);
    }

    public static String resolveOperation(String operation) {
        String result = "";
        try {
            String[] values = operation.split(" ");
            if (values.length == 3) {
                double number1 = Double.parseDouble(values[0]);
                double number2 = Double.parseDouble(values[2]);
                String operator = values[1];
                switch (operator) {
                    case "+": {
                        result = String.valueOf(number1 + number2);
                        break;
                    }
                    case "-": {
                        result = String.valueOf(number1 - number2);
                        break;
                    }
                    case "/": {
                        result = String.valueOf(number1 / number2);
                        break;
                    }
                    case "*": {
                        result = String.valueOf(number1 * number2);
                        break;
                    }
                }
            }

        } catch (NumberFormatException e) {
        }
        return result;
    }

    public static void calculator(String fileName){
        try {
            String results = "";
            File inputFile = new File(fileName);
            FileWriter outputFile = new FileWriter("results.txt");
            Scanner fileReader = new Scanner(inputFile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                if (!data.contains("=")) {
                    String valuesOK = resolveOperation(data);
                    if (valuesOK.isEmpty()) {
                        results = results + "Error,";
                    } else {
                        results = results + data + " = " + valuesOK + ",";
                    }
                }
            }
            fileReader.close();
            String[] exitValues = results.split(",");
            for (int i = 0; i < exitValues.length; i++) {
                outputFile.write(exitValues[i] + '\n');
            }
            outputFile.close();
        }
        catch (Exception e){
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}