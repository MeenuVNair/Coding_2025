package com.meenu.coding.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.regex.Pattern;

/**
 * @author Meenu V. Nair
 * @created 13/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class FileCounter {
    public static void main(String[] args) throws IOException {
        // Your repo layout
        Path easyDir   = Paths.get("src/main/java/com/meenu/coding/easy");
        Path mediumDir = Paths.get("src/main/java/com/meenu/coding/medium");
        Path hardDir   = Paths.get("src/main/java/com/meenu/coding/hard");

        int easyCount   = countJavaFiles(easyDir);
        int mediumCount = countJavaFiles(mediumDir);
        int hardCount   = countJavaFiles(hardDir);

        Path readmePath = Paths.get("README.md");
        String content  = new String(Files.readAllBytes(readmePath), StandardCharsets.UTF_8);

        // Bold, emoji-highlighted Markdown table
        String newTable =
                "## 📂 **Program Counts**\n\n" +
                        "| **Difficulty** | **Count** |\n" +
                        "|------------|-------|\n" +
                        "| 🟢 **Easy**    | **" + easyCount + "**    |\n" +
                        "| 🟡 **Medium**  | **" + mediumCount + "**    |\n" +
                        "| 🔴 **Hard**    | **" + hardCount + "**    |\n";


        String startMarker = "<!-- PROGRAM_COUNTS_START -->";
        String endMarker   = "<!-- PROGRAM_COUNTS_END -->";

        if (content.contains(startMarker) && content.contains(endMarker)) {
            String regex = "(?s)" + Pattern.quote(startMarker) + ".*?" + Pattern.quote(endMarker);
            String replacement = startMarker + "\n" + newTable + "\n" + endMarker;
            content = content.replaceAll(regex, replacement);
        } else {
            content += "\n\n" + startMarker + "\n" + newTable + "\n" + endMarker + "\n";
        }

        Files.write(readmePath, content.getBytes(StandardCharsets.UTF_8));
        System.out.println("✅ README.md updated.");
    }

    private static int countJavaFiles(Path dir) throws IOException {
        if (!Files.exists(dir)) return 0;
        try (Stream<Path> paths = Files.walk(dir)) {
            return (int) paths.filter(p -> Files.isRegularFile(p) && p.toString().endsWith(".java")).count();
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
