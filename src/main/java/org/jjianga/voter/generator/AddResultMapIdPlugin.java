package org.jjianga.voter.generator;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class AddResultMapIdPlugin extends PluginAdapter {
	 
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
 
 
//	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//		List<String> annotations = method.getAnnotations();
//		Integer index = annotations.indexOf("@Results({");
//		annotations.set(index, "@Results(value={");
//		index = annotations.lastIndexOf("})");
//		annotations.set(index, "},id=\""+firstWordToLowcase(introspectedTable.getFullyQualifiedTable().getDomainObjectName())+"\")");
//        return true;
//    }
	@Override
	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		List<String> annotations = method.getAnnotations();
		Integer index = annotations.indexOf("@Results({");
		annotations.set(index, "@Results(value={");
		index = annotations.lastIndexOf("})");
		annotations.set(index, "},id=\""+firstWordToLowcase(introspectedTable.getFullyQualifiedTable().getDomainObjectName())+"\")");
		return super.clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
	}
 
	private String firstWordToLowcase(String str){
		return str.substring(0, 1).toLowerCase().concat(str.substring(1));
	}
	/**
    * entity字段设置
    */
   @Override
   public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType) {
       if (field.getType().getShortNameWithoutTypeArguments().equals("Date")) {
    	   if(introspectedColumn.getJdbcType() == 91) {
	           field.getAnnotations().add("@JsonFormat(pattern = \"yyyy-MM-dd\",timezone=\"GMT+8\")");
	           field.getAnnotations().add("@DateTimeFormat(pattern = \"yyyy-MM-dd\")");
	           topLevelClass.addImportedType("com.fasterxml.jackson.annotation.JsonFormat");
	           topLevelClass.addImportedType("org.springframework.format.annotation.DateTimeFormat");
    	   }else {
	           field.getAnnotations().add("@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\",timezone=\"GMT+8\")");
	           field.getAnnotations().add("@DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
	           topLevelClass.addImportedType("com.fasterxml.jackson.annotation.JsonFormat");
	           topLevelClass.addImportedType("org.springframework.format.annotation.DateTimeFormat");
    	   }
       }
       return true;
   }
 
}