package cn.dreambreeze.server.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * mybatis plus code generator
 *
 * @author dream breeze
 * @date 2020/9/3 22:04
 */
public class CodeGenerator {

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入" + tip + "：");
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath + "/server/src/main/java");
    gc.setAuthor("dream breeze");
    gc.setOpen(false);
    gc.setSwagger2(true);
    gc.setFileOverride(true);
    // 不需要ActiveRecord特性的请改为false
    gc.setActiveRecord(true);
    // XML 二级缓存
    gc.setEnableCache(false);
    // XML ResultMap
    gc.setBaseResultMap(true);
    // XML column List
    gc.setBaseColumnList(true);
    gc.setServiceName("%sService");
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mysql://127.0.0.1:3306/dream?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&useSSL=false&serverTimezone=UTC");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("2we3@WE#");
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent("cn.dreambreeze.server");
    pc.setEntity("domain");
    pc.setService("service");
    pc.setController("controller");
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return projectPath + "/server/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController();

    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//    strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setTablePrefix("d_");
    // 公共父类
//    strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
    // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
//    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    strategy.setControllerMappingHyphenStyle(true);
    ArrayList<TableFill> tableFills = new ArrayList<>();
    //自动填充配置
    TableFill createBy = new TableFill("create_by", FieldFill.INSERT);
    TableFill createAt = new TableFill("create_at", FieldFill.INSERT);
    TableFill updateAt = new TableFill("update_at", FieldFill.INSERT_UPDATE);
    tableFills.add(createBy);
    tableFills.add(createAt);
    tableFills.add(updateAt);
    strategy.setTableFillList(tableFills);
    strategy.setLogicDeleteFieldName("delete_at");

    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }

}
