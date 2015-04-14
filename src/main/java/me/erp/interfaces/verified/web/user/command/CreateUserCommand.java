package me.erp.interfaces.verified.web.user.command;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/3/7.
 */
public class CreateUserCommand implements Serializable {

    @NotEmpty(message = "{CreateUserCommand.username.NotEmpty}")
    @Length(min = 4, message = "{CreateUserCommand.username.Length}")
    private String username;

    @NotEmpty(message = "{CreateUserCommand.realName.NotEmpty}")
    private String realName;

    @NotEmpty(message = "{CreateUserCommand.password.NotEmpty}")
    @Length(min = 8, message = "{CreateUserCommand.password.Length}")
    private String password;

    @NotEmpty(message = "{CreateUserCommand.confirmPassword.NotEmpty}")
    private String confirmPassword;

    private String salt;

    @NotNull(message = "{CreateUserCommand.sex.NotEmpty}")
    @NotEmpty(message = "{CreateUserCommand.sex.NotEmpty}")
    @Pattern(regexp = "[0|1]", message = "{CreateUserCommand.sex.Pattern}")
    private String sex;

    @NotNull(message = "{CreateUserCommand.email.NotEmpty}")
    @NotEmpty(message = "{CreateUserCommand.email.NotEmpty}")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", message = "{CreateUserCommand.email.Pattern}")
    private String email;

    @NotNull(message = "{CreateUserCommand.telephone.NotNull}")
    @Pattern(regexp = "1[3|5|7|8|][0-9]{9}", message = "{CreateUserCommand.telephone.Pattern}")
    private String telephone;

    @NotEmpty(message = "{CreateUserCommand.idCard.NotEmpty}")
    private String idCard;

    @NotEmpty(message = "{CreateUserCommand.organization.NotEmpty}")
    private String organization;

    private String remark;

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
