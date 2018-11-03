package com.example.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_roles", 
	uniqueConstraints=@UniqueConstraint(
		columnNames= {"rol", "username"}
		)
	)
public class Rol  implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="user_role_id", unique=true, nullable=false)
    private Integer userRoleId;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="username", nullable=false)
    private Usuario user;
    @Column(name="rol", nullable=false, length=45)
    private String role;

    public Rol() {
            super();
    }

    public Rol(Usuario user, String role) {
            super();
            this.user = user;
            this.role = role;
    }

    public Integer getRolId() {
            return userRoleId;
    }

    public void setRolId(Integer userRoleId) {
            this.userRoleId = userRoleId;
    }

    public Usuario getUsuario() {
            return user;
    }

    public void setUsuario(Usuario user) {
            this.user = user;
    }

    public String getRole() {
            return role;
    }

    public void setRole(String role) {
            this.role = role;
    }
	
}
