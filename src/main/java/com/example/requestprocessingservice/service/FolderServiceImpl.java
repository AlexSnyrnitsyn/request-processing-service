package com.example.requestprocessingservice.service;

import com.example.requestprocessingservice.dto.FolderDto;
import com.example.requestprocessingservice.mapper.FolderMapper;
import com.example.requestprocessingservice.model.Folder;
import com.example.requestprocessingservice.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final FolderMapper folderMapper;

    @Override
    public FolderDto createFolder(FolderDto folderDto) {
        log.info("add folder begin");
        Folder folder = folderMapper.folderDtoToFolder(folderDto);
        folderRepository.save(folder);
        log.info("folder add success");
        return folderMapper.folderToFolderDto(folder);
    }

    @Override
    public List<FolderDto> getFolders() {
        log.info("get folderList begin");
        List<Folder> foldersList = folderRepository.findAll();
        log.info("get folderList success with result" + foldersList.size());
        return folderMapper.folderListToFolderListDto(foldersList);
    }
}
