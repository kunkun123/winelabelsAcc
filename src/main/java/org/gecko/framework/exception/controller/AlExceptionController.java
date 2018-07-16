package org.gecko.framework.exception.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.GeckoProperties;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.ent.entity.EntApplication;
import org.gecko.framework.ent.entity.enums.ProductType;
import org.gecko.framework.model.R;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.wineLabels.entity.AlAlcohollable;
import org.gecko.framework.wineLabels.entity.AlProduct;
import org.gecko.framework.wineLabels.entity.enums.WineLablesStatus;
import org.gecko.framework.wineLabels.entity.enums.WineLablesType;
import org.gecko.framework.wineLabels.service.AlAlcohollableService;
import org.gecko.framework.wineLabels.service.AlProductService;
import org.gecko.framework.exception.entity.AlException;
import org.gecko.framework.exception.service.AlExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * AL_EXCEPTION控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-10 16:38:27
 *
 */
@Controller
@RequestMapping("/exception/alexception")
public class AlExceptionController extends BaseController<AlException> {

	@Autowired
	public AlExceptionService service;
	@Autowired
	public AlAlcohollableService alcoholableService;
	@Autowired
	public AlProductService productService;
	@Autowired
	public AccountService accountService;
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
	 * 异常酒标页面
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/labelExceptionListView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_ALCOHOLLABLE_QUERY"})
	public ModelAndView labelExceptionListView(){
		ModelAndView mad = new ModelAndView("/views/exception/alexception/labelException.jsp");
		return mad;
	}
	
	/**
	 * 异常酒标的列表展现
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/labelExceptionList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<AlException> labelExceptionList(Page<AlAlcohollable> page ,HttpServletRequest request,HttpSession session) throws ParseException, UnsupportedEncodingException{
		page.setLimit(1000);
		//页面table显示
		List<AlException> labelExceptionList = new ArrayList<AlException>();
		
		AlException param = new AlException();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String productSearch = request.getParameter("productidSearch");
		String serialSearch = request.getParameter("serialSearch");
		
		String DateSearch1 = request.getParameter("dateSearch1");
		String DateSearch2 = request.getParameter("dateSearch2");
		//查询条件
		if(!org.springframework.util.StringUtils.isEmpty(serialSearch)){
			param.setSerial(serialSearch);
		}
		
		List<AlException> labelExceptions = service.find(param);
			if((!org.springframework.util.StringUtils.isEmpty(DateSearch1))
					&&(!org.springframework.util.StringUtils.isEmpty(DateSearch2))){
				Iterator<AlException> it = labelExceptions.iterator();
				while(it.hasNext()){
					AlException alException = (AlException) it.next();
					Date occurDate = alException.getOccurdate();
					Date startDate = sdf.parse(DateSearch1);
					Date endDate = sdf.parse(DateSearch2);
					if(occurDate.after(endDate) || occurDate.before(startDate)){
						it.remove();
					}
				}
			}else
			//查询开始时间不为空
			if(!org.springframework.util.StringUtils.isEmpty(DateSearch1)){
				Iterator<AlException> it = labelExceptions.iterator();
				while(it.hasNext()){
					AlException alException = (AlException) it.next();
					Date occurDate = alException.getOccurdate();
					Date startDate = sdf.parse(DateSearch1);
					if(occurDate.before(startDate)){
						it.remove();
					}
				}
			}else
			//查询结束时间不为空
			if(!org.springframework.util.StringUtils.isEmpty(DateSearch2)){
				Iterator<AlException> it = labelExceptions.iterator();
				while(it.hasNext()){
					AlException alException = (AlException) it.next();
					Date occurDate = alException.getOccurdate();
					Date endDate = sdf.parse(DateSearch2);
					if(occurDate.before(endDate)){
						it.remove();
					}
				}
			}
			//商品名称
			if(!org.springframework.util.StringUtils.isEmpty(productSearch)){
				productSearch = new String(productSearch.getBytes("iso-8859-1"),"utf-8");
				Iterator<AlException> it = labelExceptions.iterator();
				while(it.hasNext()){
					AlException alException = (AlException) it.next();
					String serial = alException.getSerial();
					AlAlcohollable alalcohollable = new AlAlcohollable();
					alalcohollable.setSerial(serial);
					List<AlAlcohollable> alAlcohollables = alcoholableService.find(alalcohollable);
					if(alAlcohollables.size()>0){
						String productId = alAlcohollables.get(0).getProductid();
						AlProduct product = productService.get(productId);
						if(!product.getProductname().contains(productSearch)){
							it.remove();
						}
					}
					
				}
			}
			for(Iterator iterator = labelExceptions.iterator();iterator.hasNext();){
				AlException alException = (AlException) iterator.next();
				AlException showList = new AlException();
					showList.setSerial(alException.getSerial());
					
					String serial = alException.getSerial();
					AlAlcohollable alalcohollable = new AlAlcohollable();
					alalcohollable.setSerial(serial);
					List<AlAlcohollable> alAlcohollables = alcoholableService.find(alalcohollable);
					if(alAlcohollables.size()>0){
						//酒标类型
						ProductType winelabelsType = alAlcohollables.get(0).getAltype();
						if(winelabelsType!=null){
							showList.setTemp1(winelabelsType.getValue());
						}
						//商品种类
						showList.setTemp3(alAlcohollables.get(0).getAltype().getValue());
						showList.setCreator(alAlcohollables.get(0).getStatus().getValue());
						//获取商品名称
						if(!org.springframework.util.StringUtils.isEmpty(alAlcohollables.get(0).getProductid())){
							AlProduct alProduct = productService.get(alAlcohollables.get(0).getProductid());
							showList.setTemp4(alProduct.getProductname());
						}
						String entId  = alAlcohollables.get(0).getApplicant();
						Account account = accountService.get(entId);
						if(account!=null){
							showList.setTemp2(account.getRealName());
						}
						
					}
					
				
					showList.setOccurdate(alException.getOccurdate());
					showList.setReason(alException.getReason());
					labelExceptionList.add(showList);
			}
		
		return labelExceptionList;
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
	@GeckoAuthority(codes = {"GECKO_EXCEPTION_AL_EXCEPTION_QUERY"})
	public Page<AlException> list(Page<AlException> page) {
        AlException param = new AlException();
        if(page.getSearch()!=null){
        param.setReason("%" + page.getSearch() + "%");
param.setSerial("%" + page.getSearch() + "%");
//param.setOccurdate("%" + page.getSearch() + "%");
//param.setLastupdate("%" + page.getSearch() + "%");
param.setCreator("%" + page.getSearch() + "%");
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
	@GeckoAuthority(codes = {"GECKO_EXCEPTION_AL_EXCEPTION_VIEW"})
	public R get(@PathVariable String id) {
		AlException alexception = service.get(id);
		return R.ok().put(alexception);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_EXCEPTION_AL_EXCEPTION_EDIT"})
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
	@GeckoAuthority(codes = {"GECKO_EXCEPTION_AL_EXCEPTION_DELETE"})
	public R delete(@RequestBody String[] ids) {
		service.batchDelete(ids);
		return R.ok();
	}

	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_EXCEPTION_AL_EXCEPTION_NEW", "GECKO_EXCEPTION_AL_EXCEPTION_EDIT"})
	public ModelAndView  save(AlException entity) {
		ModelAndView mad = new ModelAndView("/exception/alexception/labelExceptionListView");
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
		return mad;
	}

	/**
	 * export  导出数据
	 * @param ids 唯一ID列表
	 * @return R返回类型
	 */
	@RequestMapping(value = "/export/{ids}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_EXCEPTION_AL_EXCEPTION_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
}