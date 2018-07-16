package org.gecko.framework.param.controller;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.model.R;
import org.gecko.framework.param.entity.Exceedparam;
import org.gecko.framework.param.service.ExceedparamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * EXCEEDPARAM控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-11 18:00:16
 *
 */
@Controller
@RequestMapping("/param/exceedparam")
public class ExceedparamController extends BaseController<Exceedparam> {

	@Autowired
	public ExceedparamService service;

	/**
	 * index
	 * 打开首页
	 * @param  model    设定文件
	 * @return String   返回类型
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		return "";
	}

	/**
	 * 数据列表
	 * @param page 分页设置
	 * @param search 查询参数
	 * @param order 排序
	 * @return R返回类型
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_EXCEEDPARAM_QUERY"})
	public Page<Exceedparam> list(Page<Exceedparam> page) {
        Exceedparam param = new Exceedparam();
        if(page.getSearch()!=null){
        /*param.setYellowyear("%" + page.getSearch() + "%");
param.setCreatorid("%" + page.getSearch() + "%");
param.setImportyear("%" + page.getSearch() + "%");
param.setCreatedate("%" + page.getSearch() + "%");
param.setTemp1("%" + page.getSearch() + "%");
param.setWhiteyear("%" + page.getSearch() + "%");
param.setRedyear("%" + page.getSearch() + "%");
param.setBeeryear("%" + page.getSearch() + "%");*/
param.setTemp3("%" + page.getSearch() + "%");
param.setTemp4("%" + page.getSearch() + "%");
param.setTemp2("%" + page.getSearch() + "%");
        }
		page = service.likeByPage(param, page);
		return page;
	}

	/**
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_EXCEEDPARAM_VIEW"})
	public R get(@PathVariable String id) {
		Exceedparam exceedparam = service.get(id);
		return R.ok().put(exceedparam);
	}
	/**
	 * 参数设置的页面跳转
	 * @return
	 */
	@RequestMapping(value = "/paramSettingView", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView taxDeclareView() {
		ModelAndView mad = new ModelAndView("/views/param/exceedparam/exceedparam.jsp");
		Exceedparam param = new Exceedparam();
		List<Exceedparam> exceedparams = service.find(param);
		if(exceedparams.size()>0){
			Exceedparam exceedparam = exceedparams.get(0);
			mad.addObject("exceedparam", exceedparam);
		}
		
		return mad;
	}
	
    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_PARAM_EXCEEDPARAM_EDIT"})
    public R updateField(@RequestParam("name") String name, @RequestParam("value") String value, @RequestParam("pk") String pk) {
        R r = R.error();
        if (service.updateField(name, value, pk) > 0) {
            r = R.ok();
        }
        return r;
    }

	/**
	 * 根据ID列表批量删除对象
	 * @param ids 唯一ID列表
	 * @return R 返回类型
	 */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_EXCEEDPARAM_DELETE"})
	public R delete(@RequestBody String[] ids) {
		service.batchDelete(ids);
		return R.ok();
	}

	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/save")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_PARAM_EXCEEDPARAM_NEW", "GECKO_PARAM_EXCEEDPARAM_EDIT"})
	public ModelAndView save( Exceedparam entity) {
        ModelAndView mad = new ModelAndView("/param/exceedparam/paramSettingView");
		if(null != entity.getId() && StringUtils.isNoneBlank(String.valueOf(entity.getId()))) {
			service.update(entity);
            
		} else {
            if (org.springframework.util.StringUtils.isEmpty(entity.getId())) {
                entity.setId(UuidUtil.get32UUID());
                ReflectUtil.fillsProperty(entity);
            }
			
		}
		return mad;
	}

	/**
	 * export  导出数据
	 * @param ids 唯一ID列表
	 * @return R返回类型
	 */
	@RequestMapping(value = "/export/{ids}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_EXCEEDPARAM_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
}
