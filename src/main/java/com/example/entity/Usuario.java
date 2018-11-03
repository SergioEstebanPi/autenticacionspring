package com.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Usuario  implements Serializable {
    @Id
    @Column(name="username", unique=true, nullable=false, length=45)
    private String username;
    @Column(name="password", nullable=false, length=60)
    private String password;
    @Column(name="enabled", nullable=false)
    private boolean enabled;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="user")
    private Set<Rol> userRole = new HashSet<>();

    public Usuario() {
            super();
    }
    public Usuario(String username, String password, boolean enabled) {
            super();
            this.username = username;
            this.password = password;
            this.enabled = enabled;
    }
    public Usuario(String username, String password, boolean enabled, Set<Rol> userRole) {
            super();
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.userRole = userRole;
    }
    public String getUsuarioname() {
            return username;
    }
    public void setUsuarioname(String username) {
            this.username = username;
    }
    public String getPassword() {
            return password;
    }
    public void setPassword(String password) {
            this.password = password;
    }
    public boolean isEnabled() {
            return enabled;
    }
    public void setEnabled(boolean enabled) {
            this.enabled = enabled;
    }
    public Set<Rol> getRol() {
            return userRole;
    }
    public void setRol(Set<Rol> userRole) {
            this.userRole = userRole;
    }
	
}
