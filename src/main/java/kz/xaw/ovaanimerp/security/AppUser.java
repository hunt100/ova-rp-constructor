package kz.xaw.ovaanimerp.security;

import kz.xaw.ovaanimerp.data.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;

@Entity
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private Boolean enable;

    @Column(name = "avatar_url", columnDefinition = "TEXT")
    private String avatarUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn (name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
