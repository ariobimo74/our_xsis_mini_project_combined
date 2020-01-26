package com.xsis.xsis.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Upload
 */
@Controller
@RequestMapping(value = "/upload/", consumes = "multipart/form-data")
public class Upload {
    private static final String UPLOADED_FOLDER = "./attachments/";

    @PostMapping("upload_disini")
    public String singleFileUpload(@RequestPart("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "pages/vacancy";
        }
        try {
            String ext = "";
            byte[] bytes = file.getBytes();
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nama = dateFormat.format(date);
            String namaFile = file.getOriginalFilename();
            // String ext = "";
            for (int i = 0; i < namaFile.length(); i++) {
                if (namaFile.charAt(i) == '.') {
                    ext += namaFile.substring(i, namaFile.length());
                }
            }
            String fullname = nama.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "") + ext;
            Path path = Paths.get(UPLOADED_FOLDER + fullname);
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + fullname + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "pages/vacancy";
    }

    // @GetMapping(value="uploadStatus")
    // public ModelAndView uploadStatus() {
    // ModelAndView view = new ModelAndView("upload/uploadStatus");

    // File[] files = new File(UPLOADED_FOLDER).listFiles();
    // view.addObject("allfiles", files);

    // return view;
    // }
    @GetMapping(value = "modalUpload")
    public String viewModal() {
        return "pages/upload";
    }

}