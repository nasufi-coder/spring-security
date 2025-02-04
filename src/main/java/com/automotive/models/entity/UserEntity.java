package com.automotive.models.entity;

import com.automotive.models.entity.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private RoleEnum role;

    private boolean isAccountNonLocked;
    private boolean isEnabled;

    // New field to store the photo as a blob
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] photo;

    @OneToMany(mappedBy = "ownedBy")
    private Set<AutoEntity> autos;

    @OneToMany(mappedBy = "bookedBy")
    private Set<BookingEntity> bookings;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(getRole().toString()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Other UserDetails methods are implemented as required...
}
