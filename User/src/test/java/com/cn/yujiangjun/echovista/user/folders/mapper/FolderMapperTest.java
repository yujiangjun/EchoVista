package com.cn.yujiangjun.echovista.user.folders.mapper;

import com.cn.yujiangjun.echovista.user.folders.dto.FolderTreeDto;
import com.cn.yujiangjun.echovista.user.folders.dto.MyFoldersReqDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FolderMapperTest {

    @Autowired
    private FolderMapper folderMapper;
    @Test
    void getMyFolderTree() {

        MyFoldersReqDto req = new MyFoldersReqDto();
        req.setOwnerId("001");
        List<FolderTreeDto> myFolderTree = folderMapper.getMyFolderTree(req);
        System.out.println(myFolderTree);
    }
}