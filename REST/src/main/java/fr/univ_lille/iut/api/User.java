package fr.univ_lille.iut.api;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.security.SecureRandom;

public class User implements Principal {
    final static Logger logger = LoggerFactory.getLogger(User.class);

	private static int idInc;
    private int id;

    private String firstName;
    private String lastName;
    private String login;
    private String address;
    private String postalCode;
    private String location;
    private int age;
    private String mobile;
    private String password;
    private String passwdHash;
    private String salt;

    private static User anonymous = new User("Anne", "O'nyme");

    public User() {
    	this.id = idInc++;
    }
    
    public User(String firstName, String lastName) {
    	this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String login) {
    	this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }
    
    public User(String firstName, String lastName, String login, String address, String postalCode, String location, int age, String mobile, String password) {
    	this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.address = address;
        this.postalCode = postalCode;
        this.location = location;
        this.age = age;
        this.mobile = mobile;
        setPassword(password);
    }
    
    public String getName() {
    	return firstName + " " + lastName;
    }
    
    public String getMobile() {
    	return mobile;
    }
    
    public void setMobile(String mobile) {
    	this.mobile = mobile;
    }
    
    public int getAge() {
    	return age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public String getLocation() {
    	return location;
    }
    
    public void setLocation(String location) {
    	this.location = location;
    }
    
    public String getPostalCode() {
    	return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
    	this.postalCode = postalCode;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public void setPassword(String password) {
        passwdHash = buildHash(password, getSalt());
        this.password = password;
    }

    public String getPassword () {
        return password;
    }

    private String buildHash(String password, String s) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(password + s, Charsets.UTF_8);
        return hasher.hash().toString();
    }

    public boolean isGoodPassword(String password) {
        String hash = buildHash(password, getSalt());
        return hash.equals(getPasswdHash());
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }

    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        User user = (User) arg;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && login.equals(user.login) && address.equals(user.address) && postalCode.equals(user.postalCode) && location.equals(user.location) && age == user.age && mobile.equals(user.mobile) && passwdHash.equals(user.getPasswdHash()) && salt.equals((user.getSalt()));
    }

    @Override
    public String toString() {
        return id + ": " + login + ", " + firstName+ ", " + lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSalt() {
        if (salt == null) {
            salt = generateSalt();
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putLong(random.nextLong());
        return hasher.hash().toString();
    }

    public void resetPasswordHash() {
        if (password != null && ! password.isEmpty()) {
            setPassword(getPassword());
        }
    }

    public boolean isInUserGroup(){
        return ! (id == anonymous.getId());
    }

    public static User getAnonymousUser() {
        return anonymous ;
    }

    public static boolean isAnonymous(User currentUser) {
        return currentUser.getId() == getAnonymousUser().getId();
    }
}
