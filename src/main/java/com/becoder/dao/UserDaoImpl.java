package com.becoder.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.becoder.entity.Notes;
import com.becoder.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUser(User user) {
	int i= (Integer) hibernateTemplate.save(user);
		return i;
	}

	
	public User login(String email, String password) {
		String sql="from User where email=:em and password=:pwd";
		User us =(User) hibernateTemplate.execute(s-> {
			Query q = s.createQuery(sql);
			q.setParameter("em", email);
			q.setParameter("pwd", password);
			return q.uniqueResult();
		});
		return us;
	}


	@Transactional
	@Override
	public int saveNotes(Notes notes) {
		int i = (Integer) hibernateTemplate.save(notes);
		return i;
	}


	@Override
	public List<Notes> getNotesByUser(User user) {
		String sql= "from Notes where user=:us";
		List<Notes> list = hibernateTemplate.execute(s ->{
			Query q = s.createQuery(sql);
			q.setParameter("us", user);
			return q.getResultList();
		});
		return list;
	}


	@Override
	public Notes getNotesById(int id) {
        Notes n = hibernateTemplate.get(Notes.class, id);
		return n;
	}


	@Transactional
	@Override
	public void deleteNotes(int id) {
		Notes n = hibernateTemplate.get(Notes.class, id);
		hibernateTemplate.delete(n);
		
	}


	@Transactional
	@Override
	public void updateNotes(Notes n) {
	hibernateTemplate.update(n);
	
	}
}
