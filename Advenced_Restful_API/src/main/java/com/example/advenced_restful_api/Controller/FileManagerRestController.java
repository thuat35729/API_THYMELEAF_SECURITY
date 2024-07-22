package com.example.advenced_restful_api.Controller;

import com.example.advenced_restful_api.Service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/files")
public class FileManagerRestController {
    @Autowired
    FileManagerService fileManagerService;

    @GetMapping("/{folder}/{file}")
    public byte[] download(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return fileManagerService.read(folder, file);
    }

    @PostMapping("/{folder}")
    public List<String> upload(@PathVariable("folder") String folder, @RequestParam("files") MultipartFile[] files) {
        return fileManagerService.save(folder, files);
    }

    @DeleteMapping("/{folder}/{file}")
    public void delete(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        fileManagerService.delete(folder, file);
    }

    @GetMapping("/{folder}")
    public List<String> list(@PathVariable("folder") String folder) {
        return fileManagerService.list(folder);
    }
}
