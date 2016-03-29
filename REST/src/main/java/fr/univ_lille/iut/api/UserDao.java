package fr.univ_lille.iut.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {
	@SqlUpdate("create table users (id integer primary key autoincrement, firstname varchar(100), lastname varchar(100), login varchar(100), address varchar(100), postalcode varchar(10), location varchar(100), age integer, mobile varchar(20), passwdHash varchar(32), salt varchar(32))")
	void createUsersTable();

	@SqlUpdate("insert into users (firstname, lastname, login, address, postalcode, location, age, mobile, passwdHash, salt) values (:firstName, :lastName, :login, :address, :postalCode, :location, :age, :mobile, :passwdHash, :salt)")
	@GetGeneratedKeys
	int insert(@BindBean() User user);

	@SqlQuery("select * from users where login = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
	User findByLogin(@Bind("login") String login);

	@SqlUpdate("drop table if exists users")
	void dropUserTable();
	
	@SqlUpdate("delete from users where id = :id")
	void delete(@Bind("id") int id);
	
	@SqlQuery("select * from users order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> all();

	@SqlQuery("select * from users where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User findById(@Bind("id") int id);

	void close();
}
