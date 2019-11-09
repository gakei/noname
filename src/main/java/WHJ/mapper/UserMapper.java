package WHJ.mapper;

import WHJ.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("Select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Insert("Insert into user (name," +
            " account_id," +
            " token, " +
            "gmt_create," +
            " gmt_modified) " +
            "values (#{name}," +
            "#{accountId}, " +
            "#{token}, " +
            "#{gmtCreate}, " +
            "#{gmtModified})")
    void insert(User user);
}