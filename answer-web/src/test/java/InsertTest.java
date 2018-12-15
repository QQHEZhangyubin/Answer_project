import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import zhang.answer.www.dao.AnswerMapper;
import zhang.answer.www.entity.Answer;
import zhang.answer.www.service.AnserService;
import zhang.answer.www.service.impl.AnswerServiceImpl;

import java.io.InputStream;
public class InsertTest {
    @Autowired
    private AnserService anserService;
    public static void main(String[] args) throws Exception{
        /*
        InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        AnswerMapper an = session.getMapper(AnswerMapper.class);
        */
        Answer answer = new Answer();
        answer.setId(5);
        answer.setContent("2+5=?");
        answer.setOptiona("5");
        answer.setOptionb("6");
        answer.setOptionc("7");
        answer.setOptiond("8");
        answer.setTrueoption("7");
        //ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        new AnswerServiceImpl().save(answer);
        //answerService.save(answer);
        System.out.println(answer.getId());
        /*
        session.commit();
        session.close();
        */
    }
}
