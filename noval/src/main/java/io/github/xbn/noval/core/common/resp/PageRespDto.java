package io.github.xbn.noval.core.common.resp;

import lombok.Getter;

import java.util.List;

/**
 * 分页响应数据格式封装
 *
 * @Author:向丙宁
 * @Package:io.github.xbn.noval.core.common.resp
 * @Project:noval
 * @Date:2024/6/30 19:25
 */
@Getter
public class PageRespDto<T> {
    /**
     * 当前页码
     */
    private final long pageNum;
    /**
     * 每页大小
     */
    private final long pageSize;
    /**
     * 总记录数
     */
    private final long total;
    /**
     * 分页数据集
     */
    private final List<? extends T> list;

    /**
     *该构造函数用于通用分页查询场景
     * 接受普通分页数据和普通集合
     *
     * @param pageNum
     * @param pageSize
     * @param total
     * @param list
     */
    public PageRespDto(long pageNum, long pageSize, long total, List<? extends T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    /**
     * 根据分页参数和数据列表创建分页响应对象。
     * <p>
     * 该方法用于封装分页请求的参数和数据列表到一个分页响应数据传输对象（DTO）中。
     * 它使得在服务端处理分页逻辑后，能够以统一的格式向前端提供分页数据。
     */
    public static <T> PageRespDto<T> of(long pageNum, long pageSize, long total, List<? extends T> list) {
        return new PageRespDto<>(pageNum, pageSize, total, list);
    }

    /**
     *获取分页数
     * @return
     */
    public long getPages() {
        if(this.pageSize == 0L) { // pageSize为0，不需要分页，则返回0
            return 0L;
        } else { // pageSize不为0，则根据总记录数和每页大小计算分页数
            long pages = this.total / this.pageSize;
            if(this.total % this.pageSize != 0L) { // 如果总记录数不能整除每页大小，则分页数加1
                ++pages;
            }
            return pages;
        }
    }
}
