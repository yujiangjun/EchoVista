package com.cn.yujiangjun.echovista.user.folders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.yujiangjun.echovista.user.folders.dto.FolderTreeDto;
import com.cn.yujiangjun.echovista.user.folders.dto.MyFoldersReqDto;
import com.cn.yujiangjun.echovista.user.folders.model.Folder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FolderMapper extends BaseMapper<Folder> {

    List<FolderTreeDto> getMyFolderTree(@Param("req") MyFoldersReqDto req);
}