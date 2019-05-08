/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.mysqldbtests;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogMapper {

  List<Map> selectAllPosts();

  List<Map> selectAllPosts(RowBounds rowBounds);

  List<Map> selectAllPosts(RowBounds rowBounds, Object param);
  
  
//  @Select("SELECT * FROM blog WHERE id = #{id}")//简单的语句可以通过注解来实现 以达到代码简洁的目的
  List<Blog> selectBlog(int id);//Blog
  
  List<Blog> selectBlogTwo(int id1,int id2);//Blog
  
  List<Blog> selectBlogMultiByList(List idList);//Blog
  
  List<Blog> selectBlogMultiByArray(String[] idArray);//Blog
  
  List<Blog> selectBlogMultiParamByAnnotation(@Param("title")String name, @Param("idArrays")String[] idArrays);

  List<Blog> selectBlogMultiParamByMap(Map<String, Object> paramsMap);

  
}
