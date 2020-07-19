/**
 * 
 * @author wyl
 * @date 2020-07-19T21:26:38.995246400
 */
public interface HUserMapper {

    List<HUser> list(@Param("HUser") HUser hUser);
}