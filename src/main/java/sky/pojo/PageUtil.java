package sky.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/3/5 0005
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class PageUtil {
    private int limit = 10;//每页限制数,默认为10
    private int offset = 1;//当前页偏移,默认为1
    private String order;//排序
    private String sort;//排序列名称
    private String search;//搜索内容
    private String username;

    public String getUsername() {
        return username;
    }

    public PageUtil setUsername(String username) {
        this.username = username;
        return this;
    }

    //这里是模糊查询,所以需要对search字段改造下
    public void setSearch(String search) {
        this.search = "%" + search + "%";
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        if ("fileSize".equals(sort)) {
            this.sort = "file_size";
        } else {
            this.sort = sort;
        }

    }

    public String getSearch() {
        return search;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageUtil{");
        sb.append("limit=").append(limit);
        sb.append(", offset=").append(offset);
        sb.append(", order='").append(order).append('\'');
        sb.append(", sort='").append(sort).append('\'');
        sb.append(", search='").append(search).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
