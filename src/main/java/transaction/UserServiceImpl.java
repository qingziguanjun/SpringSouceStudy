package transaction;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
public class UserServiceImpl implements UserService {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void save(User s) {
		jdbcTemplate.update("insert into user(name,age,sex) values(?,?,?)",
				new Object[] {s.getName(),s.getAge(),s.getSex()},
				new int[] {java.sql.Types.VARCHAR, java.sql.Types.INTEGER,java.sql.Types.VARCHAR});
		throw new RuntimeException("aaa");
	}

	public List<User> getUsers() {
		List<User> list= jdbcTemplate.query("select * from user", new UserRowMapper());
		return list;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void update(User s) {
		jdbcTemplate.update("update user set name=? where id=1",
				new Object[] {s.getName()},
				new int[] {java.sql.Types.VARCHAR});
		//throw new RuntimeException("aaa");
		
	}

}
