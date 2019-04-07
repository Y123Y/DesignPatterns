package pattern.template.jdbc.dao;

import pattern.template.jdbc.JdbcTemplate;
import pattern.template.jdbc.Member;
import pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDAO extends JdbcTemplate {
    public MemberDAO(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from user";
        try {
            return super.executeQuery(sql, new RowMapper<Member>() {

                @Override
                public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                    Member member = new Member();
                    member.setAccount(rs.getString("account"));
                    member.setName(rs.getString("name"));
                    member.setAge(rs.getInt("age"));
                    return member;
                }
            }, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
