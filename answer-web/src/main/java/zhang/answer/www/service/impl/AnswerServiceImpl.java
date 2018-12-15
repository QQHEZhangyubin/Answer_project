package zhang.answer.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import zhang.answer.www.common.PageHelper;
import zhang.answer.www.dao.AnswerMapper;
import zhang.answer.www.entity.Answer;
import zhang.answer.www.service.AnserService;

import java.util.List;

@Service
public class AnswerServiceImpl  implements AnserService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public int save(Answer record) {
        return answerMapper.insertSelective(record);
    }

    @Override
    public Answer select(Answer answer) {
        return answerMapper.selectOne(answer);
    }

    @Override
    public PageHelper.Page<Answer> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example e = new Example(Answer.class);
        List<Answer> list = answerMapper.selectByExample(e);
        PageHelper.Page endPage = PageHelper.endPage();
        return endPage;
    }
}
