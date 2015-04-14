package me.erp.interfaces.user.web.command;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/30.
 */
public class EditUserCommand implements Serializable {

    private String id;

    @NotEmpty(message = "{EditUserCommand.username.NotEmpty}")
    @Length(min = 4, message = "{EditUserCommand.username.Length}")
    private String username;

    @NotNull(message = "{EditUserCommand.realName.NotEmpty}")
    @NotEmpty(message = "{EditUserCommand.realName.NotEmpty}")
    private String realName;

    private String password;

    private String confirmPassword;

    private String salt;

    @NotNull(message = "{EditUserCommand.sex.NotEmpty}")
    @NotEmpty(message = "{EditUserCommand.sex.NotEmpty}")
    @Pattern(regexp = "[0|1]", message = "{EditUserCommand.sex.Pattern}")
    private String sex;

    @NotNull(message = "{EditUserCommand.email.NotEmpty}")
    @NotEmpty(message = "{EditUserCommand.email.NotEmpty}")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", message = "{CreateUserCommand.email.Pattern}")
    private String email;

    @NotNull(message = "{EditUserCommand.telephone.NotNull}")
    @Pattern(regexp = "1[3|5|7|8|][0-9]{9}", message = "{EditUserCommand.telephone.Pattern}")
    private String telephone;

    @NotNull(message = "{EditUserCommand.idCard.NotEmpty}")
    @NotEmpty(message = "{EditUserCommand.idCard.NotEmpty}")
    private String idCard;

    @NotNull(message = "{EditUserCommand.organization.NotEmpty}")
    @NotEmpty(message = "{EditUserCommand.organization.NotEmpty}")
    private String organization;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
