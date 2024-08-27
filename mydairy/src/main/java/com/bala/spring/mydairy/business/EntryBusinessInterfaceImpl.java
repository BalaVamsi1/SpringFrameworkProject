package com.bala.spring.mydairy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.spring.mydairy.dao.EntryDaoInterface;
import com.bala.spring.mydairy.entities.Entry;
@Component
public class EntryBusinessInterfaceImpl implements EntryBusinessInterface {
	@Autowired
	private EntryDaoInterface entryDaoInterface;
	public void save(Entry entry) {
		entryDaoInterface.save(entry);
	}

	public void update(Entry entry) {
		entryDaoInterface.update(entry);
	}

	public void delete(Entry entry) {
		entryDaoInterface.delete(entry);
	}

	public Entry getById(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findById(id);
	}

	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		return entryDaoInterface.findAll();
	}

	public List<Entry> findByUserid(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findByUserid(id);
	}

	public Entry findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
