package com.example.requestprocessingservice.mapper;

import com.example.requestprocessingservice.dto.RequestDto;
import com.example.requestprocessingservice.model.Request;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    Request requestDtoToRequest(RequestDto requestDto);
    RequestDto requestToRequestDto(Request request);
    List<RequestDto> requestsToRequestsDto(List<Request> requestList);
    Set<RequestDto> requestsToRequestsDto(Set<Request> requests);
}
