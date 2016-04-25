# Techflash - Hibernate

##Hibernate API

| Initial State  | Action            | End State |
|----------------|-------------------|-----------|
| None   | get(), load()      |Persistent|
| Transient   | save(), saveOrUpdate()    |Persistent|
| Persistent  | delete()      |Removed|
| Detached   | update(), saveOrUpdate()|Persistent|
|Persistent  | evict()      |Detached|


```java
		User user =  new User(); //transient
		//set all user properties
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession(); //Persistence Context 1
		org.hibernate.Transaction transaction = session.beginTransaction();
		session.save(user); // persistent
		transaction.commit();
		session.close();// close persistence context 1

		//bank is now detached
		Session session2 = factory.openSession(); //Persistence Context 2
		org.hibernate.Transaction transaction2 = session2.beginTransaction();
		session2.delete(user); //removed
		transaction2.commit();
```

**Obtaining Persistence Context**

```java
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	//some operations
	session.close();
```


##SQL's:
https://gist.github.com/veryintelligentperson/4a6bc20495826e633c5d55555334db4d
