package org.gecko.framework.param.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.ent.entity.EntEntbasic;
import org.gecko.framework.ent.service.EntEntbasicService;
import org.gecko.framework.model.R;
import org.gecko.framework.param.entity.Inventorycontrol;
import org.gecko.framework.param.entity.Needtaxcontrol;
import org.gecko.framework.param.service.NeedtaxcontrolService;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.wineLabels.entity.AlAlcohollable;
import org.gecko.framework.wineLabels.entity.AlProduct;
import org.gecko.framework.wineLabels.service.AlAlcohollableService;
import org.gecko.framework.wineLabels.service.AlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * NEEDTAXCONTROL控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 10:54:16
 *
 */
@Controller
@RequestMapping("/param/needtaxcontrol")
public class NeedtaxcontrolController extends BaseController<Needtaxcontrol> {

	@Autowired
	public NeedtaxcontrolService service;
	@Autowired
	public AlAlcohollableService alcoholabelService;
	@Autowired
	public AlProductService alproductService;
	@Autowired
	public AccountService accountService;
	@Autowired
	public EntEntbasicService entBasicService;
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
	 *	酒标应税监控查询
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_VIEW"})
	public List<Needtaxcontrol> list(HttpServletRequest request) throws UnsupportedEncodingException, ParseException {
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM");
		String entName = new String(request.getParameter("entName").getBytes("iso-8859-1"),"utf-8");
		String credit =  request.getParameter("credit");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Needtaxcontrol inventory = new Needtaxcontrol();
		if(!org.springframework.util.StringUtils.isEmpty(entName)){
			inventory.setEnt(entName);
		} 
		if(!org.springframework.util.StringUtils.isEmpty(credit)){
			inventory.setCredit(credit);
		}
		List<Needtaxcontrol> inventorys = service.find(inventory);
		if(!org.springframework.util.StringUtils.isEmpty(startDate) && !org.springframework.util.StringUtils.isEmpty(endDate)){
			for (Iterator iterator = inventorys.iterator(); iterator.hasNext();) {
				Needtaxcontrol needtaxcontrol = (Needtaxcontrol) iterator.next();
				Date deadline = needtaxcontrol.getDeadline();
				java.util.Date start = sdf.parse(startDate);
				java.util.Date end = sdf.parse(endDate);
				if(deadline.after(end) || deadline.before(start)){
					iterator.remove();
				}
			}
		}else if(!org.springframework.util.StringUtils.isEmpty(startDate) && org.springframework.util.StringUtils.isEmpty(endDate)){
			for (Iterator iterator = inventorys.iterator(); iterator.hasNext();) {
				Needtaxcontrol needtaxcontrol = (Needtaxcontrol) iterator.next();
				Date deadline = needtaxcontrol.getDeadline();
				java.util.Date start = sdf.parse(startDate);
				if(deadline.before(start)){
					iterator.remove();
				}
			}
		}else if(org.springframework.util.StringUtils.isEmpty(startDate) && !org.springframework.util.StringUtils.isEmpty(endDate)){
			for (Iterator iterator = inventorys.iterator(); iterator.hasNext();) {
				Needtaxcontrol needtaxcontrol = (Needtaxcontrol) iterator.next();
				Date deadline = needtaxcontrol.getDeadline();
				java.util.Date end = sdf.parse(endDate);
				if(deadline.after(end)){
					iterator.remove();
				}
			}
		}
		return inventorys;
		
	}
	/**
	 * 酒标应税监控页面
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/listView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public ModelAndView listView(){
		ModelAndView mad = new ModelAndView("/views/param/needtaxcontrol/needtaxcontrolController.jsp");
		return mad;
	}
	/**
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_NEEDTAXCONTROL_VIEW"})
	public R get(@PathVariable String id) {
		Needtaxcontrol needtaxcontrol = service.get(id);
		return R.ok().put(needtaxcontrol);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_PARAM_NEEDTAXCONTROL_EDIT"})
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
	@GeckoAuthority(codes = {"GECKO_PARAM_NEEDTAXCONTROL_DELETE"})
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
	@GeckoAuthority(codes = {"GECKO_PARAM_NEEDTAXCONTROL_NEW", "GECKO_PARAM_NEEDTAXCONTROL_EDIT"})
	public R save(@RequestBody Needtaxcontrol entity) {
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
	@GeckoAuthority(codes = {"GECKO_PARAM_NEEDTAXCONTROL_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
	/**
	 * 查询应税酒标明细
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/detailList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<AlAlcohollable> detailList(Page<AlAlcohollable> page ,HttpServletRequest request){
		List<AlAlcohollable> alcoholabelShows = new ArrayList<AlAlcohollable>();
		AlAlcohollable alcoholabel = new AlAlcohollable();
		alcoholabel.setTemp2("1");
		List<AlAlcohollable> alcoholabels = alcoholabelService.find(alcoholabel);
		for (Iterator iterator = alcoholabels.iterator(); iterator.hasNext();) {
			AlAlcohollable alAlcohollable = (AlAlcohollable) iterator.next();
			AlAlcohollable alcoholabelShow = new AlAlcohollable();
			alcoholabelShow.setSerial(alAlcohollable.getSerial());
			alcoholabelShow.setTemp1(alAlcohollable.getType().getValue());
			
			AlProduct  product = alproductService.get(alAlcohollable.getProductid());
			if(product!=null){
				alcoholabelShow.setProductid(product.getProductname());
				alcoholabelShow.setApplicanid(product.getProducttype().getValue());
			}
			alcoholabelShow.setCreator(alAlcohollable.getStatus().getValue());
			String accountId = alAlcohollable.getApplicant();
			Account account = accountService.get(accountId);
			String entId = account.getPrincipal();
			EntEntbasic entBasic = entBasicService.get(entId);
			if(null!=entBasic){
				alcoholabelShow.setGrant(entBasic.getEntname());
				alcoholabelShow.setOwner(entBasic.getCreditcode());
			}
			alcoholabelShows.add(alcoholabelShow);
		}
		return alcoholabelShows;
	}
}
