package org.gecko.framework.param.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
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
import org.gecko.framework.param.service.InventorycontrolService;
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
 * INVENTORYCONTROL控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 10:54:45
 *
 */
@Controller
@RequestMapping("/param/inventorycontrol")
public class InventorycontrolController extends BaseController<Inventorycontrol> {

	@Autowired
	public InventorycontrolService service;
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
	 * 数据列表
	 * @param page 分页设置
	 * @param search 查询参数
	 * @param order 排序
	 * @return R返回类型
	 *//*s
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_QUERY"})
	public Page<Inventorycontrol> list(Page<Inventorycontrol> page) {
        Inventorycontrol param = new Inventorycontrol();
        if(page.getSearch()!=null){
        param.setCredit("%" + page.getSearch() + "%");
param.setCirculating("%" + page.getSearch() + "%");
param.setUncirculation("%" + page.getSearch() + "%");
param.setEnt("%" + page.getSearch() + "%");
param.setUnused("%" + page.getSearch() + "%");
param.setFinish("%" + page.getSearch() + "%");
param.setTotal("%" + page.getSearch() + "%");
        }
		page = service.likeByPage(param, page);
		return page;
	}*/

	/**
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_VIEW"})
	public R get(@PathVariable String id) {
		Inventorycontrol inventorycontrol = service.get(id);
		return R.ok().put(inventorycontrol);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_EDIT"})
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
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_DELETE"})
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
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_NEW", "GECKO_PARAM_INVENTORYCONTROL_EDIT"})
	public R save(@RequestBody Inventorycontrol entity) {
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
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}

	/**
	 *	酒标库存监控查询
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_PARAM_INVENTORYCONTROL_VIEW"})
	public List<Inventorycontrol> list(HttpServletRequest request) throws UnsupportedEncodingException {
		String entName = new String(request.getParameter("entName").getBytes("iso-8859-1"),"utf-8");
		String credit =  request.getParameter("credit");
		Inventorycontrol inventory = new Inventorycontrol();
		if(!org.springframework.util.StringUtils.isEmpty(entName)){
			inventory.setEnt(entName);
		} 
		if(!org.springframework.util.StringUtils.isEmpty(credit)){
			inventory.setCredit(credit);
		}
		List<Inventorycontrol> inventorys = service.find(inventory);
		return inventorys;
		
	}
	/**
	 * 酒标库存监控页面
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/listView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public ModelAndView listView(){
		ModelAndView mad = new ModelAndView("/views/param/inventorycontrol/inventorycontrolController.jsp");
		return mad;
	}
	/**
	 * 查询库存酒标明细
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
			if(alAlcohollable.getAltype()!=null){
				alcoholabelShow.setTemp1(alAlcohollable.getAltype().getValue());
			}
			
			if(!org.springframework.util.StringUtils.isEmpty(alAlcohollable.getProductid())){
				AlProduct  product = alproductService.get(alAlcohollable.getProductid());
				if(product!=null){
					alcoholabelShow.setProductid(product.getProductname());
					alcoholabelShow.setApplicanid(product.getProducttype().getValue());
				}
			}
			//alcoholabelShow.setApplicanid(alAlcohollable.getAltype().getValue());
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