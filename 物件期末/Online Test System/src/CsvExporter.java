import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvExporter {

    public static void export(Path path, List<String[]> rows, String[] headers) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            if (headers != null && headers.length > 0) {
                writeLine(bw, headers);
            }
            for (String[] row : rows) {
                writeLine(bw, row);
            }
        }
    }

    private static void writeLine(BufferedWriter bw, String[] cols) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(escape(cols[i]));
        }
        bw.write(sb.toString());
        bw.newLine();
    }

    private static String escape(String s) {
        if (s == null) return "";
        String out = s.replace("\"", "\"\"");
        boolean needQuote = out.contains(",") || out.contains("\"") || out.contains("\n") || out.contains("\r");
        if (needQuote) out = "\"" + out + "\"";
        return out;
    }
}

