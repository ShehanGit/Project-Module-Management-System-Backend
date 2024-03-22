package com.rpmms.rpmmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RPGroupDTO {
    private String groupID;
    private String member1_name;
    private String member1StudentID;
    private String member1_contact_number;
    private String member1_email;
    private String member1_batch;
    private String member1_specialization;
    private String member2_name;
    private String member2StudentID;
    private String member2_contact_number;
    private String member2_email;
    private String member2_batch;
    private String member2_specialization;
    private String member3_name;
    private String member3StudentID;
    private String member3_contact_number;
    private String member3_email;
    private String member3_batch;
    private String member3_specialization;
    private String member4_name;
    private String member4StudentID;
    private String member4_contact_number;
    private String member4_email;
    private String member4_batch;
    private String member4_specialization;
    private String leader_name;
    private String leader_studentID;
    private String project_title;
    private String research_area;
    private String research_group;
    private String supervisor;
    private String co_supervisor;
}
