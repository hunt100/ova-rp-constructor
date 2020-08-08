package kz.xaw.ovaanimerp.service.listener;

import kz.xaw.ovaanimerp.security.AppUser;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private String appUrl;
    private Locale locale;
    private AppUser appUser;

    public OnRegistrationCompleteEvent(String appUrl, Locale locale, AppUser appUser) {
        super(appUser);
        this.appUrl = appUrl;
        this.locale = locale;
        this.appUser = appUser;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
