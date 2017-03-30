package self.srr.model;


/**
 * Created by Sharuru on 2017/03/30.
 */
public class Files {

    int id;
    String orgFilename;
    String fileName;
    String creator;
    String adm_password;
    String create_at;
    String delete_flg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgFilename() {
        return orgFilename;
    }

    public void setOrgFilename(String orgFilename) {
        this.orgFilename = orgFilename;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAdm_password() {
        return adm_password;
    }

    public void setAdm_password(String adm_password) {
        this.adm_password = adm_password;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getDelete_flg() {
        return delete_flg;
    }

    public void setDelete_flg(String delete_flg) {
        this.delete_flg = delete_flg;
    }
}
