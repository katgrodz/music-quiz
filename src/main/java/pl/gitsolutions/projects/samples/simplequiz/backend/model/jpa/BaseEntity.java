package pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class BaseEntity implements Serializable {

    @Column(name = "DATE_CREATE")
    private String dateCreate;

    @Column(name = "TIME_CREATE")
    private String timeCreate;

    @Column(name = "USER_CREATE")
    private String userCreate;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "ACTIVE_FLAG")
    private Boolean activeFlag;

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
