package kz.xaw.ovaanimerp.controller;

import kz.xaw.ovaanimerp.security.AppUser;
import kz.xaw.ovaanimerp.service.AppUserService;
import kz.xaw.ovaanimerp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;
    private final AppUserService appUserService;

    @Autowired
    public ImageController(ImageService imageService, AppUserService appUserService) {
        this.imageService = imageService;
        this.appUserService = appUserService;
    }

    @GetMapping
    public String getHtml() {
        return "photo";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        AppUser currentUser = appUserService.findUserByUsername(currentPrincipalName);
        imageService.changeUserAvatar(currentUser.getId(), file);
        return "redirect:/image";
    }
}
