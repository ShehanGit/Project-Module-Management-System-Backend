package com.rpmms.rpmmsbackend.repo;

import com.rpmms.rpmmsbackend.entity.RPGroup;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RPGroupRepo extends JpaRepository<RPGroup, Integer> {

    @Query(value = "SELECT * FROM RPGROUP WHERE GROUPID = ?1", nativeQuery = true)
    RPGroup getRPGroupByRPGroupID(String groupId);

    boolean existsByMember1StudentID(String member1StudentID);

    boolean existsByMember2StudentID(String member2StudentID);

    boolean existsByMember3StudentID(String member3StudentID);

    boolean existsByMember4StudentID(String member4StudentID);
}
