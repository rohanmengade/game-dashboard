package com.game.dashboard.controller;

import com.game.dashboard.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadingController {
    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";

    @Autowired
    private UploadService uploadService;

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public String uploading(Model model) {
        File file = new File(uploadingDir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public String uploadingPost(@RequestParam( "uploadingFiles" ) MultipartFile uploadingFiles) throws IOException {
        uploadService.uploadFile(uploadingFiles);

        return "redirect:http://localhost:3000/d/3AJQXs8Zk/gamedashboard?orgId=1";
    }
}
