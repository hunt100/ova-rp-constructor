package kz.xaw.ovaanimerp.data.forms;

import kz.xaw.ovaanimerp.annotation.constraint.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@FieldMatch(first = "password", second = "passwordConfirm", message = "{error.password.not.same}")
public class AppUserForm extends BaseForm{

    @NotBlank(message = "{error.login.required}")
    @Email
    private String login;
    @NotBlank(message = "{error.password.required}")
    private String password;
    @NotBlank(message = "{error.passwordConfirm.required}")
    private String passwordConfirm;
    private Boolean enable;
    private String avatarUrl;
    private List<RoleForm> roles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<RoleForm> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleForm> roles) {
        this.roles = roles;
    }
}
