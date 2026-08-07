package com.qap4.repository;

import com.qap4.model.Drug;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/** Persists Drug objects in a UTF-8 tab-separated text file. */
public class DrugFileRepository {
    private static final String DELIMITER = "\t";
    private final Path filePath;

    public DrugFileRepository(Path filePath) {
        this.filePath = filePath;
    }

    public void save(Drug drug) throws IOException {
        Path parent = filePath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            writer.write(toRecord(drug));
            writer.newLine();
        }
    }

    public List<Drug> findAll() throws IOException {
        List<Drug> drugs = new ArrayList<>();
        if (Files.notExists(filePath)) {
            return drugs;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.isBlank()) {
                    continue;
                }

                try {
                    drugs.add(fromRecord(line));
                } catch (IllegalArgumentException exception) {
                    System.err.printf(
                            "Skipping invalid record on line %d: %s%n",
                            lineNumber,
                            exception.getMessage()
                    );
                }
            }
        }

        return drugs;
    }

    public Path getFilePath() {
        return filePath;
    }

    private String toRecord(Drug drug) {
        return drug.getDrugId() + DELIMITER
                + sanitize(drug.getDrugName()) + DELIMITER
                + drug.getDrugCost().toPlainString() + DELIMITER
                + sanitize(drug.getDosage());
    }

    private Drug fromRecord(String record) {
        String[] values = record.split(DELIMITER, -1);
        if (values.length != 4) {
            throw new IllegalArgumentException("Expected 4 fields but found " + values.length + ".");
        }

        try {
            return new Drug(
                    Integer.parseInt(values[0]),
                    values[1],
                    new BigDecimal(values[2]),
                    values[3]
            );
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("ID or cost has an invalid number format.", exception);
        }
    }

    private String sanitize(String value) {
        return value.replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim();
    }
}
