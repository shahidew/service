package ir.maktab.service;

import ir.maktab.data.entity.ImageFile;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.enums.ImageType;
import ir.maktab.data.repository.ImageFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageFileServiceImpl implements ImageFileService {

    private final ImageFileRepository repository;

    public ImageFileServiceImpl(ImageFileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void uploadImageFile(MultipartFile image, Expert expert) throws IOException {
        ImageFile imageFile = new ImageFile();
        imageFile.setData(image.getBytes());
        imageFile.setImageType(ImageType.PROFILE);
        imageFile.setExpert(expert);
        repository.save(imageFile);
    }
}
