package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Image;
import kz.xaw.ovaanimerp.data.forms.ImageUploadForm;
import kz.xaw.ovaanimerp.repository.AppUserRepository;
import kz.xaw.ovaanimerp.security.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
public class ImageService {

    private final AppUserRepository appUserRepository;
    private ImageUploader imageUploader;

    @Autowired
    public ImageService(AppUserRepository userRepository,
                        ImageUploader imageUploader) {
        this.appUserRepository = userRepository;
        this.imageUploader = imageUploader;
    }

    @Transactional
    public void changeUserAvatar(Long userId, MultipartFile file) {
        final AppUser appUser = appUserRepository.findById(userId).orElseThrow();
        ImageUploadForm form = new ImageUploadForm();
        form.setMultipartFile(file);
        form.setTitle(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.')));
        Image image = imageUploader.uploadImage(form);
        appUser.setImage(image);
        appUserRepository.save(appUser);
    }
}
