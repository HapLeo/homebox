package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.common.ExceptionUtil;
import com.hapleow.homeboxcodge.common.StringUtil;
import com.hapleow.homeboxcodge.dao.CodgeMapper;
import com.hapleow.homeboxcodge.dto.CodgeDto;
import com.hapleow.homeboxcodge.model.GenTable;
import com.hapleow.homeboxcodge.service.ICodgeService;
import com.hapleow.homeboxcodge.service.IGenTableService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.*;

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

    @Value("${codge.template.path}")
    private String templatePath;

    @Value("${codge.dest-path}")
    private String destPath;

    @Override
    public Object execute(CodgeDto codgeDto) {

        ExceptionUtil.throwIfEmpty(codgeDto.getTableName(), "请输入表名称~");

        GenTable genTable = genTableService.getByTableName(codgeDto.getTableName());
        ExceptionUtil.throwIfEmpty(genTable, "表名不正确！");

        // 读取模板目录下得所有模板
        Set<String> templates = getTemplateSet();

        for (String templateName : templates) {
            Map<String, Object> genData = new HashMap<>();
            genData.put("genTable", genTable);

            // 文件内容
            String content = genFileContent(templateName, genData);

            // 文件名
            String genFileNameSuffix = StringUtil.firstLatterUpperCamel(StringUtil.underlineToCamel(templateName));
            String suffix = genFileNameSuffix.substring(0, genFileNameSuffix.length() - 4);
            String fileName = genTable.getTableNameClass() + suffix;
            createFile(destPath, fileName, content);
        }

        return "SUCCESS";
    }

    /**
     * 获取模板文件的名称
     *
     * @return
     */
    private Set<String> getTemplateSet() {

        URL resource = this.getClass().getClassLoader().getResource("templates/");
        String file = resource.getFile();
        File tempDir = new File(file);
        Set<String> hashSet = new HashSet<>();
        for (String fileNames : Arrays.asList(tempDir.list())) {
            if (fileNames.endsWith(".btl")) {
                hashSet.add(fileNames);
            }
        }
        return hashSet;
    }


    private void createFile(String destPath, String fileName, String content) {

        // 生成目录
        File file = new File(destPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 生成文件
        File destFile = new File(destPath + fileName);
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(destFile)) {

            fileOutputStream.write(content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 生成文件内容
     *
     * @param templateName
     * @param bindData
     * @return
     */
    private String genFileContent(String templateName, Map<String, Object> bindData) {
        ResourceLoader resourceLoader = new ClasspathResourceLoader(templatePath);
        Configuration cfg = null;
        String fileContent = null;
        try {
            cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            Template template = gt.getTemplate(templateName);
            template.binding(bindData);
            fileContent = template.render();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (resourceLoader != null) {
                resourceLoader.close();
            }
        }
        return fileContent;
    }

}
