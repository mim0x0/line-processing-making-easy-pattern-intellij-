package intern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineByLineProcessing {
    public static void main(String[] args) {
        String filename = "C:\\intern\\workspace\\carlifeworks\\car 2.txt";
        List<List<String>> allMenus = new ArrayList<>();
        List<String> currentMenu = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String tempTitle="";
            String menuTitle="";
            String subTitle="";
            boolean processingMenu = false;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("plMenu.makeMenu")) {
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        tempTitle = parts[2].trim();

                        if (tempTitle.toUpperCase().equals(tempTitle)) {
                            menuTitle=tempTitle;
                            System.out.print("yooo"+menuTitle);

                            if (!menuTitle.isEmpty() && menuTitle.toUpperCase().equals(menuTitle)) {
                                if (!currentMenu.isEmpty()) {
                                    allMenus.add(new ArrayList<>(currentMenu));
                                    currentMenu.clear();
                                    subTitle="";
                                }
                            }
                        } else if (!tempTitle.toUpperCase().equals(tempTitle)) {
                            if (tempTitle.equals("\"Process\"")  || tempTitle.equals("\"Enquiry\"") || tempTitle.equals("\"Report\"") || tempTitle.equals("\"Maintenance\"")
                                    || tempTitle.equals("\"System Process\"") || tempTitle.equals("\"Data Conversion\"") || tempTitle.equals("\"Security\"")
                                    || tempTitle.equals("\"Archive\"")) {
                                subTitle=tempTitle;
                                System.out.print("heeeee"+subTitle);
                            }
//                            else if (!subTitle.isEmpty() && (!subTitle.equals("\"Process\"")
//                                    || !subTitle.equals("\"Enquiry\"") || !subTitle.equals("\"Report\"")
//                                    || !subTitle.equals("\"Maintenance\""))) {
//
//                            }
                        }

                    }
                }
//                else if (line.trim().startsWith("plMenu.makeMenu") && !subTitle.toUpperCase().equals(subTitle)) {
//                    String[] sub = line.split(",");
//                    if (sub.length >= 3) {
//                        subTitle = sub[2].trim();
//                        System.out.print("heeeee"+subTitle);
//                        if (!subTitle.isEmpty() && !subTitle.toUpperCase().equals(subTitle)) {
//                            if(!currentMenu.isEmpty()) {
////                                        allMenus.add(new ArrayList<>(currentMenu));
////                                        currentMenu.clear();
//                            }
//                        }
//                    }
//                }

                currentMenu.add(line+subTitle+";"+menuTitle+";"); // Add the line to the current menu
            }

            // Add the last menu to allMenus
            if (!currentMenu.isEmpty()) {
                allMenus.add(new ArrayList<>(currentMenu));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (List<String> menu : allMenus) {
            System.out.println("Menu:");
            for (String line : menu) {
                System.out.println(line); // Process the line here
            }
            System.out.println(); // Add a blank line between menus
        }
    }

    public static void processLine(String line) {
        // Your processing logic for each line goes here
        System.out.println("Processing line: " + line);
    }

    public static boolean isThirdParameterAllUppercase(String line) {
        String[] parts = line.split(";");
        if (parts.length >= 4) {
            String thirdParam = parts[3].trim();
            return thirdParam.equals(thirdParam.toUpperCase());
        }
        return false;
    }
}
