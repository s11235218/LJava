package jd.dao;

import jd.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Long> {



}
