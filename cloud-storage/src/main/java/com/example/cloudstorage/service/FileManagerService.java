package com.example.cloudstorage.service;

import com.example.cloudstorage.model.File;
import com.example.cloudstorage.model.FileDto;
import com.example.cloudstorage.model.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class FileManagerService {

    @Autowired
    private FileRepository fileRepository;

    public void saveFile(MultipartFile file){
        try {
            fileRepository.save(new File(
                    file.getOriginalFilename(),
                    Base64.getEncoder().encodeToString(file.getBytes())
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterable<FileDto> getAllFiles(){
        List<FileDto> fileDtoList = new ArrayList<>();
        fileRepository.findAll().forEach(file -> fileDtoList.add(file.toFileDto()));
        return fileDtoList;
    }
}
