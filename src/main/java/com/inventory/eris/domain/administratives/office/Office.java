package com.inventory.eris.domain.administratives.office;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import com.inventory.eris.utils.emailvalidation.UniqueEmail;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.inventory.eris.domain.administratives.role.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office implements UserDetails {

    private Long officeId;
    @UniqueEmail
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String contact;

    private AssignOffice assignOffice;

    private Role role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    private LocalDateTime deletedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleType().name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;

    }

}
