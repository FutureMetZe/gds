package com.gds.controller.back;

import com.gds.entity.Banners;
import com.gds.service.BannersService;
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
@RequestMapping("/back")
public class BannerController {

    private Logger logger = Logger.getLogger(BannerController.class);

    @Resource(name = "BannersService")
    private BannersService bannersService;

    /**
     * 活动列表
     */
    @RequestMapping("/bannerList.do")
    public String bannerList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "pageSize", required = false)Integer pageSize,
                           @RequestParam(value = "currentPage", required = false)Integer currentPage ){
        PageBean<Banners> pageBeans = bannersService.selectBannersPageList(currentPage,pageSize);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        logger.info("访问【bannerList.do】接口；返回数据为："+pageBeans.toString());
        return "back/banners/list";
    }

    /**
     * bannerToAddPage
     */
    @RequestMapping("/bannerToAddPage.do")
    public String bannerToAddPage(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        return "back/banners/add";
    }

    /**
     * bannerSave
     */
    @RequestMapping("/bannerSave.do")
    public String bannerSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             Banners banners){
        bannersService.insertBanner(banners);

        return bannerList(request,response,model,null,null);
    }

    /**
     * bannerEdit
     */
    @RequestMapping("/bannerEdit.do")
    public String bannerEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                  @RequestParam(value = "bannersId", required = false)Integer bannersId){
        Banners banner = bannersService.selectBannerById(bannersId);
        model.addAttribute("banner",banner);
        return "back/banners/edit";
    }

    /**
     * bannerUpdate
     */
    @RequestMapping("/bannerUpdate.do")
    public String bannerUpdate(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             Banners banners){
        bannersService.updateBanner(banners);

        return bannerList(request,response,model,null,null);
    }

    /**
     * bannerDelete
     */
    @RequestMapping("/bannerDelete.do")
    public String bannerDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "bannersId", required = false)Integer bannersId){
        bannersService.deleteById(bannersId);

        return bannerList(request,response,model,null,null);
    }
}
