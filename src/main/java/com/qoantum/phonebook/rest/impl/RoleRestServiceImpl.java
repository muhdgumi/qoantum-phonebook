package com.qoantum.phonebook.rest.impl;

import com.qoantum.phonebook.api.RoleDto;
import com.qoantum.phonebook.remote.RoleRemoteService;
import com.qoantum.phonebook.rest.RoleRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class RoleRestServiceImpl implements RoleRestService {

    @Autowired
    private RoleRemoteService roleRemoteService;

    @Override
    @ResponseBody
    @RequestMapping(
            path = ROLE_BASE,
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public RoleDto createRole(@Valid @RequestBody RoleDto roleDto) {
        return roleRemoteService.createRole(roleDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = ROLE_BASE_ROLE_ID,
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public RoleDto getRole(@NotNull @PathVariable Long roleId) {
        return roleRemoteService.getRole(roleId);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = ROLE_BASE,
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public RoleDto updateRole(@Valid @RequestBody RoleDto roleDto) {
        return roleRemoteService.updateRole(roleDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = ROLE_BASE_ROLE_ID,
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void deleteRole(@NotNull @PathVariable Long roleId) {
        roleRemoteService.deleteRole(roleId);
    }
}
