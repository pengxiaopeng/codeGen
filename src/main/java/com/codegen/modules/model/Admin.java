package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
* tableName：bid_admin
*/
public class Admin extends BaseModel implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String username; // 用户名
    private String password; // 密码
    private String nickname; // 姓名
    private byte[] avatar; // 头像
    private Boolean isEnabled; // 是否启用
    private Boolean isLocked; // 是否锁定
    private Integer loginFailureCount; // 连续登录失败次数
    private Date lockedDate; // 锁定日期
    private Date loginDate; // 最后登录日期
    private String loginIp; // 最后登录IP
    private String email; // E-mail
    private Integer userType; // 用户类别：0-平台。1其他
    private Long userOrgId; // 用户所属组织ID
    private Long topUserOrgId; // 用户所属顶级组织ID
    private Boolean isAdmin; // 是否是高校或企业管理员用户（每个高校、企业只有一个）

    private Integer dropdowns; // 连续登录失败次数
    private Integer footer; // 连续登录失败次数
    private Integer header; // 连续登录失败次数
    private Integer layout; // 连续登录失败次数
    private Integer siderbarMenu; // 连续登录失败次数
    private Integer siderbarMode; // 连续登录失败次数
    private Integer siderbarPosition; // 连续登录失败次数
    private Integer themeColor; // 连续登录失败次数
    private Integer themeStyle; // 连续登录失败次数
    private Boolean hadReadAttention; // 连续登录失败次数
    private Date createDate;
    private Date modifyDate;
    private Set<Role> roles = new HashSet<Role>(); // 角色
    private Set<Authority> authorities = new HashSet<Authority>(); // 权限
    private Long[] authorityArrayLongs; // 角色拥有的权限

    // 用户所属组织名称(所属部门)，存放临时变量，非数据库字段
    private String userOrgName;

    // 用户所属顶级组织名称，存放临时变量，非数据库字段
    private String topUserOrgName;

    // 用户所属角色名称，存放临时变量，非数据库字段
    private String roleName;
    // 工作流用户组，存放临时变量，非数据库字段
    private String groupId;
    // 用户组标识变量
    private String group;
    // 头像访问路径
    private String avatarPath;
    //创建人id
    private Long createUserId;
    //最后修改人id
    private Long modifyUserId;


    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getUserOrgId() {
        return userOrgId;
    }

    public void setUserOrgId(Long userOrgId) {
        this.userOrgId = userOrgId;
    }

    public Long getTopUserOrgId() {
        return topUserOrgId;
    }

    public void setTopUserOrgId(Long topUserOrgId) {
        this.topUserOrgId = topUserOrgId;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long[] getAuthorityArrayLongs() {
        return authorityArrayLongs;
    }

    public void setAuthorityArrayLongs(Long[] authorityArrayLongs) {
        this.authorityArrayLongs = authorityArrayLongs;
    }

    public String getUserOrgName() {
        return userOrgName;
    }

    public void setUserOrgName(String userOrgName) {
        this.userOrgName = userOrgName;
    }

    public String getTopUserOrgName() {
        return topUserOrgName;
    }

    public void setTopUserOrgName(String topUserOrgName) {
        this.topUserOrgName = topUserOrgName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Integer getDropdowns() {
        return dropdowns;
    }

    public void setDropdowns(Integer dropdowns) {
        this.dropdowns = dropdowns;
    }

    public Integer getFooter() {
        return footer;
    }

    public void setFooter(Integer footer) {
        this.footer = footer;
    }

    public Integer getHeader() {
        return header;
    }

    public void setHeader(Integer header) {
        this.header = header;
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public Integer getSiderbarMenu() {
        return siderbarMenu;
    }

    public void setSiderbarMenu(Integer siderbarMenu) {
        this.siderbarMenu = siderbarMenu;
    }

    public Integer getSiderbarMode() {
        return siderbarMode;
    }

    public void setSiderbarMode(Integer siderbarMode) {
        this.siderbarMode = siderbarMode;
    }

    public Integer getSiderbarPosition() {
        return siderbarPosition;
    }

    public void setSiderbarPosition(Integer siderbarPosition) {
        this.siderbarPosition = siderbarPosition;
    }

    public Integer getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(Integer themeColor) {
        this.themeColor = themeColor;
    }

    public Integer getThemeStyle() {
        return themeStyle;
    }

    public void setThemeStyle(Integer themeStyle) {
        this.themeStyle = themeStyle;
    }

    public Boolean getHadReadAttention() {
        return hadReadAttention;
    }

    public void setHadReadAttention(Boolean hadReadAttention) {
        this.hadReadAttention = hadReadAttention;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        for (Authority authority : authorities) {
            auths.add(new SimpleGrantedAuthority(authority.getAuthorities()));
        }
        return auths;
    }
}