package fr.univ_lille.iut.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface PariDao {
	@SqlUpdate("create table paris (id integer primary key autoincrement, password varchar(100), name varchar(100), sideOne varchar(100), sideTwo varchar(100), description varchar(10), miseSideOne integer, miseSideTwo integer, miseMin integer, privacy boolean)")
	void createParisTable();

	@SqlUpdate("insert into paris (password, name, sideOne, sideTwo, description, miseMin, privacy) values (:password, :name, :sideOne, :sideTwo, :description, :miseMin, :privacy)")
	@GetGeneratedKeys
	int insert(@BindBean() Pari pari);

	@SqlUpdate("drop table if exists paris")
	void dropParisTable();
	
	@SqlUpdate("delete from paris where id = :id")
	void delete(@Bind("id") int id);
	
	@SqlQuery("select * from paris order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Pari> all();

	@SqlQuery("select * from paris where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Pari findById(@Bind("id") int id);

	void close();
}
