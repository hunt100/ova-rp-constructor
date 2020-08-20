package kz.xaw.ovaanimerp.data.forms;

import com.cloudinary.StoredFile;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploadForm extends BaseForm {

    private String title;
    private MultipartFile multipartFile;
    private StoredFile storedFile;
    private String plainUrl;

    public ImageUploadForm() {
        this.storedFile = new StoredFile();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public StoredFile getStoredFile() {
        return storedFile;
    }

    public void setStoredFile(StoredFile storedFile) {
        this.storedFile = storedFile;
    }

    public String getPlainUrl() {
        return plainUrl;
    }

    public void setPlainUrl(String plainUrl) {
        this.plainUrl = plainUrl;
    }
}
