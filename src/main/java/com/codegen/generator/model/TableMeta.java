package com.codegen.generator.model;

import com.codegen.generator.db.Consts;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

;

/**
 * 表结构信息
 *
 * @author xuyb
 */
public class TableMeta {
    private String schemaName;
    private String tableName;
    private String comment;
    private List<ColumnMeta> columns;
    private String packageName;
    private String className;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ColumnMeta> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnMeta> columns) {
        this.columns = columns;
    }

    public String getClassName() {
        if (tableName == null)
            return "";
        StringBuffer className = new StringBuffer();
        if (StringUtils.startsWith(tableName, Consts.DB_TABLE_PREFIX)) {
            // String newName = StringUtils.substring(tableName,
            // tableName.indexOf("_")+1) ;
            String newName = StringUtils.substring(tableName,
                    Consts.DB_TABLE_PREFIX.length());
            String[] names = StringUtils.split(newName.toLowerCase(), "_");
            for (int i = 0, len = names.length; i < len; i++) {
                className.append(names[i].substring(0, 1).toUpperCase()
                        + names[i].substring(1));
            }
        } else {
            System.out.println("==不支持的表前缀==");
        }

        return className.toString();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

}