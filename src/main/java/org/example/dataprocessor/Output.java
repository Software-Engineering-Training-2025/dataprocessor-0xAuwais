package org.example.dataprocessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public interface Output {
    void output(double result);
}
class output_console implements Output{
    @Override
    public void output(double result) {
        System.out.println("Result = " +result);
    }
}
class output_txt implements Output {
    @Override
    public void output(double result) {
        try {
            Path path = Paths.get("target/result.txt");
            Files.createDirectories(path.getParent());
            Files.write(path, Collections.singleton("Result = " + result),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

