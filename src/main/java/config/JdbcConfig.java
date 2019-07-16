package config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Jdbc配置
 * @author ASUS
 *
 */
@Configuration
@EnableTransactionManagement
@MapperScan("mapper")
@PropertySource({"classpath:jdbc.properties","classpath:mybatis.properties"})
public class JdbcConfig {
	
	//-- JDBC属性
	@Value("${jdbc.driverClass}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.user}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;
	
	//-- MyBatis属性
	@Value("${mybatis.config.path}")
	private String mybatisConfigPath;
	@Value("${mybatis.mapper.xml.config.path}")
	private String mapperXMLConfigPath;
	@Value("${mybatis.alias.package.path}")
	private String aliasPackagePath;
	
	
	/**
	 * Bean注解：该注解只能写在方法上，表明使用这个方法创建一个对象，加入Spring容器
	 * name属性：
	 *
	 */
	@Bean(name="dataSource")
	public DataSource createDataSource(){
		DruidDataSource dataSource =  new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		//-- 1.SqlSessionFactoryBean是SqlSessionFactory的代理类
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//-- 2.配置映射文件的路径
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		//-- 3.映射文件的地址
		String packageXMLConfigPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
				mapperXMLConfigPath;
		//-- 设置MyBatis配置文件的路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
		//设置Mapper对象的xml文件路径
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageXMLConfigPath));
		sqlSessionFactoryBean.setDataSource(dataSource);
		//-- 配置实体类包名路径
		sqlSessionFactoryBean.setTypeAliasesPackage(aliasPackagePath);
		return sqlSessionFactoryBean.getObject();
	}
	
	/*@Bean  //-- 事务管理器
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager();
	}*/
	
	/**dff
	 * @ bean方法JdbcConfig。getPropertySourcesPlaceholderConfigurer是非静态的，
	 * 返回一个可分配给Spring的BeanFactoryPostProcessor接口的对象。
	 * 这将导致无法在方法的声明@Configuration类中处理@Autowired、@Resource和@PostConstruct等注释。
	 * 在此方法中添加“静态”修饰符，以避免这些容器生命周期问题;请参见@Bean javadoc了解完整的细节。

	 * @return
	 */
	/*@Bean
	public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}*/
	
}


















