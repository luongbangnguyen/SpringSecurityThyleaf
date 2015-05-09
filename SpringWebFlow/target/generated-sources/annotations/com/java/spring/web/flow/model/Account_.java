package com.java.spring.web.flow.model;

import com.java.spring.web.flow.enums.Role;
import com.java.spring.web.flow.model.Account.StatusAccount;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ extends com.java.spring.web.flow.model.Model_ {

	public static volatile SingularAttribute<Account, String> password;
	public static volatile SingularAttribute<Account, Role> role;
	public static volatile SingularAttribute<Account, StatusAccount> statusAccount;
	public static volatile SingularAttribute<Account, String> userName;
	public static volatile SingularAttribute<Account, String> email;

}

