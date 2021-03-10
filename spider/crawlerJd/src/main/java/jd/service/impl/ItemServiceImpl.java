package jd.service.impl;

import jd.dao.ItemDAO;
import jd.pojo.Item;
import jd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;
    @Override
    public void save(Item item) {
        this.itemDAO.save(item);
    }

    @Override
    public List<Item> findAll(Item item) {
        // 声明查询条件
        Example<Item> example = Example.of(item);

        // 根据查询条件查询数据
        List<Item> list = this.itemDAO.findAll(example);

        return null;
    }
}
