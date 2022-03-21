package de.cryptosdk.data.json.totp;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TotpJsonConverter {

    public static void main(String[] args) throws IOException {

        String inputJson;
        String outputCSV;
        boolean console = false;
        boolean noFile = false;

        if (args.length == 1) {
            inputJson = args[0];
            outputCSV = inputJson.replaceFirst("\\.json",".csv");
            if(!Files.exists(Path.of(inputJson))) {
                System.err.println("\"" + inputJson + "\" does not exist!");
                return;
            }
            if(Files.exists(Path.of(outputCSV))) {
                System.err.println("\"" + outputCSV + "\" still exist! Please delete it or add csv file name after input file!");
                return;
            }
        }
        else if (args.length == 2) {
            inputJson = args[0];
            outputCSV = args[1];
            if(!Files.exists(Path.of(inputJson))) {
                System.err.println("\"" + inputJson + "\" does not exist!");
                return;
            }
            if(outputCSV.equals("c")) {
                noFile = true;
                console = true;
            }
            else if(Files.exists(Path.of(outputCSV))) {
                System.err.println("\"" + outputCSV + "\" still exist! Please delete it or add csv file name after input file!");
                return;
            }
        }
        else if (args.length == 3) {
            inputJson = args[0];
            outputCSV = args[1];
            if(!Files.exists(Path.of(inputJson))) {
                System.err.println("\"" + inputJson + "\" does not exist!");
                return;
            }
            if(outputCSV.equals("c")) {
                noFile = true;
                console = true;
            }
            else if(Files.exists(Path.of(outputCSV))) {
                System.err.println("\"" + outputCSV + "\" still exist! Please delete it or add csv file name after input file!");
                return;
            }
            TotpEntry.setSeparator(args[2]);
        }
        else if (args.length == 4) {
            inputJson = args[0];
            outputCSV = args[1];
            if(!Files.exists(Path.of(inputJson))) {
                System.err.println("\"" + inputJson + "\" does not exist!");
                return;
            }
            console = args[3].equals("c");
            if(outputCSV.equals("c")) {
                noFile = true;
                console = true;
            }
            else if(Files.exists(Path.of(outputCSV))) {
                System.err.println("\"" + outputCSV + "\" still exist! Please delete it or add csv file name after input file!");
                return;
            }
            TotpEntry.setSeparator(args[2]);

        }
        else {
            System.out.println("Help:");
            System.out.println("... <json-file> [<csv-filename> [<csv-separator> [c]]]");
            System.out.println("Default <csv-file>: \"<json-file>.csv\" OR \"c\" for console-only");
            System.out.println("Default <csv-separator>: \"\\t\"");
            System.out.println("Default console: none, enable with \"c\"");
            return;
        }

        String fileData = Files.readString(Path.of(inputJson));

        Gson json = new Gson();

        TotpEntry[] array = json.fromJson(fileData,TotpEntry[].class);
        List<TotpEntry> list = Arrays.asList(array);

        StringBuilder sb = new StringBuilder();
        sb.append(TotpEntry.csvTitle()).append("\n");

        list.forEach(e -> {
            sb.append(e.toCSV()).append("\n");
        });

        if(!noFile) {
            Files.writeString(Path.of(outputCSV), sb.toString().trim());
        }
        System.out.println("Input: " + inputJson);
        System.out.println("Output: " + outputCSV);
        System.out.println("CSV-Separator: " + TotpEntry.getSeparator());

        if(console) {
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println(sb.toString().trim());
            System.out.println();
            System.out.println("------------------------------------");
        }
    }
}
