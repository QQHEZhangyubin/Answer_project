package zhang.answer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.answer.www.common.Constant;
import zhang.answer.www.common.PageHelper;
import zhang.answer.www.entity.Answer;
import zhang.answer.www.service.AnserService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AnswerController {
    private final static Logger log = Logger.getLogger(AnswerController.class);
    @Autowired
    private AnserService anserService;

    @RequestMapping("/checkCode")
    public void main(@RequestParam(value = "id",required = false) int id,
                     @RequestParam(value = "content",required = false) String content,
                     @RequestParam(value = "optiona",required = false) String optiona,
                     @RequestParam(value = "optionb",required = false) String optionb,
                     @RequestParam(value = "optionc",required = false) String optionc,
                     @RequestParam(value = "optiond",required = false) String optiond,
                     @RequestParam(value = "trueoption",required = false) String trueoption){

        System.out.println("received request");
        System.out.println(id+"");
        Answer answer = new Answer();
        //answer.setId(id);
        answer.setContent(content);
        answer.setOptiona(optiona);
        answer.setOptionb(optionb);
        answer.setOptionc(optionc);
        answer.setOptiond(optiond);
        answer.setTrueoption(trueoption);
        anserService.save(answer);
    }

/*
13608428279@163.com
zhongguomooc
 */

    @RequestMapping("/index_list")
    public String findAllList(Model model,
        @RequestParam(value = "ghf",required = false) String ghf,
        @RequestParam(value = "problemId",required = false) Integer problemId ,
        @RequestParam(value = "rightOption",required = false) String rightOption){
        log.info("============进入index_list==============");
        //PageHelper.Page<Answer> page = anserService.findAll(pageNum,pageSize);
        //System.out.println(""+ghf);
        //System.out.println("问题id是："+problemId);
        //System.out.println("问题答案是:"+rightOption);
        if (ghf.equals(rightOption)){
            if (Constant.sum<=60){
                Constant.sum +=10;
            }
        }
        if (!ghf.equals(rightOption)){
            if (Constant.sum>=10){
                Constant.sum-=10;
            }
        }
        System.out.println("累计得分："+Constant.sum);
        Answer answer = new Answer();
        answer.setId(problemId);
        Answer an = anserService.select(answer);
        model.addAttribute("page",an);
        return "../index";
    }
}
