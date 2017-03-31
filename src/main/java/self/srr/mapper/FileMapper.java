package self.srr.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import self.srr.model.Files;

/**
 * Mapper handling database querying
 * <p>
 * Created by Sharuru on 2017/03/30.
 */
@Mapper
public interface FileMapper {

    @Select("SELECT * FROM files WHERE filename = #{filename} LIMIT 1")
    Files findOneByFilename(@Param("filename") String fileName);

    @Insert("INSERT INTO files (" +
            "   org_filename," +
            "   filename," +
            "   creator," +
            "   adm_password )" +
            "VALUES (" +
            "   #{orgFilename}," +
            "   #{fileName}," +
            "   #{creator}," +
            "   #{adm_password} )")
    void insert(Files file);
}
