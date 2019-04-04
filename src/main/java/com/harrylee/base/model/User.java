package com.harrylee.base.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author harrylee
 */
public class User {

    @NotEmpty(message = "名称不能为空")
    @Size(min = 2, max = 12, message = "名称不能小于2个字,不能多于12个字")
    private String userName;
    @NotEmpty(message = "登录名不能为空")
    @Pattern(regexp = "[a-zA-Z.-@#]{4,12}", message = "登录名不能小于4个字符,不能多于12个字符,且必须为英文字符")
    private String loginName;
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "[a-zA-Z0-9]{6,}", message = "密码长度不能小于6位,且必须为数字或英文字符")
    private String password;
    @Max(value = 200, message = "年龄不能大于100岁")
    @Min(value = 18, message = "必须年满18岁")
    private Integer age;
    @NotEmpty(message = "性别不能为空")
    @Pattern(regexp = "[男女]", message = "性别必须为男或女")
    private String sex;
    private String remark;

    public User() {
    }

    public User(String userName, String loginName, String password, Integer age, String sex, String remark) {
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
