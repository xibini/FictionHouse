package io.github.xbn.noval.core.common.req;

import lombok.Data;

/**
 * 分页请求数据格式分装，所有分页请求的dto类都要继承该类
 * @Author:向丙宁
 * @Package:io.github.xbn.noval.core.common.req
 * @Project:noval
 * @Date:2024/6/30 19:10
 */
@Data
public class PageReqDto {
    /**
     * 请求页码，默认第一页
     **/
    private int pageNum;
    /**
     * 每页大小，默认每页10条
     **/
    private int pageSize;
    /**
     * 是否获取全部数据，默认不获取
     * 为true时，pageNum和pageSize无效
     **/
    private boolean fetchAll = false;
}
