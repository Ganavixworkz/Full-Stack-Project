package com.xworkz.rto.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.DlEntity;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;
import com.xworkz.rto.util.Encrypted;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class RtoRepositoryImplementation implements RtoRepository{
	
	@Autowired
    EntityManagerFactory factory;
	
	@Autowired
	Encrypted encrypt1;
	
	@Override
	public boolean onSave(RtoDto dto) {
		log.info("Repo on save method");
		RtoEntity entity=new RtoEntity();
		BeanUtils.copyProperties (dto, entity); 
		entity.setRegisteredDateTime(LocalDateTime.now());
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		System.err.println(""+entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public boolean onSave(UserDto udto) {
		log.info(" UserDto Repo on save method");
		UserEntity uentity=new UserEntity();
		BeanUtils.copyProperties (udto, uentity); 
		uentity.setRegisteredDateTime(LocalDateTime.now());
		uentity.setStatus("pending");                                                                   
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(uentity);
		transaction.commit();
		manager.close();
		return true;
	}
	
	@Override
	public List<RtoEntity> findAll() {
		EntityManager manager = factory.createEntityManager();
		Query query=manager.createNamedQuery("findAll");
		List<RtoEntity> list=query.getResultList();
		log.info(list.toString());
		return list;
		}
	
	@Override
	public List<UserEntity> userFindAll() {
		EntityManager manager = factory.createEntityManager();
		Query query=manager.createNamedQuery("userFindAll");
		List<UserEntity> ulist=query.getResultList();
		log.info(ulist.toString());
		return ulist;
		}

	@Override
	public RtoEntity checkLogin(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query loginQuery = manager.createNamedQuery("checkLogin");
		loginQuery.setParameter("em", email);
		loginQuery.setParameter("pw", password);
		try {
			return (RtoEntity) loginQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
		
	public RtoEntity adminLogin(String email, String otp) {
			EntityManager manager = factory.createEntityManager();
			Query loginQuery = manager.createNamedQuery("adminOtpLogin");
			loginQuery.setParameter("eml", email);
			//loginQuery.setParameter("pwd", password);
			loginQuery.setParameter("otp", otp);
try {
				return (RtoEntity) loginQuery.getSingleResult();
			} catch (NoResultException e) {
			return null;
		}
		
	}
		
		public RtoEntity forgotPass(String email, String otp) {
			EntityManager manager = factory.createEntityManager();
			Query loginQuery = manager.createNamedQuery("adminOtpLogin");
			loginQuery.setParameter("eml", email);
			//loginQuery.setParameter("pwd", password);
			loginQuery.setParameter("otp", otp);

			try {
				return (RtoEntity) loginQuery.getSingleResult();
			} catch (NoResultException e) {
			return null;
		}
		
	}
		
		public UserEntity userLogin(String apporphone,String dob) {
			EntityManager manager = factory.createEntityManager();
			Query loginQuery = manager.createNamedQuery("userLogin");
			loginQuery.setParameter("aporpn", apporphone);
			loginQuery.setParameter("db", dob);
          try {
				return (UserEntity) loginQuery.getSingleResult();
			} catch (NoResultException e) {
			return null;
		}
		}
		
		@Override
		public List<RtoEntity> searchByState(String state) {
			EntityManager manager=factory.createEntityManager();
			Query q=manager.createNamedQuery("searchByState");
			q.setParameter("st",state);
			List<RtoEntity> list=q.getResultList();
			log.info(list.toString());
			return list;
			
		}

		@Override
		public List<UserEntity> searchByUserState(String state) {
			EntityManager manager=factory.createEntityManager();
			Query q=manager.createNamedQuery("searchByUserState");
			q.setParameter("llrstate",state);
			List<UserEntity> userlist=q.getResultList();
			log.info(userlist.toString());
			return userlist;
			}

		@Override
		public boolean updateStatus(String applicationNumber) {
			EntityManager manager=factory.createEntityManager();
			Query q=manager.createNamedQuery("updateStatus");
			q.setParameter("appNum",applicationNumber);
			manager.getTransaction().begin();
			int row=q.executeUpdate();
	manager.getTransaction().commit();
			return row>0;
		}

		@Override
		public boolean updateById(int id) {
			EntityManager manager=factory.createEntityManager();
			UserEntity entity=manager.find(UserEntity.class, id);
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
		public boolean updateOtpById(RtoDto rtoDto) {
			EntityManager manager=factory.createEntityManager();
RtoEntity entity=new RtoEntity();
BeanUtils.copyProperties(rtoDto, entity);
manager.getTransaction().begin();
manager.merge(entity);
manager.getTransaction().commit();
manager.close();
return true;
			
		}
		
		@Override
		public boolean updatePassword(RtoDto rtoDto,String password,String confirmPassword) {
			EntityManager manager=factory.createEntityManager();
RtoEntity entity=new RtoEntity();
BeanUtils.copyProperties(rtoDto, entity);
entity.setPassword(encrypt1.encrypt(rtoDto.getPassword()));
entity.setConfirmPassword(encrypt1.encrypt(rtoDto.getConfirmPassword()));

manager.getTransaction().begin();
manager.merge(entity);
manager.getTransaction().commit();
manager.close();
return true;
		}

		@Override
		public boolean updateLoginCount(RtoDto rtoDto) {
			EntityManager manager=factory.createEntityManager();
			RtoEntity entity=new RtoEntity();
			BeanUtils.copyProperties(rtoDto, entity);
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
		}
		
		public UserEntity dlEntry(String applicationNumber) {
			EntityManager manager = factory.createEntityManager();
			Query loginQuery = manager.createNamedQuery("dlEntry");
			loginQuery.setParameter("ap", applicationNumber);
          try {
				return (UserEntity) loginQuery.getSingleResult();
			} catch (NoResultException e) {
			return null;
		}
		}

		@Override
		public UserEntity findApplication(String applicationNumber) {
			EntityManager manager = factory.createEntityManager();
			Query loginQuery = manager.createNamedQuery("findApplication");
			loginQuery.setParameter("app", applicationNumber);
			UserEntity entity=(UserEntity) loginQuery.getSingleResult();
			
			return entity;
		}
		
		
		

	

		
		/*public RtoEntity checkotp(String email, String otp) {
			EntityManager manager = factory.createEntityManager();
			Query loginQuery = manager.createNamedQuery("checkLogin");
			loginQuery.setParameter("em", email);
			loginQuery.setParameter("pw", password);
			try {
				return (RtoEntity) loginQuery.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}*/
			
		} 
		


		

