/**
 * 文件表
 * @author wyl
 * @date 2020-07-19T21:26:15.265426500
 */
public interface HFileMapper {

    List<HFile> list(@Param("HFile") HFile hFile);
}