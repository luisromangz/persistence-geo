/*
 * AbstractSourceToolEntity.java Copyright (C) 2013. This file is part of persistenceGeo project
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
 * Authors:: Alejandro Diaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.persistenceGeo.metaModel;


/**
 * Source tool entity
 * 
 * @author <a href="mailto:adiaz@emergya.com">Alejandro Diaz</a>
 *
 */
public abstract class AbstractSourceToolEntity extends AbstractToolEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8018539904698841688L;
	
	protected String url;

	/**
	 * @return the url
	 */
	public abstract String getUrl();

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


}
