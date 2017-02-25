package sky._const;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public enum FileType {
    DOC(1), JPG(2), VIDEO(3), MUSIC(4);
    private int id;

    FileType(int id) {
        this.id = id;
    }

    private int getId() {
        return id;
    }
}
