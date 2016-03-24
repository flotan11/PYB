import fr.univ_lille.iut.*;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDAO {
	@SqlUpdate("create table users (nom varchar(100), prenom varchar(100),login varchar(100),mdp varchar(100),adresse varchar(100),codePostal Integer,ville varchar(100), mail varchar(100), age Integer,mobile varchar(100))")
	void createUserTable();

	@SqlUpdate("insert into users (nom,prenom,login,mdp, adresse,codePostal,ville,mail,age,mobile) values (:nom, :prenom,:login,:mdp,:adresse,:codePostal,:ville, :mail, :age, :mobile)")
	@GetGeneratedKeys
	int insert(@BindBean() User user);

	@SqlQuery("select * from users where nom = :nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
	User findByName(@Bind("nom") String nom);

	@SqlUpdate("drop table if exists users")
	void dropUserTable(); 

	@SqlQuery("select * from users order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> all();

	@SqlQuery("select * from users where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User findById(@Bind("id") int id);

	void close();
}