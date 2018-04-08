package com.gds.controller.back;

import com.gds.entity.Dict;
import com.gds.entity.Goods;
import com.gds.service.DictService;
import com.gds.service.GoodsService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("back")
public class GoodsController {

    private Logger logger = Logger.getLogger(GoodsController.class);

    @Resource(name="GoodsService")
    private GoodsService goodsService;

    @Resource(name="DictService")
    private DictService dictService;

    @RequestMapping("/goodsList.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "pageSize", required = false)Integer pageSize,
                       @RequestParam(value = "currentPage", required = false)Integer currentPage,
                       @RequestParam(value = "goodsName", required = false)String goodsName,
                       @RequestParam(value = "goodsDepartment", required = false)String goodsDepartment ){

        PageBean<Goods> pageBeans = goodsService.selectClubPageList(currentPage,pageSize,goodsName,goodsDepartment);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("goodsName",goodsName);
        model.addAttribute("goodsDepartment",goodsDepartment);
        logger.info("访问【goodsList.do】接口；返回数据为："+pageBeans.toString());

        return "back/goods/list";
    }

    @RequestMapping("/goodsAdd.do")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        //查询部门003
        List<Dict> departments = dictService.selectDiceByKey("003");
        model.addAttribute("departments",departments);
        return "back/goods/add";
    }

    @RequestMapping("/goodsSave.do")
    public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model,Goods goods){
        goods.setGoodsCreatetime(new Date());
        goods.setGoodsState(1);
        goodsService.insert(goods);
        logger.info("访问【goodsSave.do】接口；返回数据为："+goods);
        return list(request,response,model,null,null,null,null);
    }

    @RequestMapping("/goodEdit.do")
    public String toEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam(value = "goodsId", required = false)Integer goodsId){
        Goods goods = goodsService.selectById(goodsId);
        List<Dict> departments = dictService.selectDiceByKey("003");
        model.addAttribute("departments",departments);
        model.addAttribute("goods",goods);
        return "back/goods/edit";
    }

    @RequestMapping("/goodsUpdate.do")
    public String Update(HttpServletRequest request, HttpServletResponse response, ModelMap model,Goods goods){
        goodsService.updateGoods(goods);
        return list(request,response,model,null,null,null,null);
    }

    /**
     * 同意借出 goodAgree
     */
    @RequestMapping("/goodAgree.do")
    public String goodAgree(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                            @RequestParam(value = "goodsId", required = false)Integer goodsId){
        Goods good = goodsService.selectById(goodsId);
        good.setStandby002(good.getStandby003());
        good.setStandby003("");
        goodsService.updateGoods(good);
        return list(request,response,model,null,null,null,null);
    }

    /**
     * 删除物品 goodDelete
     */
    @RequestMapping("/goodDelete.do")
    public String goodDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                            @RequestParam(value = "goodsId", required = false)Integer goodsId){

        goodsService.deleteByGoodId(goodsId);
        return list(request,response,model,null,null,null,null);
    }

}
