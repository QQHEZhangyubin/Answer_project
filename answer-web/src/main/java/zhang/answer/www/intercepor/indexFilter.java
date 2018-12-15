package zhang.answer.www.intercepor;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import tk.mybatis.mapper.entity.Example;
import zhang.answer.www.common.PageHelper;
import zhang.answer.www.dao.AnswerMapper;
import zhang.answer.www.entity.Answer;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;
public class indexFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req,ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("自定义过滤器");
        ServletContext context = req.getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
         AnswerMapper answerMapper = ctx.getBean(AnswerMapper.class);
        //PageHelper.startPage(null,null);
         //Example e = new Example(Answer.class);
        Answer answer = new Answer();
        answer.setId(1);
       // List<Answer> list = answerMapper.selectByExample(e);
        Answer a = answerMapper.selectOne(answer);
        //PageHelper.Page endPage = PageHelper.endPage();
        System.out.println(a.getContent());
        req.setAttribute("page",a);
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
