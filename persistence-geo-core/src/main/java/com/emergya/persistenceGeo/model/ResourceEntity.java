/*
 * ResourceEntity.java
 * 
 * Copyright (C) 2013
 * 
 * This file is part of Proyecto persistenceGeo
 * 
 * This software is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * As a special exception, if you link this library with other files to produce
 * an executable, this library does not by itself cause the resulting executable
 * to be covered by the GNU General Public License. This exception does not
 * however invalidate any other reasons why the executable file might be covered
 * by the GNU General Public License.
 * 
 * Authors:: Alejandro Díaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.persistenceGeo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.emergya.persistenceGeo.metaModel.AbstractResourceEntity;

/**
 * Resource entity mapping
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 *
 */
@Entity
@Table(name = "gis_resource")
public class ResourceEntity extends AbstractResourceEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1388101386914081253L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, 
    				generator = "gis_resource_seq")
    @SequenceGenerator(name="gis_resource_seq", 
    					sequenceName = "gis_resource_seq")  
	public Long getId() {
		return this.id;
	}

    @Column(name = "name")
	public String getName() {
		return this.name;
	}

    @Column(name = "size")
	public Long getSize() {
		return size;
	}

    @Column(name = "type")
	public String getType() {
		return null;
	}

    @Column(name = "access_id")
	public Long getAccessId() {
		return accessId;
	}
	@Column(name = "data", nullable=true)
	@Type(type="org.hibernate.type.PrimitiveByteArrayBlobType") //Needed for oracle/postgresql compatibility
	@Lob //Needed for oracle/postgresql compatibility
	public byte[] getData() {
		return data;
	}

}
