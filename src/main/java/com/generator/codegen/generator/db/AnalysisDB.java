package com.generator.codegen.generator.db;

import com.generator.codegen.generator.model.ColumnMeta;
import com.generator.codegen.generator.model.TableMeta;

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

	/**
	 * 读取表列表
	 * 
	 * @param tableName
	 *            表名，如果不传表名，则查询所有表
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
		String sql = "SELECT COLUMN_NAME ,ORDINAL_POSITION ,IS_NULLABLE ,COLUMN_DEFAULT ,COLUMN_TYPE ,COLUMN_KEY ,EXTRA ,COLUMN_COMMENT "
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

				fm.setColumnName(rs.getString("COLUMN_NAME"));
				fm.setOrdinalPosition(rs.getString("ORDINAL_POSITION"));
				fm.setIsNullable(rs.getString("IS_NULLABLE"));
				fm.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
				fm.setColumnType(rs.getString("COLUMN_TYPE"));
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

}