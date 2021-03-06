/*
 * AbstractUserEntity.java
 * 
 * Copyright (C) 2011
 * 
 * This file is part of Proyecto persistenceGeo
 * 
 * This software is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General public abstract License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General public abstract License for more
 * details.
 * 
 * You should have received a copy of the GNU General public abstract License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * As a special exception, if you link this library with other files to produce
 * an executable, this library does not by itself cause the resulting executable
 * to be covered by the GNU General public abstract License. This exception does not
 * however invalidate any other reasons why the executable file might be covered
 * by the GNU General public abstract License.
 * 
 * Authors:: Alejandro Díaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.persistenceGeo.metaModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad de usuario
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 * 
 */
public abstract class AbstractUserEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2509076638431630708L;
	
	protected Long id;
	protected String username;

	protected String password;
	protected String nombreCompleto;
	protected String apellidos;
	protected String email;
	protected String telefono;
	protected Boolean admin;
	protected Boolean valid;
	protected Date createDate;
	protected Date updateDate;

	protected AbstractAuthorityEntity authority;

	/**
	 * @return the username
	 */
	public abstract String getUsername();

	/**
	 * @return the password
	 */
	public abstract String getPassword();

	/**
	 * @return the nombreCompleto
	 */
	public abstract String getNombreCompleto();

	/**
	 * @return the apellidos
	 */
	public abstract String getApellidos();

	/**
	 * @return the email
	 */
	public abstract String getEmail();

	/**
	 * @return the telefono
	 */
	public abstract String getTelefono();

	/**
	 * @return the admin
	 */
	public abstract Boolean getAdmin();

	/**
	 * @return the valid
	 */
	public abstract Boolean getValid();
	
	/**
	 * @return the createDate
	 */
	public abstract Date getCreateDate();
	
	/**
	 * @return the updateDate
	 */
	public abstract Date getUpdateDate();

	/**
	 * @return the authority
	 */
	public abstract AbstractAuthorityEntity getAuthority();

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setId(Serializable id) {
		this.id = (Long) id;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param nombreCompleto
	 *            the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setAuthority(AbstractAuthorityEntity authority) {
		this.authority = authority;
	}
}