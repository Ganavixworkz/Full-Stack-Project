package com.xworkz.rto.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.DlDto;
import com.xworkz.rto.entity.DlEntity;
import com.xworkz.rto.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;
@Repository
@Slf4j
public class RtoDlRepositoryImpl implements RtoDlRepository{

	@Autowired
    EntityManagerFactory factory;

	@Override
	public boolean onSave(DlDto dto) {
		log.info("dl on save method");
		DlEntity entity=new DlEntity();
		BeanUtils.copyProperties (dto, entity); 
		entity.setRegisteredDateTime(LocalDateTime.now());
		entity.setStatus("pending");
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		System.err.println("*****************************"+entity);
		transaction.commit();
		manager.close();
		return true;

	}

	@Override
	public boolean updateByIdDl(int id) {

		EntityManager manager=factory.createEntityManager();
		DlEntity entity=manager.find(DlEntity.class, id);
		if(entity!=null) {
			entity.setStatus("approved");
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
			}else {
				log.info("Invalid id");
		
		return false;
	}
	}

	@Override
	public DlEntity findByApplication(String applicationNumber) {
		EntityManager manager = factory.createEntityManager();
		Query loginQuery = manager.createNamedQuery("findByApplication");
		loginQuery.setParameter("app", applicationNumber);
		DlEntity entity=(DlEntity) loginQuery.getSingleResult();
		
		return entity;
	}

	@Override
	public boolean updateByDl(DlEntity dl) {
		EntityManager manager = factory.createEntityManager();
if(dl!=null) {
	manager.getTransaction().begin();
	manager.merge(dl);
	System.err.println("repoo"+dl);
	manager.getTransaction().commit();
	manager.close();
	
	
}else {
	System.out.println("invalid");

}
return true;
	}
	}
	


