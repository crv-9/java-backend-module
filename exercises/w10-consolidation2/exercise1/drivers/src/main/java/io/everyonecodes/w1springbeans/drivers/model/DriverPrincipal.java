package io.everyonecodes.w1springbeans.drivers.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;



// The user that we load from the database is not the one that Spring expects to receive
// we create another user class only for security operations that implements UserDetails,
public class DriverPrincipal implements UserDetails {

    // inject your class
    private final Driver driver;

    public DriverPrincipal(Driver driver) {
        this.driver = driver;
    }

    // modify to obtain the Set from your class
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> authorities = driver.getAuthorities();
        return AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()]));
    }

    // methods below added from implementation of UserDetails

    // modify the return, it originally comes only with ""
    @Override
    public String getPassword() {
        return driver.getPassword();
    }

    // modify the return, it originally comes only with ""
    @Override
    public String getUsername() {
        return driver.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
