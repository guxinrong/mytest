package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis工具类
 *
 * @author liyan
 *
 */
public class MyBatisUtil
{

    private static SqlSessionFactory factory;

    private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static
    {
        try
        {
            factory = new SqlSessionFactoryBuilder()
                    .build(MyBatisUtil
                            .class
                            .getClassLoader()
                            .getResourceAsStream("mybatis-config.xml"));

        } catch (Exception e)
        {
            e.printStackTrace();
            throw new ExceptionInInitializerError("mybatis初始化失败:" + e);
        }
    }

    /**
     * 获取sqlSession
     */
    public static SqlSession getSession()
    {

        SqlSession session = local.get();

        if (session == null)
        {
            session = factory.openSession();

            local.set(session);
        }

        return session;
    }

    public static void closeSession()
    {
        getSession().close();
        local.remove();
    }

}
