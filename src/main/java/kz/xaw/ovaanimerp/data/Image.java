package kz.xaw.ovaanimerp.data;

import com.cloudinary.StoredFile;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "images")
public class Image extends BaseEntity {

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column
    private String publicId;

    @Column(columnDefinition = "TEXT")
    private String plainUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StoredFile getUpload() {
        StoredFile file = new StoredFile();
        file.setPreloadedFile(image);
        return file;
    }

    public void setUpload(StoredFile file) {
        this.image = file.getPreloadedFile();
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getPlainUrl() {
        return plainUrl;
    }

    public void setPlainUrl(String plainUrl) {
        this.plainUrl = plainUrl;
    }
}
