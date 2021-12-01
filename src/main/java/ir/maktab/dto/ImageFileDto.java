package ir.maktab.dto;

import ir.maktab.data.enums.ImageType;

public class ImageFileDto {
    private Long id;
    private byte[] data;
    private ImageType imageType;
    private ExpertDto expertDto;

    public Long getId() {
        return id;
    }

    public ImageFileDto setId(Long id) {
        this.id = id;
        return this;
    }

    public byte[] getData() {
        return data;
    }

    public ImageFileDto setData(byte[] data) {
        this.data = data;
        return this;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public ImageFileDto setImageType(ImageType imageType) {
        this.imageType = imageType;
        return this;
    }

    public ExpertDto getExpertDto() {
        return expertDto;
    }

    public ImageFileDto setExpertDto(ExpertDto expertDto) {
        this.expertDto = expertDto;
        return this;
    }
}
