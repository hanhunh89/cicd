package com.springmvc.util;

import java.io.File;

public class DeletePostImage {
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted: " + filePath);
            } else {
                System.out.println("Failed to delete file: " + filePath);
            }
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }
}
