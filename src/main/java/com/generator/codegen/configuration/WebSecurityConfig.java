package com.generator.codegen.configuration;

import com.google.common.collect.Lists;
import manageSystem.modules.model.Admin;
import manageSystem.modules.model.AdminRole;
import manageSystem.modules.model.Authority;
import manageSystem.modules.model.RoleAuthority;
import manageSystem.modules.service.*;
import manageSystem.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-04-19 9:54
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").successForwardUrl("/admin/authority/list").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/static/**", "/WEB-INF/diagram-viewer/**", "/WEB-INF/editor-app/**");
    }
}

class CustomUserService implements UserDetailsService {
    @Autowired
    AdminService adminService;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleAuthorityService roleAuthorityService;
    @Autowired
    AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = new Admin();
        admin.setUsername(s);
        List<Admin> list = adminService.findList(admin);
        if (list == null || list.isEmpty()) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Admin admin1 = list.get(0);

        AdminRole adminRole = new AdminRole();
        adminRole.setAdmins(admin1.getId());
        List<AdminRole> adminRoleList = adminRoleService.findList(adminRole);
        if (adminRoleList != null && !adminRoleList.isEmpty()) {
            for (AdminRole role : adminRoleList) {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRole(role.getRoles());
                List<RoleAuthority> roleAuthorities = roleAuthorityService.findList(roleAuthority);

                if (roleAuthorities != null && !roleAuthorities.isEmpty()) {
                    LinkedHashMap<String, Object[]> linkedHashMap = new LinkedHashMap<>();
                    List<Long> authorityIdList = Lists.newArrayList();
                    for (RoleAuthority authority : roleAuthorities) {
                        authorityIdList.add(authority.getAuthorities());
                    }
                    Authority authority = new Authority();
                    linkedHashMap.put("ID",authorityIdList.toArray());
                    authority.setIdsMap(linkedHashMap);

                    List<Authority> authorityList = authorityService.findList(authority);

                    if (authorityList != null && !authorityList.isEmpty()) {
                        Set<Authority> authorityList1 = new HashSet<Authority>();
                        for (Authority authority1 : authorityList) {
                            authorityList1.add(authority1);
                            System.out.println("role:" + authority1.getAuthorities());
                        }
                        admin1.setAuthorities(authorityList1);
                    }
                }
            }
        }

        System.out.println("username:" + admin1.getUsername() + ";password:" + admin1.getPassword());
        return admin1;
    }
}

class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return MD5.getMD5Str(arg0.toString());
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(MD5.getMD5Str(arg0.toString()));
    }

}