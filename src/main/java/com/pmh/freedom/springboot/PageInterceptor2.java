package com.pmh.freedom.springboot;



import com.github.pagehelper.cache.Cache;
import com.github.pagehelper.cache.CacheFactory;
import com.github.pagehelper.util.ExecutorUtil;
import com.github.pagehelper.util.MSUtils;
import com.github.pagehelper.util.StringUtil;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
* Mybatis - 通用分页拦截器
* <p>
* GitHub: https://github.com/pagehelper/Mybatis-PageHelper
* <p>
* Gitee : https://gitee.com/free/Mybatis_PageHelper
*
* @author liuzh/abel533/isea533
* @version 5.0.0
*/
@SuppressWarnings({"rawtypes", "unchecked"})
@Intercepts(
       {
               @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
               @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
       }
)
public class PageInterceptor2 implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.err.println("before " + invocation.getMethod().getName());
		Object result = invocation.getMethod().invoke(invocation.getTarget(),
				invocation.getArgs());
		System.err.println("after " + invocation.getMethod().getName());
		return result;
	}

   
   @Override
   public Object plugin(Object target) {
       return Plugin.wrap(target, this);
   }

   @Override
   public void setProperties(Properties properties) {
   }

}


