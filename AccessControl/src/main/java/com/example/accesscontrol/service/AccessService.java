package com.example.accesscontrol.service;


import com.example.accesscontrol.converter.AccessConverter;
import com.example.accesscontrol.dto.AccessCreateDto;
import com.example.accesscontrol.dto.AccessDto;
import com.example.accesscontrol.dto.AccessEntryDto;
import com.example.accesscontrol.dto.AccessOutDto;
import com.example.accesscontrol.repository.AccessRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AccessService {
    @EJB
    private AccessRepository accessRepository;
    @EJB
    private AccessConverter accessConverter;

    public AccessEntryDto create(AccessCreateDto accessCreateDto) {
        return null;
    }

    public AccessDto get(Long id) {
        return null;
    }

    public AccessOutDto update(Long id) {
        return null;
    }
}
