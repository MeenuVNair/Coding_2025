package com.meenu.coding.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

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
        // Folder paths
        Map<String, Path> folders = new HashMap<>();
        folders.put("Easy", Paths.get("src/main/java/com/meenu/coding/easy"));
        folders.put("Medium", Paths.get("src/main/java/com/meenu/coding/medium"));
        folders.put("Hard", Paths.get("src/main/java/com/meenu/coding/hard"));

        // Count files
        Map<String, Long> counts = new HashMap<>();
        for (Map.Entry<String, Path> entry : folders.entrySet()) {
            long count = Files.list(entry.getValue())
                    .filter(Files::isRegularFile)
                    .count();
            counts.put(entry.getKey(), count);
        }

        // Read README.md
        Path readmePath = Paths.get("README.md");
        String content = new String(Files.readAllBytes(readmePath), StandardCharsets.UTF_8);

        // Build new table (Java 8 string concatenation)
        String table =
                "## 📂 Program Counts\n\n" +
                        "| Difficulty | Count |\n" +
                        "|------------|-------|\n" +
                        "| 🟢 Easy    | " + counts.get("Easy") + "    |\n" +
                        "| 🟡 Medium  | " + counts.get("Medium") + "    |\n" +
                        "| 🔴 Hard    | " + counts.get("Hard") + "    |\n";

        // Replace the old table with the new one
        content = content.replaceAll(
                "(?s)## 📂 Program Counts.*?(?=##|$)", // Matches old table block
                table + "\n"
        );

        // Write updated README
        Files.write(readmePath, content.getBytes(StandardCharsets.UTF_8));

        System.out.println("Updated counts in README: " + counts);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
