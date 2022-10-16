package com.example.requestprocessingservice.repository;

import com.example.requestprocessingservice.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Set<Request> findByTags_Id(Long tagId);

    List<Request> findByFolder_Id(Long folderId);

}
