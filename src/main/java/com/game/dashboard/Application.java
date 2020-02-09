package com.game.dashboard;

import com.game.dashboard.controller.UploadingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new File(UploadingController.uploadingDir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}