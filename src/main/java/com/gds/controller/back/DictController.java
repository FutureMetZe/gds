package com.gds.controller.back;

import com.gds.entity.Dict;
import com.gds.service.DictService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("back")
public class DictController {

    private Logger logger = Logger.getLogger(DictController.class);

    @Resource(name = "DictService")
    private DictService dictService;

    /**
     * 字典列表
     */
    @RequestMapping("/dictList.do")
    public String dictList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "pageSize", required = false)Integer pageSize,
                           @RequestParam(value = "currentPage", required = false)Integer currentPage,
                           @RequestParam(value = "keyNum", required = false)String keyNum,
                           @RequestParam(value = "keyName", required = false)String keyName ){
        PageBean<Dict> pageBeans = dictService.selectDictPageList(currentPage,pageSize,keyNum,keyName);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("keyNum",keyNum);
        model.addAttribute("keyName",keyName);

        logger.info("访问【dictList.do】接口；返回数据为："+pageBeans.toString());
        return "back/dict/list";
    }

    /**
     * 跳转到新增页面
     */
    @RequestMapping("/dictToAddPage.do")
    public String dictToAddPage(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                @RequestParam(value = "dictId", required = false)Integer dictId ){
        Dict dict = null;
        if (dictId != null && !dictId.equals("")){
            dict = dictService.selectDiceById(dictId);
            model.addAttribute("Dict",dict);
        }

        return "back/dict/add";
    }


    /**
     * 保存操作
     */
    @RequestMapping("/dictSave.do")
    public String dictSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,Dict dict ){
        logger.info("dictSave.do接口接受到的参数为："+dict);
        dictService.insertDict(dict);
        return dictList(request, response,model,null,null,null,null);
    }



    /**
     * 删除操作
     */
    @RequestMapping("/dictDelete.do")
    public String dictDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "dictId", required = false)Integer dictId ){
        dictService.deleteDiceById(dictId);
        return dictList(request, response,model,null,null,null,null);
    }

}
