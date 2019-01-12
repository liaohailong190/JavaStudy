package org.liaohailong.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Insert("INSERT INTO user(name,age,sex) VALUES(#{})")
	public int addUser(User user);

	public int removeUser(int id);

	public int updateUser(User user);

	@Select("SELECT * FROM user WHERE id = #{id}")
	public User getUser(@Param("id") int id);

	public List<User> getAllUser();
}
