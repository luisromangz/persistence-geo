/*
 * RestZoneController.java
 *
 * Copyright (C) 2012
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
package com.emergya.persistenceGeo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emergya.persistenceGeo.dto.ZoneDto;
import com.emergya.persistenceGeo.service.ZoneAdminService;
import com.google.common.collect.Maps;

/**
 * Rest controller for zones
 *
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 */
@Controller
public class RestZoneController implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 4057357548084429491L;

	@Resource
	private ZoneAdminService zoneAdminService;

	protected final String RESULTS= "results";
	protected final String ROOT= "data";
	protected final String SUCCESS= "success";

	/**
	 * Get all zones in a zone
	 *
	 * @param idZone id zone to obtain children or null if you want all zones
	 *
	 * @return all zones if idZone is null or child zones of idZone otherwise
	 */
	@RequestMapping(value = "/persistenceGeo/getAllZones", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getAllZones(@RequestParam(value="idZone", required = false)String idZone) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ZoneDto> zones = null;
		try{
			if(idZone == null){
				zones = (List<ZoneDto>) zoneAdminService.findAllEnabled();
			}else{
				zones = (List<ZoneDto>) zoneAdminService.findByParent(Long.decode(idZone));
			}
			result.put(SUCCESS, true);
		}catch (Exception e){
			result.put(SUCCESS, false);
		}
		result.put(RESULTS, zones != null ? zones.size() : 0);
		result.put(ROOT, zones != null ? zones : ListUtils.EMPTY_LIST);

		return result;
	}

	/**
	 * Get all zones of a specific type
	 *
	 * @param type Type of the zone
	 *
	 * @return all zones of a specified type
	 */
	@RequestMapping(value = "/persistenceGeo/getZonesByType", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getZonesByType(@RequestParam(value="type", required = true)String zoneType) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ZoneDto> zones = null;
		try {
			zones = (List<ZoneDto>) zoneAdminService.findByType(zoneType, true);
			result.put(SUCCESS, true);
		} catch (Exception e) {
			result.put(SUCCESS, false);
		}
		result.put(RESULTS, zones != null ? zones.size() : 0);
		result.put(ROOT, zones != null ? zones : ListUtils.EMPTY_LIST);

		return result;
	}

	/**
	 * Get all zones with a specific parent
	 *
	 * @param Parent id (a zone)
	 *
	 * @return all zones of the specified parent
	 */
	@RequestMapping(value = "/persistenceGeo/getZonesByParent", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getZonesByParent(@RequestParam(value="parentId", required = true)Long parentId) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ZoneDto> zones = null;
		List<Map<String, Object>> zonesResult = null;
		try {
			zones = (List<ZoneDto>) zoneAdminService.findByParent(parentId);
			zonesResult = new ArrayList<Map<String,Object>>(zones.size());
			for (ZoneDto zone : zones) {
				Map<String, Object> zoneAux = Maps.newHashMap();
				zoneAux.put("id", zone.getId());
				zoneAux.put("code", zone.getCode());
				zoneAux.put("name", zone.getName());
				zoneAux.put("type", zone.getType());
				zoneAux.put("extension", zone.getExtension());
				zonesResult.add(zoneAux);
			}
			result.put(SUCCESS, true);
		} catch (Exception e) {
			result.put(SUCCESS, false);
		}
		result.put(RESULTS, zones != null ? zones.size() : 0);
		result.put(ROOT, zones != null ? zonesResult : ListUtils.EMPTY_LIST);

		return result;
	}

}
