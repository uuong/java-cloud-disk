package sky.pojo;

import java.util.Date;

public class FileMode {
    private Integer id;

    private String username;

    private String filename;

    private String filetype;

    private String filesize;

    private String filepath;

    private Date uploadtime;

    public FileMode(Integer id, String username, String filename, String filetype, String filesize, String filepath, Date uploadtime) {
        this.id = id;
        this.username = username;
        this.filename = filename;
        this.filetype = filetype;
        this.filesize = filesize;
        this.filepath = filepath;
        this.uploadtime = uploadtime;
    }

    public FileMode() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize == null ? null : filesize.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
}