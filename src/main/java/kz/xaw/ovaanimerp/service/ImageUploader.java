package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Image;
import kz.xaw.ovaanimerp.data.forms.ImageUploadForm;

public interface ImageUploader {

    Image uploadImage(ImageUploadForm form);
}
