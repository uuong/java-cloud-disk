package sky.pojo;

import java.util.Date;

public class FileMode {
    private Integer id;

    private String username;

    private Integer pid;

    private String fileName;

    private String fileType;

    private Integer fileSize;

    private Date uploadTime;

    private Integer isDir;
    /**
     * 0 false
     * 1 true
     */
    private Integer isPublic;

    public FileMode(Integer id, String username, Integer pid, String fileName, String fileType, Integer fileSize, Date uploadTime, Integer isDir, Integer isPublic) {
        this.id = id;
        this.username = username;
        this.pid = pid;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.uploadTime = uploadTime;
        this.isDir = isDir;
        this.isPublic = isPublic;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getIsDir() {
        return isDir;
    }

    public void setIsDir(Integer isDir) {
        this.isDir = isDir;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }
}