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
    private List<T> rows;
    private long total;


    public PagedResult(List<T> data) {
        if (data instanceof Page) {
            Page<T> page = (Page<T>) data;
            this.rows = page.getResult();
            this.total = page.getTotal();

        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
