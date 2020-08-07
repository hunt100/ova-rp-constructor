package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.forms.AppUserForm;
import kz.xaw.ovaanimerp.repository.AppUserRepository;
import kz.xaw.ovaanimerp.security.AppUser;
import kz.xaw.ovaanimerp.security.Role;
import kz.xaw.ovaanimerp.service.gateway.smtp.SmtpMailGateway;
import kz.xaw.ovaanimerp.service.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final SmtpMailGateway smtpMailGateway;
    private final AppUserMapper appUserMapper;
    private final RoleService roleService;

    @Value("${dicebear.avatar.url}")
    private String avatarUrl;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, SmtpMailGateway smtpMailGateway, AppUserMapper appUserMapper, RoleService roleService) {
        this.appUserRepository = appUserRepository;
        this.smtpMailGateway = smtpMailGateway;
        this.appUserMapper = appUserMapper;
        this.roleService = roleService;
    }

    @Transactional
    public AppUser registerNewUser(AppUserForm form) {
        if (validateIfUserExist(form.getLogin())) {
            throw new RuntimeException("Exception");
        }
        AppUser newUser = appUserMapper.formToEntity(form);
        newUser.setAvatarUrl(getAvatar());
        newUser.setEnable(false);
        newUser.setRoles(Collections.singleton(roleService.findByName(Role.ROLE_USER)));
        return appUserRepository.save(newUser);
    }

    private boolean validateIfUserExist(String login) {
        return appUserRepository.findByLogin(login).isPresent();
    }

    private String getAvatar() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 12;
        try {
            Random random = SecureRandom.getInstanceStrong();
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            return avatarUrl + generatedString + ".svg";
        } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         throw new RuntimeException(e.getMessage());
        }
    }


    @Transactional
    public void save(AppUser user) {
        appUserRepository.save(user);
    }
}
