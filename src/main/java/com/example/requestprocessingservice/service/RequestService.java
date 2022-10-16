package com.example.requestprocessingservice.service;

import com.example.requestprocessingservice.dto.RequestDto;
import com.example.requestprocessingservice.model.ElasticRequest;

import java.util.List;
import java.util.Set;

public interface RequestService {

    RequestDto createRequest(RequestDto requestDto);

    void addTagToRequest(Long requestId, Long tagId);

    void addFolderToRequest(Long requestId, Long folderId);

    List<RequestDto> getRequests();

    Set<RequestDto> getRequestsByTag(Long tagId);

    List<RequestDto> getRequestsByFolder(Long folderId);

    ElasticRequest getRequestByText(String text);
}
