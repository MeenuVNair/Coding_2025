package com.meenu.learning.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.temporal.IsoFields;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Meenu V. Nair
 * @created 13/08/25
 */


public class FileCounter {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Your repo layout
        Path easyDir   = Paths.get("src/main/java/com/meenu/learning/problems/easy");
        Path mediumDir = Paths.get("src/main/java/com/meenu/learning/problems/medium");
        Path hardDir   = Paths.get("src/main/java/com/meenu/learning/problems/hard");
        Path creationalDesignPatternDir   = Paths.get("src/main/java/com/meenu/learning/designpatterns/creational");
        Path structuralDesignPatternDir   = Paths.get("src/main/java/com/meenu/learning/designpatterns/structural");
        Path behavioralDesignPatternDir   = Paths.get("src/main/java/com/meenu/learning/designpatterns/behavioral");
        Path LLDDir   = Paths.get("src/main/java/com/meenu/learning/lld");

        int easyCount   = countJavaFiles(easyDir);
        int mediumCount = countJavaFiles(mediumDir);
        int hardCount   = countJavaFiles(hardDir);

        int creationalDPCount   = countSubdirectories(creationalDesignPatternDir);
        int structuralDPCount   = countSubdirectories(structuralDesignPatternDir);
        int behavioralDPCount   = countSubdirectories(behavioralDesignPatternDir);

        int lldCount   = countSubdirectories(LLDDir);

        Path readmePath = Paths.get("README.md");
        String content  = new String(Files.readAllBytes(readmePath), StandardCharsets.UTF_8);

        // ==============================
        // Program Counts Table
        // ==============================
        String newProgramTable =
                "## 📂 **DSA Program Counts**\n\n" +
                        "| **Difficulty** | **Count** |\n" +
                        "|----------------|-----------|\n" +
                        "| 🟢 **Easy**    | **" + easyCount + "** |\n" +
                        "| 🟡 **Medium**  | **" + mediumCount + "** |\n" +
                        "| 🔴 **Hard**    | **" + hardCount + "** |\n" +
                        "| 📊 **Total**   | **" + (easyCount + mediumCount + hardCount) + "** |\n";


        String startMarker = "<!-- PROGRAM_COUNTS_START -->";
        String endMarker   = "<!-- PROGRAM_COUNTS_END -->";

        if (content.contains(startMarker) && content.contains(endMarker)) {
            String regex = "(?s)" + Pattern.quote(startMarker) + ".*?" + Pattern.quote(endMarker);
            String replacement = startMarker + "\n" + newProgramTable + "\n" + endMarker;
            content = content.replaceAll(regex, replacement);
        } else {
            content += "\n\n" + startMarker + "\n" + newProgramTable + "\n" + endMarker + "\n";
        }

        // ==============================
        // LLD Topics
        // ==============================

        String lldStart = "<!-- LLD_START -->";
        String lldEnd   = "<!-- LLD_END -->";

        String newLLDTable =
                "## 📂 **Low Level Design**\n\n" +
                        "| **Topics** | **Count** | **Details** |\n" +
                        "|----------------|-----------|-----------|\n" +
                        "| ✅ **Design Patterns**    | **" + (creationalDPCount + structuralDPCount + behavioralDPCount) + "** |" + "creational : " + creationalDPCount + ", structural : " + structuralDPCount + ", behavioral : " + behavioralDPCount + "|\n"+
                        "| ✅ **Low Level Designs**    | **" + lldCount + "** | |\n";


        if (content.contains(lldStart) && content.contains(lldEnd)) {
            String regex = "(?s)" + Pattern.quote(lldStart) + ".*?" + Pattern.quote(lldEnd);
            String replacement = lldStart + "\n" + newLLDTable + "\n" + lldEnd;
            content = content.replaceAll(regex, replacement);
        } else {
            content += "\n\n" + lldStart + "\n" + newLLDTable + "\n" + lldEnd + "\n";
        }

        // ==============================
        // Commit History Table (last 4 weeks)
        // ==============================
        String commitHistoryTable = buildCommitHistoryTable();

        String commitStart = "<!-- COMMIT_HISTORY_START -->";
        String commitEnd   = "<!-- COMMIT_HISTORY_END -->";

        if (content.contains(commitStart) && content.contains(commitEnd)) {
            String regex = "(?s)" + Pattern.quote(commitStart) + ".*?" + Pattern.quote(commitEnd);
            String replacement = commitStart + "\n" + commitHistoryTable + "\n" + commitEnd;
            content = content.replaceAll(regex, replacement);
        } else {
            content += "\n\n" + commitStart + "\n" + commitHistoryTable + "\n" + commitEnd + "\n";
        }

        // ==============================
        // Write back
        // ==============================
        Files.write(readmePath, content.getBytes(StandardCharsets.UTF_8));
        System.out.println("✅ README.md updated.");
    }

    private static int countJavaFiles(Path dir) throws IOException {
        if (!Files.exists(dir)) return 0;
        try (Stream<Path> paths = Files.walk(dir)) {
            return (int) paths.filter(p -> Files.isRegularFile(p) && p.toString().endsWith(".java")).count();
        }
    }

    private static int countSubdirectories(Path dir) throws IOException {
        if (!Files.exists(dir)) return 0;
        try (Stream<Path> paths = Files.list(dir)) { // only direct children
            return (int) paths.filter(Files::isDirectory).count();
        }
    }

    /**
     * Runs `git log` to fetch commit counts grouped by week,
     * and builds a Markdown table with Easy/Medium/Hard breakdown.
     */
    private static String buildCommitHistoryTable() throws IOException, InterruptedException {
        // Run git log: output week + changed files
        ProcessBuilder pb = new ProcessBuilder(
                "git", "log", "--since=1.month",
                "--date=format:%Y-%V",
                "--pretty=format:%ad", "--name-only"
        );
        pb.redirectErrorStream(true);
        Process process = pb.start();
        Scanner sc = new Scanner(process.getInputStream());

        // Week → stats
        class Stats { int easy, medium, hard; }
        Map<String, Stats> weekStats = new LinkedHashMap<>();

        String currentWeek = null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) continue;

            // Detect week (line with date)
            if (line.matches("\\d{4}-\\d{2}")) {
                currentWeek = convertIsoWeekToRange(line);
                weekStats.putIfAbsent(currentWeek, new Stats());
                continue;
            }

            // Otherwise it's a file path
            if (currentWeek != null) {
                Stats stats = weekStats.get(currentWeek);
                String lower = line.toLowerCase();
                if (lower.contains("/easy/")) stats.easy++;
                else if (lower.contains("/medium/")) stats.medium++;
                else if (lower.contains("/hard/")) stats.hard++;
            }
        }
        process.waitFor();

        // Build Markdown table
        StringBuilder sb = new StringBuilder();
        sb.append("## 📊 DSA Commit Activity (last 4 weeks)\n\n");
        sb.append("| Week | 🟢 Easy | 🟡 Medium | 🔴 Hard | 📈 Total |\n");
        sb.append("|------|---------|-----------|---------|----------|\n");

        for (Map.Entry<String, Stats> entry : weekStats.entrySet()) {
            Stats s = entry.getValue();
            int total = s.easy + s.medium + s.hard;
            sb.append("| ").append(entry.getKey())
                    .append(" | ").append(s.easy)
                    .append(" | ").append(s.medium)
                    .append(" | ").append(s.hard)
                    .append(" | ").append(total)
                    .append(" |\n");
        }

        if (weekStats.isEmpty()) {
            sb.append("| No commits in last month | 0 | 0 | 0 | 0 |\n");
        }

        return sb.toString();
    }

    /**
     * Converts ISO week (e.g., 2025-34) into "Aug 18–24" style.
     */
    private static String convertIsoWeekToRange(String isoWeek) {
        try {
            String[] parts = isoWeek.split("-");
            int year = Integer.parseInt(parts[0]);
            int week = Integer.parseInt(parts[1]);

            LocalDate startOfWeek = LocalDate
                    .ofYearDay(year, 1)
                    .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week)
                    .with(DayOfWeek.MONDAY);

            LocalDate endOfWeek = startOfWeek.plusDays(6);

            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM");
            String month = startOfWeek.format(monthFormatter);

            return String.format("%s %d–%d", month,
                    startOfWeek.getDayOfMonth(),
                    endOfWeek.getDayOfMonth());
        } catch (Exception e) {
            return isoWeek; // fallback
        }
    }
}
