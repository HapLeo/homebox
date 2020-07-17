package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.dao.CodgeMapper;
import com.hapleow.homeboxcodge.model.GenTable;
import com.hapleow.homeboxcodge.service.ICodgeService;
import com.hapleow.homeboxcodge.service.IGenTableService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/7/15
 */
@Service
public class CodgeServiceImpl implements ICodgeService {

    @Autowired
    private CodgeMapper codgeMapper;

    @Autowired
    private IGenTableService genTableService;

    @Override
    public List<Map<String, Object>> listTables() {
        return codgeMapper.listTables();
    }

    @Override
    public Object execute() {

        List<GenTable> list = genTableService.list(new GenTable());
        GenTable genTable = list.get(0);
        OutputStream outputStream = null;
        //初始化代码
        ResourceLoader resourceLoader = null;
        Configuration cfg = null;
        String content = null;
        try {
            resourceLoader = new ClasspathResourceLoader("templates/");
            cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            //获取模板
            Template t = gt.getTemplate("mapper.java.btl");
            t.binding("genTable", genTable);
            //渲染结果
            content = t.render();
            File file = new File("C:\\workspace\\homebox\\homebox-codge\\src\\main\\resources\\static\\" + genTable.getTableNameClass() + "Mapper.java");
            if (!file.exists()) {
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());

        } catch (IOException | BeetlException e) {
            e.getMessage();
        } finally {
            if (resourceLoader != null) {
                resourceLoader.close();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

}
