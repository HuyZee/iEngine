import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: iengine <method> <filename>");
            System.exit(1);
        }

        try (Scanner scanner = new Scanner(new File(args[1]))) {
            FileReader nFile = new FileReader(scanner);

            switch (args[0].toLowerCase()) {
                case "fc":
                    ForwardChaining forward = new ForwardChaining(nFile);
                    System.out.println("FC > " + forward.testAsk());
                    break;
                case "bc":
                    BackwardChaining backward = new BackwardChaining(nFile);
                    System.out.println("BC > " + backward.testAsk());
                    break;
                case "tt":
                    TruthTableChecking truthTable = new TruthTableChecking(nFile);
                    System.out.println("TT > " + truthTable.testTruth());
                    break;
                default:
                    System.out.println("Invalid method specified.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}