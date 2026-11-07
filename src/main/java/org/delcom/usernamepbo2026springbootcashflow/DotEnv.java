package org.delcom.usernamepbo2026springbootcashflow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Memuat file .env ke system properties sebelum Spring Boot start. */
public final class DotEnv {

    private DotEnv() {
    }

    public static void load() {
        load(Path.of(".env"));
    }

    static void load(Path path) {
        if (!Files.exists(path)) {
            return;
        }
        try {
            List<String> lines = Files.readAllLines(path);
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#") || !line.contains("=")) {
                    continue;
                }
                int idx = line.indexOf('=');
                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();
                // Variabel lingkungan / -D yang sudah ada tidak ditimpa
                if (System.getenv(key) == null && System.getProperty(key) == null) {
                    System.setProperty(key, value);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Gagal membaca file .env", e);
        }
    }
}
