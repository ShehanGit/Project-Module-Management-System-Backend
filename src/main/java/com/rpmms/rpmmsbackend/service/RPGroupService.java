package com.rpmms.rpmmsbackend.service;

import com.rpmms.rpmmsbackend.dto.RPGroupDTO;

import com.rpmms.rpmmsbackend.entity.RPGroup;
import com.rpmms.rpmmsbackend.repo.RPGroupRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import java.time.LocalDate;

@Service
@Transactional
public class RPGroupService {

    @Autowired
    private RPGroupRepo rpGroupRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Get the current year
    private static final int year = LocalDate.now().getYear();

    // Extract the last two digits of the year
    private static final int lastTwoDigitsOfYear = year % 100;

    private static final String PREFIX = "TEM-" + lastTwoDigitsOfYear + "-";
    private AtomicInteger groupIdCounter = new AtomicInteger(0); // Assuming starting from 0

    public String generateNextId() {
        int nextId = groupIdCounter.getAndIncrement();
        return PREFIX + String.format("%03d", nextId); // 3 digits result
    }

    public boolean existsByMember1SliitID(String sliitID) {
        return rpGroupRepo.existsByMember1StudentID(sliitID);
    }

    public boolean existsByMember2SliitID(String sliitID) {
        return rpGroupRepo.existsByMember2StudentID(sliitID);
    }

    public boolean existsByMember3SliitID(String sliitID) {
        return rpGroupRepo.existsByMember3StudentID(sliitID);
    }

    public boolean existsByMember4SliitID(String sliitID) {
        return rpGroupRepo.existsByMember4StudentID(sliitID);
    }

    public RPGroupDTO saveRPGroup(RPGroupDTO groupDTO) {
        rpGroupRepo.save(modelMapper.map(groupDTO, RPGroup.class));
        return groupDTO;
    }

    public List<RPGroupDTO> getAllRPGroups() {
        List<RPGroup> groupList = rpGroupRepo.findAll();
        return modelMapper.map(groupList, new TypeToken<List<RPGroupDTO>>() {
        }.getType());
    }

    public RPGroupDTO updateRPGroup(RPGroupDTO groupDTO) {
        rpGroupRepo.save(modelMapper.map(groupDTO, RPGroup.class));
        return groupDTO;
    }

    public boolean deleteRPGroup(RPGroupDTO groupDTO) {
        rpGroupRepo.delete(modelMapper.map(groupDTO, RPGroup.class));
        return true;
    }

    public RPGroupDTO getRPGroupByRPGroupID(String groupID) {
        RPGroup group = rpGroupRepo.getRPGroupByRPGroupID(groupID);
        return modelMapper.map(group, RPGroupDTO.class);
    }

}
