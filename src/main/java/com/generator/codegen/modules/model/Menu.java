package manageSystem.modules.model;

import manageSystem.common.model.BaseModel;

import java.util.Date;
import java.util.List;

/**
* tableName：ms_menu
*/
public class Menu extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private String id;
    
    private String isRoot;
    
    private String isLeaf;
    
    private String name;
    
    private String url;
    
    private String parentId;
    
    private String menuType;
    
    private String sort;
    
    private String isDeleteable;
    
    private String isShow;
    
    private Date createTime;
    
    private Date updateTime;

    private List<Menu> childMenuList;
    private String isChoose;



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
    public String getIsRoot(){
        return isRoot;
    }
    public void setIsRoot(String isRoot){
        this.isRoot= isRoot;
    }
    public String getIsLeaf(){
        return isLeaf;
    }
    public void setIsLeaf(String isLeaf){
        this.isLeaf= isLeaf;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url= url;
    }
    public String getParentId(){
        return parentId;
    }
    public void setParentId(String parentId){
        this.parentId= parentId;
    }
    public String getMenuType(){
        return menuType;
    }
    public void setMenuType(String menuType){
        this.menuType= menuType;
    }
    public String getSort(){
        return sort;
    }
    public void setSort(String sort){
        this.sort= sort;
    }
    public String getIsDeleteable(){
        return isDeleteable;
    }
    public void setIsDeleteable(String isDeleteable){
        this.isDeleteable= isDeleteable;
    }
    public String getIsShow(){
        return isShow;
    }
    public void setIsShow(String isShow){
        this.isShow= isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Menu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<Menu> childMenuList) {
        this.childMenuList = childMenuList;
    }

    public String getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(String isChoose) {
        this.isChoose = isChoose;
    }
}