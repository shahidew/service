package ir.maktab.service;

import ir.maktab.data.entity.Expert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageFileService {

    void uploadImageFile(MultipartFile image, Expert expert) throws IOException;
}
