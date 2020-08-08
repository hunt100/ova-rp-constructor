package kz.xaw.ovaanimerp.controller;

import kz.xaw.ovaanimerp.data.forms.AppUserForm;
import kz.xaw.ovaanimerp.security.AppUser;
import kz.xaw.ovaanimerp.service.AppUserService;
import kz.xaw.ovaanimerp.service.TokenService;
import kz.xaw.ovaanimerp.service.listener.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping(AppUserController.REGISTRATION_PATH)
public class AppUserController {

    static final String REGISTRATION_PATH = "/registration";
    private static final String REGISTER_PAGE = "register-page";

    private final AppUserService appUserService;
    private final ApplicationEventPublisher eventPublisher;
    private final TokenService tokenService;

    @Autowired
    public AppUserController(AppUserService appUserService, ApplicationEventPublisher eventPublisher, TokenService tokenService) {
        this.appUserService = appUserService;
        this.eventPublisher = eventPublisher;
        this.tokenService = tokenService;
    }

    @GetMapping
    public String getAppUserPage(Model model) {
        model.addAttribute("newUser", new AppUserForm());
        return REGISTER_PAGE;
    }

    @PostMapping
    public String saveNewUser(@ModelAttribute("newUser") @Valid AppUserForm form,
                              BindingResult result,
                              RedirectAttributes attributes,
                              HttpServletRequest request) {
        if (result.hasErrors()) {
            return REGISTER_PAGE;
        }
        AppUser createdUser = appUserService.registerNewUser(form);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(request.getContextPath(), request.getLocale(), createdUser));
        attributes.addFlashAttribute("success",true);
        return sendRedirect(REGISTRATION_PATH);
    }

    @GetMapping("/registrationConfirm")
    public String confirmRegistration(WebRequest request, @RequestParam("token") String token) {

        Locale locale = request.getLocale();

        final String verificationToken = tokenService.validateVerificationToken(token);
        if (verificationToken.equals("valid")) {
            final AppUser appUser = tokenService.getAppUserByLogin(token);
            authWithoutPassword(appUser);
            return sendRedirect("/");
        } else {
            System.out.println("problem problem problem problem");
            return sendRedirect(REGISTRATION_PATH);
        }
    }

    private String sendRedirect(String url) {
        return "redirect:" + url;
    }

    private void authWithoutPassword(AppUser appUser) {
//        List<Privilege> privileges = user.getRoles()
//                .stream()
//                .map(Role::getPrivileges)
//                .flatMap(Collection::stream)
//                .distinct()
//                .collect(Collectors.toList());

        List<GrantedAuthority> authorities = appUser.getRoles().stream()
                .map(p -> new SimpleGrantedAuthority(p.getName()))
                .collect(Collectors.toList());

        Authentication authentication = new UsernamePasswordAuthenticationToken(appUser, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
