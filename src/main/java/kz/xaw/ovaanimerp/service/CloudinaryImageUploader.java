package kz.xaw.ovaanimerp.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kz.xaw.ovaanimerp.data.Image;
import kz.xaw.ovaanimerp.data.forms.ImageUploadForm;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@Profile("dev")
public class CloudinaryImageUploader implements ImageUploader {

    private static final Logger log = LoggerFactory.getLogger(CloudinaryImageUploader.class);
    private static final String CLOUDINARY_FOLDER = "ova-rp/";
    private final Map params = ObjectUtils.asMap(
            "overwrite", true,
            "resource_type", "image"
    );

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryImageUploader(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    @Async
    public Image uploadImage(ImageUploadForm form) {
        try {
            return enrichRequest(form);
        }catch (Exception e) {
            log.error("Error occurred: ", e);
            throw new RuntimeException("uploadImage() -> Exception appeared:");
        }
    }

    private Image enrichRequest(ImageUploadForm form) {
        try {
            Map<?,?> uploadResult = sendRequest(form.getMultipartFile().getBytes(), CLOUDINARY_FOLDER + form.getTitle());

            form.getStoredFile().setPublicId((String) uploadResult.get("public_id"));
            Object version = uploadResult.get("version");
            if (version instanceof Integer) {
                form.getStoredFile().setVersion(Long.valueOf((Integer) version));
            } else {
                form.getStoredFile().setVersion((Long) version);
            }
            form.getStoredFile().setSignature((String) uploadResult.get("signature"));
            form.getStoredFile().setFormat((String) uploadResult.get("format"));
            form.getStoredFile().setResourceType((String) uploadResult.get("resource_type"));
            form.setPlainUrl((String) uploadResult.get("url"));

            Image image = new Image();
            image.setTitle(form.getTitle());
            image.setUpload(form.getStoredFile());
            image.setPublicId(form.getStoredFile().getPublicId());
            image.setPlainUrl(form.getPlainUrl());
            return image;
        } catch (Exception e) {
            log.error("Error appeared: ", e);
            return ExceptionUtils.rethrow(e);
        }
    }

    private Map sendRequest(byte[] file, String title) {
        try {
            params.put("public_id", CLOUDINARY_FOLDER + title);
            Map uploadResult = cloudinary.uploader().upload(file, params);
            return uploadResult;
        } catch (IOException e) {
            log.error("Exception appear: ", e);
            throw new RuntimeException("sendRequest() -> IOException");
        }

    }


    private void testConnection() {
        try {
            Map result = cloudinary.api().resource("sample", ObjectUtils.emptyMap());
            log.info("-------CLOUDINARY TEST CONNECTION:-------- \n{}", result.toString());
        } catch (Exception e) {
            log.error("Error appeared during test connection: ", e);
        }
    }
}
