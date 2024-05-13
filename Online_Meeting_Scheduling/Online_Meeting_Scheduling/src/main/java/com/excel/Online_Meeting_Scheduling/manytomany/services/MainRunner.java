package com.excel.Online_Meeting_Scheduling.manytomany.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.excel.Online_Meeting_Scheduling.manytomany.entity.Roles;
import com.excel.Online_Meeting_Scheduling.manytomany.entity.Users;

public class MainRunner {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("onlinemeeting");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();


		
		transaction.begin();
		
		transaction.commit();
		
		manager.close();
	}
}
