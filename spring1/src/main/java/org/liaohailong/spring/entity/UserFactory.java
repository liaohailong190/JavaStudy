package org.liaohailong.spring.entity;

public class UserFactory {

	public UserEntity getUserEntity() {
		System.out.println("UserFactory->getUserEntity");
		return new UserEntity("ÁÎº£Áú", 26);
	}

	public static UserEntity getStaticUserEntity() {
		System.out.println("UserFactory->getStaticUserEntity");
		return new UserEntity("ÁÎº£Áú", 26);
	}
}
