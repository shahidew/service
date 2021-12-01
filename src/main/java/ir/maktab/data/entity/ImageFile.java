package ir.maktab.data.entity;

import ir.maktab.data.enums.ImageType;

import javax.persistence.*;

@Entity
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

    @Enumerated(value = EnumType.STRING)
    private ImageType imageType;

    @ManyToOne(targetEntity = Expert.class, cascade = CascadeType.ALL)
    private Expert expert;

    public ImageFile setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public ImageFile setData(byte[] data) {
        this.data = data;
        return this;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public ImageFile setImageType(ImageType imageType) {
        this.imageType = imageType;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public ImageFile setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }
}
