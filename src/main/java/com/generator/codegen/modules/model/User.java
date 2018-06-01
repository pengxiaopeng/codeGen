package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
* tableName：MS_USER
*/
public class User extends BaseModel implements UserDetails {

    private static final long serialVersionUID = 1L;

    
    private String id;
    
    private String roleId;
    
    private String orgId;
    
    private String nickname;
    
    private String name;
    
    private String email;
    
    private String phone;
    
    private String password;
    
    private String group;
    
    private String isLock;
    
    private String isAdmin;
    
    private String description;
    
    private String ip;
    
    private String token;
    
    private String sex;
    
    private Date logintime;
    
    private Date createtime;
    
    private Date updatetime;
    
    private Date lockTime;
    
    private long loginFailureCount;

    private List<Role> roles;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
    public String getRoleId(){
        return roleId;
    }
    public void setRoleId(String roleId){
        this.roleId= roleId;
    }
    public String getOrgId(){
        return orgId;
    }
    public void setOrgId(String orgId){
        this.orgId= orgId;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname= nickname;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone= phone;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public String getGroup(){
        return group;
    }
    public void setGroup(String group){
        this.group= group;
    }
    public String getIsLock(){
        return isLock;
    }
    public void setIsLock(String isLock){
        this.isLock= isLock;
    }
    public String getIsAdmin(){
        return isAdmin;
    }
    public void setIsAdmin(String isAdmin){
        this.isAdmin= isAdmin;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description= description;
    }
    public String getIp(){
        return ip;
    }
    public void setIp(String ip){
        this.ip= ip;
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token= token;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex= sex;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public long getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(long loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String getUsername() {
        return this.name;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = this.getRoles();
        for (Role role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

}