package com.yuki.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//todo eclipse mybatis逆向工程启动程序

/**public class Generator {
    private static MyBatisGenerator myBatisGenerator = null;

    static {
        ArrayList<String> waring = new ArrayList<>();
        boolean res = true;
        String resource = "/generatorConfig.xml";
        File file = new File(Generator.class.getResource(resource).getFile());

        ConfigurationParser configurationParser = new ConfigurationParser(waring);
        Configuration configuration = null;
        try {
            configuration = configurationParser.parseConfiguration(file);
            DefaultShellCallback callback = new DefaultShellCallback(res);
            myBatisGenerator = new MyBatisGenerator(configuration, callback, waring);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static MyBatisGenerator getGenerator() {
        return myBatisGenerator;
    }

    public static void main(String[] args) {
        getGenerator();
    }

}
 **/
