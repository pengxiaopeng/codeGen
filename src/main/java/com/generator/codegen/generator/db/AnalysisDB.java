package com.generator.codegen.generator.db;

import com.generator.codegen.generator.model.ColumnMeta;
import com.generator.codegen.generator.model.TableMeta;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析表结构
 *
 * @author xuyb
 */
public class AnalysisDB {
    private static Logger logger = LoggerFactory.getLogger(AnalysisDB.class);

    /**
     * 读取表列表
     *
     * @param tableName 表名，如果不传表名，则查询所有表
     * @return
     */
    public static final List<TableMeta> readDB(String tableName) {
        List<TableMeta> list = new ArrayList<TableMeta>();
        String sql = "SELECT TABLE_NAME ,TABLE_COMMENT FROM information_schema.tables "
                + " WHERE table_schema ='" + Consts.DB_NAME + "'";
        if (null != tableName && !"".equals(tableName)) {
            sql = "SELECT TABLE_NAME ,TABLE_COMMENT FROM information_schema.tables "
                    + " WHERE table_schema ='"
                    + Consts.DB_NAME
                    + "'"
                    + " and TABLE_NAME='" + tableName + "'";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBHandler.createConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TableMeta tm = new TableMeta();
                tm.setSchemaName(Consts.DB_NAME);
                tm.setTableName(rs.getString("TABLE_NAME"));
                tm.setComment(rs.getString("TABLE_COMMENT"));
                list.add(tm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 填充字段信息
     *
     * @param tables
     */
    public static final void readTables(List<TableMeta> tables) {
        if (tables != null) {
            for (TableMeta tm : tables) {
                readTable(tm);
            }
        }
        DBHandler.close();
    }

    /**
     * 读取表结构
     *
     * @param table
     */
    private static final void readTable(TableMeta table) {
        List<ColumnMeta> list = new ArrayList<ColumnMeta>();
        String sql = "SELECT COLUMN_NAME ,ORDINAL_POSITION ,IS_NULLABLE ,COLUMN_DEFAULT ,COLUMN_TYPE ,data_type as CLAZZ_TYPE,COLUMN_KEY ,EXTRA ,COLUMN_COMMENT "
                + " FROM information_schema.columns WHERE table_schema ='"
                + Consts.DB_NAME
                + "' AND table_name = '"
                + table.getTableName() + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBHandler.createConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ColumnMeta fm = new ColumnMeta();

                fm.setColumnName(replaceUnderlineAndfirstToUpper(rs.getString("COLUMN_NAME")));
                fm.setOrdinalPosition(rs.getString("ORDINAL_POSITION"));
                fm.setIsNullable(rs.getString("IS_NULLABLE"));
                fm.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
                fm.setColumnType(rs.getString("CLAZZ_TYPE"));
                fm.setJdbcType(getJDBCType(rs.getString("CLAZZ_TYPE")));
                fm.setColumnKey(rs.getString("COLUMN_KEY"));
                fm.setExtra(rs.getString("EXTRA"));
                fm.setColumnComment(rs.getString("COLUMN_COMMENT"));
                list.add(fm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        table.setColumns(list);
    }

    /**
     * 功能：去掉下划线并将下划线后一个字母变成大写字母
     *
     * @param name
     */
    public static String replaceUnderlineAndfirstToUpper(String name) {
        StringBuffer result = new StringBuffer();
        if (StringUtils.isBlank(name)) {
            return "";
        } else if (!StringUtils.contains(name, "_")) {
            return name;
        }
        // 用下划线将name分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (StringUtils.isBlank(camel)) {
                continue;
            }
            if (result.length() == 0) {
                result.append(camel.toLowerCase());
            } else {
                result.append(StringUtils.substring(camel, 0, 1).toUpperCase());
                result.append(StringUtils.substring(camel, 1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 功能：转成JDBC数据类型
     *
     * @param type
     */
    public static String getJDBCType(String type) {
        type = type.toUpperCase();
        if (StringUtils.equalsIgnoreCase("CHAR", type)) {
            return "CHAR";
        } else if (StringUtils.equalsIgnoreCase(type, "TIMESTAMP")
                || StringUtils.equalsIgnoreCase(type, "DATETIME")) {
            return "TIMESTAMP";
        } else if (StringUtils.equalsIgnoreCase(type, "DECIMAL")) {
            return "DECIMAL";
        } else if (StringUtils.equalsIgnoreCase(type, "BIT")) {
            return "BIT";
        } else if (StringUtils.equalsIgnoreCase(type, "BIGINT")) {
            return "BIGINT";
        } else if (StringUtils.equalsIgnoreCase(type, "BLOB")) {
            return "BLOB";
        } else if (StringUtils.equalsIgnoreCase(type, "CLOB,TEXT")) {
            return "CLOB";
        } else if (StringUtils.equalsIgnoreCase(type, "DATE")) {
            return "DATE";
        } else if (StringUtils.equalsIgnoreCase(type, "DOUBLE,NUMBER")) {
            return "DOUBLE";
        } else if (StringUtils.equalsIgnoreCase(type, "NUMERIC")) {
            return "NUMERIC";
        } else if (StringUtils.equalsIgnoreCase(type, "REAL")) {
            return "REAL";
        } else if (StringUtils.equalsIgnoreCase(type, "SMALLINT")) {
            return "SMALLINT";
        } else if (StringUtils.equalsIgnoreCase(type, "TIME")) {
            return "TIME";
        } else if (StringUtils.equalsIgnoreCase(type, "TINYINT")) {
            return "TINYINT";
        } else if (StringUtils.equalsIgnoreCase(type, "VARCHAR")
                || StringUtils.equalsIgnoreCase(type, "VARCHAR2")
                || StringUtils.equalsIgnoreCase(type, "LONGTEXT")) {
            return "VARCHAR";
        } else if (StringUtils.equalsIgnoreCase(type, "INTEGER") || StringUtils.equalsIgnoreCase(type, "INT")) {
            return "INTEGER";
        } else {
            logger.info("other={}", type);
            return "OTHER";
        }
    }
}