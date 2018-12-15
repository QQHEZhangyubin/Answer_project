package zhang.answer.www.service;

import zhang.answer.www.common.PageHelper;
import zhang.answer.www.entity.Answer;

public interface AnserService {

    int save(Answer record);
    Answer select(Answer answer);
    PageHelper.Page<Answer> findAll(Integer pageNum,Integer pageSize);
}
