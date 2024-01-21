package com.cn.yujiangjun.echovista.user.folders.dto;

import com.cn.yujiangjun.echovista.user.folders.model.Folder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FolderTreeDto extends Folder {
    @Serial
    private static final long serialVersionUID = 2805652366915266018L;
    private List<FolderTreeDto> sons;
}
