package sky.pojo;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/3/3 0003
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class PagedResult<T> implements Serializable {
    private List<T> dataList;
    private long pageNo;
    private long pageSize;
    private long total;
    private long pages;

    public PagedResult(List<T> data) {
        if (data instanceof Page) {
            Page<T> page = (Page<T>) data;
            this.dataList = page.getResult();
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
        }
        //else {
        //    this.setPageNo(1);
        //    this.setPageSize(data.size());
        //    this.setDataList(data);
        //    this.setTotal(data.size());
        //}
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
