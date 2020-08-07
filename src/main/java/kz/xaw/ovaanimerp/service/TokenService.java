package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Token;
import kz.xaw.ovaanimerp.repository.TokenRepository;
import kz.xaw.ovaanimerp.security.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class TokenService {

    private static final String TOKEN_INVALID = "invalidToken";
    private static final String TOKEN_EXPIRED = "expired";
    private static final String TOKEN_VALID = "valid";
    private final TokenRepository tokenRepository;
    private final AppUserService appUserService;

    @Autowired
    public TokenService(TokenRepository tokenRepository, AppUserService appUserService) {
        this.tokenRepository = tokenRepository;
        this.appUserService = appUserService;
    }

    @Transactional
    public void createVerificationToken(AppUser appUser, String token) {
        final Token dbToken = new Token(appUser, token);
        tokenRepository.save(dbToken);
    }

    @Transactional
    public String validateVerificationToken(String token) {
        Token verificationToken = tokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException(TOKEN_INVALID));

        final AppUser user = verificationToken.getUser();
        final LocalDateTime now = LocalDateTime.now();
        if (now.compareTo(verificationToken.getExpiryDate()) > 0) {
            tokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setEnable(true);
        appUserService.save(user);
        return TOKEN_VALID;
    }

    @Transactional
    public AppUser getAppUserByLogin(String token) {
        return tokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException(TOKEN_INVALID)).getUser();
    }
}
