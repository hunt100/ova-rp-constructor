package kz.xaw.ovaanimerp.controller.api;

import kz.xaw.ovaanimerp.data.constant.ApiConstants;
import kz.xaw.ovaanimerp.data.forms.AppUserForm;
import kz.xaw.ovaanimerp.data.forms.JwtRequest;
import kz.xaw.ovaanimerp.security.AppUserDetailsService;
import kz.xaw.ovaanimerp.security.JwtTokenService;
import kz.xaw.ovaanimerp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(ApiConstants.API_PREFIX)
public class AndroidLoginController {

    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService userDetailsService;
    private final JwtTokenService jwtTokenService;
    private final AppUserService appUserService;

    @Autowired
    public AndroidLoginController(AuthenticationManager authenticationManager,
                                  AppUserDetailsService userDetailsService,
                                  JwtTokenService jwtTokenService,
                                  AppUserService appUserService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenService = jwtTokenService;
        this.appUserService = appUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginWithAuthenticationToken(@RequestBody JwtRequest request) throws Exception {
        authenticate(request.getLogin(), request.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        final String token = jwtTokenService.generateToken(userDetails);
        Map<String, Object> customResponse = new HashMap<>();
        customResponse.put("jwttoken", token);
        return ResponseEntity.ok(customResponse);
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> saveUser (@RequestBody @Valid AppUserForm user, BindingResult result) {
            if (result.hasErrors()) {
                return  ResponseEntity.badRequest().build();
            }
            appUserService.registerNewUser(user);
            return ResponseEntity.ok().build();
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
