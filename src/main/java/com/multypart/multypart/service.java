package com.multypart.multypart;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class service {
    public static void uploadFile(List<MultipartFile> file) {
        for (int i = 0; i < file.size(); i++){
            try {

                Path destination = Paths.get("rootDir").resolve(file.get(i).getOriginalFilename()).normalize().toAbsolutePath();
                Files.copy(file.get(i).getInputStream(), destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
