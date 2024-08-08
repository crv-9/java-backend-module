package io.everyonecodes.w1springbeans.mysterioussecretorder.model;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Member {
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private Set<String> authorities = new HashSet<>();

    public Member() {
    }

    public Member(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Member(String id, String username, String password, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return Objects.equals(id, member.id) && Objects.equals(username, member.username) && Objects.equals(password, member.password) && Objects.equals(authorities, member.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }
}
