package com.rpmms.rpmmsbackend.controller;

import com.rpmms.rpmmsbackend.dto.RPGroupDTO;
import com.rpmms.rpmmsbackend.service.RPGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "rpmms/api/rpgroup")
@CrossOrigin
public class RPGroupController {

    @Autowired
    private RPGroupService rpgroupService;

    @GetMapping("/getGroups")
    public List<RPGroupDTO> getRPGroups() {
        return rpgroupService.getAllRPGroups();
    }

    @PostMapping("/saveGroup")
    public ResponseEntity<?> saveRPGroup(@RequestBody RPGroupDTO rpGroupDTO) {

        // Check if the leader_studentID matches any of the memberStudentIDs
        String leaderStudentID = rpGroupDTO.getLeader_studentID();
        String[] memberStudentIDs = { rpGroupDTO.getMember1StudentID(), rpGroupDTO.getMember2StudentID(),
                rpGroupDTO.getMember3StudentID(), rpGroupDTO.getMember4StudentID() };
        boolean isLeaderStudentIDValid = Arrays.asList(memberStudentIDs).contains(leaderStudentID);

        if (!isLeaderStudentIDValid) {
            return ResponseEntity.badRequest().body("Leader student ID must be one of the member student IDs.");
        }

        // // Check if the SLIIT ID already exists in the database
        StringBuilder errorMessageBuilder = new StringBuilder();

        if (rpgroupService.existsByMember1SliitID(rpGroupDTO.getMember1StudentID())) {
            errorMessageBuilder.append("Member 1 with the student registration number ")
                    .append(rpGroupDTO.getMember1StudentID()).append(" already registered for a group.\n");
        }

        if (rpgroupService.existsByMember2SliitID(rpGroupDTO.getMember2StudentID())) {
            errorMessageBuilder.append("Member 2 with the student registration number ")
                    .append(rpGroupDTO.getMember2StudentID()).append(" already registered for a group.\n");
        }

        if (rpgroupService.existsByMember3SliitID(rpGroupDTO.getMember3StudentID())) {
            errorMessageBuilder.append("Member 3 with the student registration number ")
                    .append(rpGroupDTO.getMember3StudentID()).append(" already registered for a group.\n");
        }

        if (rpgroupService.existsByMember4SliitID(rpGroupDTO.getMember4StudentID())) {
            errorMessageBuilder.append("Member 4 with the student registration number ")
                    .append(rpGroupDTO.getMember4StudentID()).append(" already registered for a group.\n");
        }

        if (errorMessageBuilder.length() > 0) {
            return ResponseEntity.badRequest().body(errorMessageBuilder.toString());
        } else {
            rpGroupDTO.setGroupID(rpgroupService.generateNextId());
            rpgroupService.saveRPGroup(rpGroupDTO);
            return ResponseEntity.ok("Group saved successfully");
        }
    }

    @PutMapping("/updateGroup")
    public RPGroupDTO updateRPGroup(@RequestBody RPGroupDTO rpGroupDTO) {
        return rpgroupService.updateRPGroup(rpGroupDTO);
    }

    @DeleteMapping("/deleteGroup")
    public boolean deleteRPGroup(@RequestBody RPGroupDTO rpGroupDTO) {
        return rpgroupService.deleteRPGroup(rpGroupDTO);
    }

    @GetMapping("/getGroupByGroupId/{groupID}")
    public RPGroupDTO getRPGroupByRPGroupID(@PathVariable String groupID) {
        return rpgroupService.getRPGroupByRPGroupID(groupID);
    }

}
