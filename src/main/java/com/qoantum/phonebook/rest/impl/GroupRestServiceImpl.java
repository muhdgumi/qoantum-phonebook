package com.qoantum.phonebook.rest.impl;

import com.qoantum.phonebook.api.GroupDto;
import com.qoantum.phonebook.remote.GroupRemoteService;
import com.qoantum.phonebook.rest.GroupRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class GroupRestServiceImpl implements GroupRestService {

    @Autowired
    private GroupRemoteService groupRemoteService;

    @Override
    @ResponseBody
    @RequestMapping(
            path = GROUP_BASE,
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public GroupDto createGroup(@Valid @RequestBody GroupDto groupDto) {
        return groupRemoteService.createGroup(groupDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = GROUP_BASE_GROUP_ID,
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public GroupDto getGroup(@NotNull @PathVariable Long groupId) {
        return groupRemoteService.getGroup(groupId);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = GROUP_BASE,
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public GroupDto updateGroup(@Valid @RequestBody GroupDto groupDto) {
        return groupRemoteService.updateGroup(groupDto);
    }

    @Override
    @ResponseBody
    @RequestMapping(
            path = GROUP_BASE_GROUP_ID,
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void deleteGroup(@NotNull @PathVariable Long groupId) {
        groupRemoteService.deleteGroup(groupId);
    }
}
