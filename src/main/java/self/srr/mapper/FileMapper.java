package self.srr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import self.srr.model.Files;

/**
 * Created by Sharuru on 2017/03/30.
 */
@Mapper
public interface FileMapper {

    @Select("SELECT * FROM files WHERE id = #{id}")
    Files findById(@Param("id") int id);
}
