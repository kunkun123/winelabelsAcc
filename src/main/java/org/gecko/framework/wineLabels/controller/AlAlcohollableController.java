package org.gecko.framework.wineLabels.controller;


import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Order;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.ent.entity.EntEntbasic;
import org.gecko.framework.ent.entity.enums.ProductType;
import org.gecko.framework.ent.service.EntEntbasicService;
import org.gecko.framework.model.R;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.wineLabels.entity.AlAlcoholflow;
import org.gecko.framework.wineLabels.entity.AlAlcohollable;
import org.gecko.framework.wineLabels.entity.AlProduct;
import org.gecko.framework.wineLabels.entity.enums.WineLablesStatus;
import org.gecko.framework.wineLabels.entity.enums.WineLablesType;
import org.gecko.framework.wineLabels.service.AlAlcoholflowService;
import org.gecko.framework.wineLabels.service.AlAlcohollableService;
import org.gecko.framework.wineLabels.service.AlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
 * 酒标信息表控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-08 11:26:10
 *
 */
@Controller
@RequestMapping("/wineLabels/alalcohollable")
public class AlAlcohollableController extends BaseController<AlAlcohollable> {

	@Autowired
	public AlAlcohollableService service;
	@Autowired
	public AlAlcoholflowService alcoholflowService;
	@Autowired
	public AlProductService alProductService;
	@Autowired
	public AccountService accountService;
	@Autowired
	public EntEntbasicService entbasicService;
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
	 * 酒标管理页面
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/labelListView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public ModelAndView entListView(){
		ModelAndView mad = new ModelAndView("/views/wineLabels/alalcohollable/alalcohollable.jsp");
		return mad;
	}
	/**
	 * 酒标管理页面
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/wineLableManagerView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public ModelAndView wineLableManagerView(){
		ModelAndView mad = new ModelAndView("/views/wineLabels/alalcohollable/labelManager.jsp");
		return mad;
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
	@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public Page<AlAlcohollable> list(Page<AlAlcohollable> page) {
        AlAlcohollable param = new AlAlcohollable();
        if(page.getSearch()!=null){
        param.setTemp4("%" + page.getSearch() + "%");
		param.setTemp3("%" + page.getSearch() + "%");
		param.setTemp2("%" + page.getSearch() + "%");
		param.setTemp1("%" + page.getSearch() + "%");
		param.setCreator("%" + page.getSearch() + "%");
		param.setApplicanid("%" + page.getSearch() + "%");
		param.setApplicant("%" + page.getSearch() + "%");
		param.setBoxlable("%" + page.getSearch() + "%");
		//param.setAltype("%" + page.getSearch() + "%");
		param.setProductid("%" + page.getSearch() + "%");
		param.setSales("%" + page.getSearch() + "%");
		//param.setStatus("%" + page.getSearch() + "%");
		//param.setLastupdatetime("%" + page.getSearch() + "%");
		param.setGrant("%" + page.getSearch() + "%");
		//param.setType("%" + page.getSearch() + "%");
		param.setVerfycode("%" + page.getSearch() + "%");
		param.setSerial("%" + page.getSearch() + "%");
		param.setOwner("%" + page.getSearch() + "%");
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
	@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_VIEW"})
	public R get(@PathVariable String id) {
		AlAlcohollable alalcohollable = service.get(id);
		return R.ok().put(alalcohollable);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_EDIT"})
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
	@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_DELETE"})
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
	@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_NEW", "GECKO_WINELABELS_AL_ALCOHOLLABLE_EDIT"})
	public R save(@RequestBody AlAlcohollable entity) {
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
	@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
	/**
	 * 酒标管理查询列表
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/managerList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<AlAlcohollable> labelManagerList(Page<AlAlcohollable> page ,HttpServletRequest request) throws UnsupportedEncodingException{
		page.setLimit(1000);
		AlAlcohollable param = new AlAlcohollable();
		String productidSearch = new String(request.getParameter("productidSearch").getBytes("iso-8859-1"),"utf-8");
		String serialSearch = request.getParameter("serialSearch");
		String statusSearch = request.getParameter("statusSearch");
		//查询条件
		if(!org.springframework.util.StringUtils.isEmpty(serialSearch)){
			param.setSerial(serialSearch);
		}
		
		if(!org.springframework.util.StringUtils.isEmpty(statusSearch)){
			if(statusSearch.equals("UNUSERD")) {
				param.setStatus(WineLablesStatus.UNUSERD);
			}
			else if(statusSearch.equals("UNCIRCULATION")){
				param.setStatus(WineLablesStatus.UNCIRCULATION);
			}
			else if(statusSearch.equals("CIRCULATIONING")){
				param.setStatus(WineLablesStatus.CIRCULATIONING);
			}
			else if(statusSearch.equals("WRITTENOFF")){
				param.setStatus(WineLablesStatus.WRITTENOFF);
			}
		}
		List<AlAlcohollable> alAlcohollables = service.find(param);
		if(!org.springframework.util.StringUtils.isEmpty(productidSearch)){
			for (Iterator iterator = alAlcohollables.iterator(); iterator.hasNext();) {
				AlAlcohollable alAlcohollable = (AlAlcohollable) iterator.next();
				String productId = alAlcohollable.getProductid();
				if(!org.springframework.util.StringUtils.isEmpty(productId)){
					AlProduct alproduct = alProductService.get(productId);
					if(alproduct!=null){
						if(!alproduct.getProductname().equals(productidSearch)){
							iterator.remove();
						}
					}else{
						iterator.remove();
					}
				}else{
					iterator.remove();
				}
			}
		}
		//页面table显示
		List<AlAlcohollable> managerList = new ArrayList<AlAlcohollable>();
		for(Iterator iterator = alAlcohollables.iterator();iterator.hasNext();){
			AlAlcohollable alAlcohollable = (AlAlcohollable) iterator.next();
			AlAlcohollable showList = new AlAlcohollable();
				showList.setSerial(alAlcohollable.getSerial());
				showList.setStatus(alAlcohollable.getStatus());
				showList.setBoxlable(alAlcohollable.getBoxlable());
				//酒标类型
				ProductType winelabelsType = alAlcohollable.getAltype();
				if(null!=winelabelsType){
					showList.setTemp2(alAlcohollable.getAltype().getValue());
				}
				//状态
				WineLablesStatus winelabelsStatus = alAlcohollable.getStatus();
				if(winelabelsStatus!=null){
					showList.setTemp1(winelabelsStatus.getValue());
				}
				if(winelabelsStatus.getKey()==4){
					showList.setTemp1("未使用");
				}
				/**未使用**/
				if(winelabelsStatus.getKey()==4){
					showList.setTemp3("无");
					showList.setProductid("未使用，暂无对应商品信息");
				}else{
					//商品种类
					ProductType producttype = alAlcohollable.getAltype();
					if(producttype!=null){
						showList.setTemp3(producttype.getValue());
					}
					//获取商品名称
					AlProduct alProduct = new AlProduct();
					 alProduct.setId(alAlcohollable.getProductid());
					List<AlProduct> alProducts = alProductService.find(alProduct);
					if(alProducts.size() > 0) {
						alProduct = alProducts.get(0);
						showList.setProductid(alProduct.getProductname());
					}
				}
				//獲取企業的名稱和統一信用代碼
				String entId = alAlcohollable.getOwner();
				Account account = accountService.get(entId);
				if(account!=null){
					EntEntbasic entbasic = entbasicService.get(account.getPrincipal());
					showList.setTemp4(entbasic.getEntname());
					showList.setOwner(entbasic.getCreditcode());
				}
				managerList.add(showList);
		}
		return managerList;
	}
	/**
     *	酒标信息详情
     */
	@RequestMapping(value = "/wineLabelsDetail", method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_NEW", "GECKO_WINELABELS_AL_ALCOHOLLABLE_EDIT"})
	public List<AlAlcohollable> wineLabelsDetail(HttpServletRequest request) {
	   String winelabelId = request.getParameter("winelabelId");
	   AlAlcohollable alcohollable = new AlAlcohollable();
	   alcohollable.setSerial(winelabelId);
	   List<AlAlcohollable> alcohollables = service.find(alcohollable);
	   List<AlAlcohollable> alcohollablesShow = new ArrayList<AlAlcohollable>();
	   if(alcohollables.size()>0){
		   alcohollable = alcohollables.get(0);
		   /**瓶装**/
		   if(alcohollable.getType().getKey()==1){
			   String boxLabel = alcohollable.getBoxlable();
			   AlAlcohollable alcohollableBox = new AlAlcohollable();
			   alcohollableBox.setSerial(boxLabel);
			   List<AlAlcohollable> alcohollableBoxs = service.find(alcohollableBox);
			   if(alcohollableBoxs.size()>0){
				   //查询最后的交易时间
				   List<AlAlcoholflow> alcoholflows = alcoholflowService.findLastSale(winelabelId);
				  if(alcoholflows.size()>0){
					   AlAlcoholflow alcoholflow = alcoholflows.get(0);
					   Date date = alcoholflow.getSaledate();
					   if(date!=null){
						   alcohollable.setTemp2(date.toString());
					   }
				   }
				  //酒标状态
				  WineLablesStatus status = alcohollable.getStatus();
				  if(status!=null){
					  alcohollable.setTemp1(status.getValue());
				  }
				   alcohollable.setSerial(alcohollableBoxs.get(0).getSerial());
				   alcohollablesShow.add(alcohollable);
			   }
		   }else if(alcohollable.getType().getKey()==2){
			   AlAlcohollable alcohollableBottom = new AlAlcohollable();
			   alcohollableBottom.setBoxlable(winelabelId);
			   List<AlAlcohollable> alcohollableBottoms = service.find(alcohollableBottom);
			   for (AlAlcohollable alAlcohollable : alcohollableBottoms) {
				   //查询最后的交易时间
				   List<AlAlcoholflow> alcoholflows = alcoholflowService.findLastSale(winelabelId);
				  if(alcoholflows.size()>0){
					   AlAlcoholflow alcoholflow = alcoholflows.get(0);
					   Date date = alcoholflow.getSaledate();
					   if(date!=null){
						   alcohollable.setTemp2(date.toString());
					   }
				   }
				  //酒标状态
				  WineLablesStatus status = alAlcohollable.getStatus();
				  if(status!=null){
					  alAlcohollable.setTemp1(status.getValue());
				  }
				   alcohollablesShow.add(alAlcohollable);
			   }
		   }
	   }
       return alcohollablesShow;
	}

}
