package geekBrains.security.configs;

import java.util.Collection;
import java.util.stream.Collectors;

import geekBrains.security.entities.Role;
import geekBrains.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {

    private User user;

    @Autowired
    public CustomUserDetail(User user) {
        this.user = user;
    }

    @Override  //метод должен вернуть из списка ролей у пользователя (преобразовать его) -> список авторитиз для
    //данного пользователя (т.е. у пользователя будет список допусков (ауторитиез) (1:15 - видео в папке)
    //метод из пачки ролей делает пачку авторитиз
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
//        return user.getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
