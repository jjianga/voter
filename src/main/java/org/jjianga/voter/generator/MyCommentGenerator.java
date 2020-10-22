package org.jjianga.voter.generator;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.JDBCConnectionFactory;

public class MyCommentGenerator extends DefaultCommentGenerator {
	 
	private Properties properties;
	private Properties systemPro;
	private boolean suppressDate;
	private boolean suppressAllComments;
	private String currentDateStr;

	public MyCommentGenerator() {
		super();
		properties = new Properties();
		systemPro = System.getProperties();
		suppressDate = false;
		suppressAllComments = false;
		currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}

	private Connection getConnection() throws SQLException {

		ConnectionFactory connectionFactory = new JDBCConnectionFactory(
				GeneratorMain.config.getContext("MySQLTables").getJdbcConnectionConfiguration());
		return connectionFactory.getConnection();
	}
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
 
		suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
 
		suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}	
	
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// sqlserver拿不到 使用sql 去查询，在网上着了蛮久没有解决好
		String num = introspectedColumn.getRemarks();
		boolean isSqlServer;
		try {
			Connection conn = null;
			ResultSet sqlServerResultSet = null;
			try {
				conn = getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			isSqlServer = conn.getMetaData().getDriverName().toUpperCase().indexOf("SQL SERVER") != -1;
			if (isSqlServer) {
				// sqljdbc与sqljdbc4不同，sqlserver中间有空格
				String sql = "SELECT\n" + "\tconvert(varchar(1000), C.\n" + "VALUE)\n" + "\tAS REMARKS\n" + "FROM\n"
						+ "\tsys.tables A\n" + "INNER JOIN sys.columns B ON B.object_id = A.object_id\n"
						+ "LEFT JOIN sys.extended_properties C ON C.major_id = B.object_id\n"
						+ "AND C.minor_id = B.column_id\n" + "WHERE\n" + "\tA.name = ? AND b.NAME=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, introspectedTable.getFullyQualifiedTableNameAtRuntime());
				ps.setString(2, introspectedColumn.getActualColumnName());
				sqlServerResultSet = ps.executeQuery();
				while (sqlServerResultSet.next()) {
					num = sqlServerResultSet.getString(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(num);
		sb.append("\n");
		sb.append("	* 列名:" + introspectedColumn.getActualColumnName() + " 类型:" + introspectedColumn.getJdbcTypeName()
				+ "(" + introspectedColumn.getLength() + ")" + " 允许空:" + introspectedColumn.isNullable() + " 缺省值:"
				+ introspectedColumn.getDefaultValue());
		field.addJavaDocLine(sb.toString());
		field.addJavaDocLine(" */");
	}
//public void addFieldComment(Field field, IntrospectedTable introspectedTable, 
//IntrospectedColumn introspectedColumn) { 
//if (suppressAllComments) { 
//return; 
//} 
//StringBuilder sb = new StringBuilder(); 
//field.addJavaDocLine("/**"); 
//sb.append(" * "); 
//sb.append(introspectedColumn.getRemarks()); 
//sb.append("\n"); 
//sb.append("	* 列名:" + introspectedColumn.getActualColumnName() + " 类型:" + introspectedColumn.getJdbcTypeName() 
//+ "(" + introspectedColumn.getLength() + ")" + " 允许空:" + introspectedColumn.isNullable() + " 缺省值:" 
//+ introspectedColumn.getDefaultValue()); 
//field.addJavaDocLine(sb.toString()); 
//field.addJavaDocLine(" */"); 
//} 

	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

	}

	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("/**");
		sb.append("\n");
		sb.append("	* ");
		sb.append("\n");
//		sb.append("	* @author jjianga" + "\n");
//		if (!suppressDate) {
//
//			sb.append("	* @date " + currentDateStr + "\n");
//
//		}

		List<Parameter> parameters = method.getParameters();

		for (Parameter parameter : parameters) {

			sb.append("	* @param " + parameter.getName() + "\n");

		}

		sb.append("	* @return " + method.getReturnType());
		sb.append("\n" + "	*/");
		method.addJavaDocLine(sb.toString());
	}

	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

	}

	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

		super.addClassComment(innerClass, introspectedTable, markAsDoNotDelete);
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

	}

	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.addImportedType("com.fasterxml.jackson.annotation.JsonInclude");
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("/**");
		sb.append("\n");
		sb.append("* ");
		sb.append("\n");
		sb.append("* @author ")
		.append(systemPro.getProperty("user.name"))
		.append("\n");
		if (!suppressDate) {

			sb.append("* @date " + currentDateStr + "\n");

		}
		sb.append("* 数据表" + introspectedTable.getFullyQualifiedTableNameAtRuntime() + "映射bean，由Mybaits自动生成工具生成");
		sb.append("\n" + "*/");
		topLevelClass.addJavaDocLine(sb.toString());
		topLevelClass.addAnnotation("@JsonInclude(JsonInclude.Include.NON_NULL)");

	}

}