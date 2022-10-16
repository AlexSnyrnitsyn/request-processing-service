package com.example.requestprocessingservice.service;

import com.example.requestprocessingservice.dto.RequestDto;
import com.example.requestprocessingservice.elasticrepository.RequestElasticRepository;
import com.example.requestprocessingservice.enums.ResponseCode;
import com.example.requestprocessingservice.error.EntityNotFoundException;
import com.example.requestprocessingservice.mapper.RequestMapper;
import com.example.requestprocessingservice.model.ElasticRequest;
import com.example.requestprocessingservice.model.Folder;
import com.example.requestprocessingservice.model.Request;
import com.example.requestprocessingservice.model.Tag;
import com.example.requestprocessingservice.repository.FolderRepository;
import com.example.requestprocessingservice.repository.RequestRepository;
import com.example.requestprocessingservice.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RequestServiceImp implements RequestService{

    private final RequestRepository requestRepository;
    private final FolderRepository folderRepository;
    private final TagRepository tagsRepository;
    private final RequestMapper requestMapper;
    private final RequestElasticRepository requestElasticRepository;
    @Value("${tag.limit}")
    private int tagLimit;

    @Override
    public RequestDto createRequest(RequestDto requestDto) {
        log.info("add request begin");
        Request request = requestMapper.requestDtoToRequest(requestDto);
        requestRepository.save(request);
        requestElasticRepository.save(ElasticRequest.builder().id(request.getId()).text(request.getText()).
                modifiedDate(request.getModifiedDate()).length(request.getLength()).build());
        log.info("request add success");
        return requestMapper.requestToRequestDto(request);
    }

    @Override
    public void addTagToRequest(Long requestId, Long tagId) {
        log.info("add tags to request begin");
        Request request = requestRepository.findById(requestId).
                orElseThrow(()-> new EntityNotFoundException(ResponseCode.REQUEST_NOT_FOUND));
        Tag tag = tagsRepository.findById(tagId).
                orElseThrow(()-> new EntityNotFoundException(ResponseCode.TAG_NOT_FOUND));

        Set<Tag> tags = request.getTags();
        if (tags.size() < tagLimit) {
            tags.add(tag);
        } else {
            throw new EntityNotFoundException(ResponseCode.REQUEST_GAT_LINK_ERROR);
        }
        request.setTags(tags);
        requestRepository.save(request);
        log.info("tags to request add success");
    }

    @Override
    public void addFolderToRequest(Long requestId, Long folderId) {
        log.info("add folder to request begin");
        Request request = requestRepository.findById(requestId).
                orElseThrow(()-> new EntityNotFoundException(ResponseCode.REQUEST_NOT_FOUND));
        Folder folder = folderRepository.findById(folderId).
                orElseThrow(()-> new EntityNotFoundException(ResponseCode.FOLDER_NOT_FOUND));
        request.setFolder(folder);
        requestRepository.save(request);
        log.info("folder to request add success");
    }

    @Override
    public List<RequestDto> getRequests() {
        log.info("get requestList begin");
        List<Request> requestList = requestRepository.findAll();
        log.info("get requestList success with result" + requestList.size());
        return requestMapper.requestsToRequestsDto(requestList);
    }

    @Override
    public Set<RequestDto> getRequestsByTag(Long tagId) {
        log.info("get requestSetByTeg begin");
        Set<Request> requestSet = requestRepository.findByTags_Id(tagId);
        log.info("requestSet get success");
        return requestMapper.requestsToRequestsDto(requestSet);
    }

    @Override
    public List<RequestDto> getRequestsByFolder(Long folderId) {
        log.info("get requestListByFolder begin");
        List<Request> requestList = requestRepository.findByFolder_Id(folderId);
        log.info("requestList get success");
        return requestMapper.requestsToRequestsDto(requestList);
    }

    @Override
    public ElasticRequest getRequestByText(String text) {
        log.info("get requestListByFolder begin");
        ElasticRequest elasticRequest = requestElasticRepository.findByText(text);
        log.info("requestList get success");
        return elasticRequest;
    }
}
