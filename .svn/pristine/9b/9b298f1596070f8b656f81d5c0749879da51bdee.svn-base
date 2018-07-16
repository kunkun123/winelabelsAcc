package org.gecko.framework.param.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.model.R;
import org.gecko.framework.param.entity.Finishtaxcontrol;
import org.gecko.framework.param.entity.Inventorycontrol;
import org.gecko.framework.param.service.FinishtaxcontrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * FINISHTAXCONTROL控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 10:53:42
 *
 */
@Controller
@RequestMapping("/param/finishtaxcontrol")
public class FinishtaxcontrolController extends BaseController<Finishtaxcontrol> {

	@Autowired
	public FinishtaxcontrolService service;

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
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_FINISHTAXCONTROL_VIEW"})
	public R get(@PathVariable String id) {
		Finishtaxcontrol finishtaxcontrol = service.get(id);
		return R.ok().put(finishtaxcontrol);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_PARAM_FINISHTAXCONTROL_EDIT"})
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
	@GeckoAuthority(codes = {"GECKO_PARAM_FINISHTAXCONTROL_DELETE"})
	public R delete(@RequestBody String[] ids) {
		service.batchDelete(ids);
		return R.ok();
	}

	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_FINISHTAXCONTROL_NEW", "GECKO_PARAM_FINISHTAXCONTROL_EDIT"})
	public R save(@RequestBody Finishtaxcontrol entity) {
        R r = new R();
		if(null != entity.getId() && StringUtils.isNoneBlank(String.valueOf(entity.getId()))) {
			service.update(entity);
            r = R.ok();
		} else {
            if (org.springframework.util.StringUtils.isEmpty(entity.getId())) {
                entity.setId(UuidUtil.get32UUID());
                ReflectUtil.fillsProperty(entity);
            }
			r.put(service.save(entity));
		}
		return r;
	}

	/**
	 * export  导出数据
	 * @param ids 唯一ID列表
	 * @return R返回类型
	 */
	@RequestMapping(value = "/export/{ids}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_FINISHTAXCONTROL_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
	/**
	 *	酒标完税查询
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 * @throws UnsupportedEncodingException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_VIEW"})
	public List<Finishtaxcontrol> list(HttpServletRequest request) throws UnsupportedEncodingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String entName = new String(request.getParameter("entName").getBytes("iso-8859-1"),"utf-8");
		String credit =  request.getParameter("credit");
		String year = request.getParameter("year");
		Finishtaxcontrol inventory = new Finishtaxcontrol();
		HashSet<String> set = new HashSet<String>();
		List<Finishtaxcontrol> finishtaxcontrolShows = new ArrayList<Finishtaxcontrol>();
		if(!org.springframework.util.StringUtils.isEmpty(entName)){
			inventory.setEnt(entName);
		} 
		if(!org.springframework.util.StringUtils.isEmpty(credit)){
			inventory.setCredit(credit);
		}
		if(!org.springframework.util.StringUtils.isEmpty(year)){
			inventory.setYear(year);
		} 
		List<Finishtaxcontrol> finishtaxcontrols = service.find(inventory);
		for (Iterator iterator = finishtaxcontrols.iterator(); iterator.hasNext();) {
			Finishtaxcontrol finishtaxcontrol = (Finishtaxcontrol) iterator.next();
			set.add(finishtaxcontrol.getEnt()+"@"+finishtaxcontrol.getCredit());
		}
		for (String str : set) {  
			
			String ent = str.split("@")[0];
			String creditShow = str.split("@")[1];
			Finishtaxcontrol inventorySearch = new Finishtaxcontrol();
			inventorySearch.setEnt(ent);
			inventorySearch.setYear(year);
			Finishtaxcontrol finishtaxcontrolShow = new Finishtaxcontrol();
			int j =1;
			while(j<=12){
				inventorySearch.setMonth(j+"");
				List<Finishtaxcontrol> finishtaxcontrolSearchs = service.find(inventorySearch);
			
					Finishtaxcontrol finishtaxcontrol = finishtaxcontrolSearchs.get(0);
					String temp = finishtaxcontrol.getFinish();
					finishtaxcontrol.getClass().getMethod("setTemp"+j, new Class[]{String.class}).invoke(finishtaxcontrolShow,new Object[]{temp});
					j++;
				}
				finishtaxcontrolShow.setCredit(creditShow);
				finishtaxcontrolShow.setEnt(ent);
				finishtaxcontrolShow.setFinish(Integer.parseInt(finishtaxcontrolShow.getTemp1())
												+Integer.parseInt(finishtaxcontrolShow.getTemp2())
												+Integer.parseInt(finishtaxcontrolShow.getTemp3())
												+Integer.parseInt(finishtaxcontrolShow.getTemp4())
												+Integer.parseInt(finishtaxcontrolShow.getTemp5())
												+Integer.parseInt(finishtaxcontrolShow.getTemp6())
												+Integer.parseInt(finishtaxcontrolShow.getTemp7())
												+Integer.parseInt(finishtaxcontrolShow.getTemp8())
												+Integer.parseInt(finishtaxcontrolShow.getTemp9())
												+Integer.parseInt(finishtaxcontrolShow.getTemp10())
												+Integer.parseInt(finishtaxcontrolShow.getTemp11())
												+Integer.parseInt(finishtaxcontrolShow.getTemp12())
												+"");
				finishtaxcontrolShows.add(finishtaxcontrolShow);
			}
			return finishtaxcontrolShows;
		}
		
		
		
		
		
	/**
	 * 酒标完税监控页面
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/listView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public ModelAndView listView(){
		ModelAndView mad = new ModelAndView("/views/param/finishtaxcontrol/finishtaxcontrolController.jsp");
		return mad;
	}
}
