package org.gecko.framework.tax.controller;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.spi.LoggerFactory;
import org.gecko.common.utils.GeckoProperties;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.ent.entity.EntEntbasic;
import org.gecko.framework.ent.entity.enums.EntType;
import org.gecko.framework.ent.entity.enums.ProductType;
import org.gecko.framework.ent.service.EntEntbasicService;
import org.gecko.framework.model.R;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.utils.GenerateIdUtils;
import org.gecko.framework.wineLabels.entity.AlAlcoholflow;
import org.gecko.framework.wineLabels.entity.AlAlcohollable;
import org.gecko.framework.wineLabels.entity.AlCirculation;
import org.gecko.framework.wineLabels.entity.AlProduct;
import org.gecko.framework.wineLabels.entity.enums.WineLablesStatus;
import org.gecko.framework.wineLabels.service.AlAlcoholflowService;
import org.gecko.framework.wineLabels.service.AlAlcohollableService;
import org.gecko.framework.wineLabels.service.AlCirculationService;
import org.gecko.framework.wineLabels.service.AlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import oracle.sql.DATE;


/**
 * 商品表控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-08 11:25:28
 *
 */
@Controller
@RequestMapping("/tax/alcirculation")
public class TagAlCirculationController extends BaseController<AlProduct> {
	@Autowired
	public AlCirculationService service;
	@Autowired
	public AccountService accountService;
	@Autowired
	public AlAlcoholflowService alcoholflowService;
	@Autowired
	public AlAlcohollableService alcohollabelService;
	@Autowired
	public AlProductService alProductService;
	@Autowired
	public EntEntbasicService entbasicService;
	
	/**
	 * 应税核销的页面跳转
	 * @return
	 */
	@RequestMapping(value = "/taxCancelView", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView taxConfirmView() {
		ModelAndView mad = new ModelAndView("/views/tax/taxCancel.jsp");
		return mad;
	}
	/**
	 * 纳税申报的页面跳转
	 * @return
	 */
	@RequestMapping(value = "/taxDeclareView", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView taxDeclareView() {
		ModelAndView mad = new ModelAndView("/views/tax/taxDeclare.jsp");
		return mad;
	}
	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/addTask", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView save(AlProduct entity,HttpSession session) {
		ModelAndView mad = new ModelAndView("/tax/alproduct/productionCollectionView");
		if(null != entity.getId() && StringUtils.isNoneBlank(String.valueOf(entity.getId()))) {
			//service.update(entity);
		} else {
            if (org.springframework.util.StringUtils.isEmpty(entity.getId())) {
                entity.setId(GenerateIdUtils.generateId32());
                /**
                 * 创建者和创建日期
                 */
                Account acct = (Account) session.getAttribute(GeckoProperties.SESSION_KEY);
                entity.setCreator(acct.getId());
                Date now = new Date(); 
                entity.setCreatedate(new java.sql.Date(now.getTime()));
            }
		}
		return mad;
	}
	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/editTask", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView edit(AlProduct entity,HttpSession session) {
		ModelAndView mad = save(entity,session);
		return mad;
	}
	
	/**
	 * 销售采集的历史信息的列表展示
	 */
	@RequestMapping(value = "/hisCollectionList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_PRODUCT_QUERY"})
	public List<AlCirculation> hisCollectionList(HttpServletRequest request) throws ParseException {
        AlCirculation param = new AlCirculation();
        String winelabelCode = request.getParameter("winelabelCode");
        String winelabeltype = request.getParameter("winelabeltype");
        String productname = request.getParameter("productname");
        String prodcttype = request.getParameter("producttype");
        String belowEntId = request.getParameter("belowent");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(!org.springframework.util.StringUtils.isEmpty(winelabelCode)){
        	//酒标编号
        	param.setTemp1(winelabelCode);
        }
        if(!org.springframework.util.StringUtils.isEmpty(winelabeltype)){
        	//酒标类型
        	//param.setTemp2(winelabeltype);
        }
        if(!org.springframework.util.StringUtils.isEmpty(productname)){
        	//对应商品名称
        	param.setTemp3(productname);
        }
        if(!org.springframework.util.StringUtils.isEmpty(prodcttype)){
        	//对应商品种类
        	param.setTemp4(prodcttype);
        }
        /**应税核销查询酒标为待核销的酒标**/
        param.setProductnum("NEEDWRITTENOFF");
        if(!org.springframework.util.StringUtils.isEmpty(belowEntId)){
        	param.setBelowentid(belowEntId);
        }
        if(!org.springframework.util.StringUtils.isEmpty(startDate)){
        	Date date = sdf.parse(startDate);
        	param.setStarttime(new java.sql.Date(date.getTime()));
        }
        if(!org.springframework.util.StringUtils.isEmpty(endDate)){
        	Date date = sdf.parse(endDate);
        	param.setStarttime(new java.sql.Date(date.getTime()));
        }
        List<AlCirculation> alCirculations = service.findHisAlCirculationByParam(param);
        //用于前台展示的list
        List<AlCirculation> alCirculationsShow = new ArrayList<AlCirculation>();
        for (Iterator iterator = alCirculations.iterator(); iterator.hasNext();) {
			AlCirculation alCirculation = (AlCirculation) iterator.next();
			String saleLinkId = alCirculation.getId();
			if(!org.springframework.util.StringUtils.isEmpty(saleLinkId)){
				AlAlcoholflow alcoholflow = new AlAlcoholflow();
				//alcoholflow.setSalelinkid(saleLinkId);
				alcoholflow.setFlowname("纳税申报");
				List<AlAlcoholflow> alcoholflows = alcoholflowService.find(alcoholflow);
				for (Iterator iterator2 = alcoholflows.iterator(); iterator2.hasNext();) {
					AlAlcoholflow alAlcoholflow = (AlAlcoholflow) iterator2.next();
					AlCirculation alCirculationShow = new AlCirculation();
					String entId = alCirculation.getBelowentid();
					EntEntbasic entBasic = entbasicService.get(entId);
					if(null!=entBasic){
						alCirculationShow.setBelowentid(entBasic.getEntname());
					}
					Date tradeDate = alCirculation.getStarttime();
					if(null!=tradeDate){
						alCirculationShow.setTradeDate(tradeDate.toString());
					}
					alCirculationShow.setEndtime(alCirculation.getEndtime());
					//纳税申报时间
					alCirculationShow.setStarttime(alAlcoholflow.getLastupdatetime());
					alCirculationShow.setProductnum(alCirculation.getProductnum());
					//酒标编号
					alCirculationShow.setTemp1(alAlcoholflow.getSerial());
					AlAlcohollable alcohollable = new AlAlcohollable();
					alcohollable.setSerial(alAlcoholflow.getSerial());
					List<AlAlcohollable> alcohollables = alcohollabelService.find(alcohollable);
					if(alcohollables.size()>0){
						alcohollable = alcohollables.get(0);
						WineLablesStatus status = alcohollable.getStatus();
						//不是待核销
						if(status.getKey()!=5){
							continue;
						}
						//酒标类型
						alCirculationShow.setTemp2(alcohollable.getType().getValue());
					}
					AlProduct alproduct = new AlProduct();
					alproduct.setId(alcohollable.getProductid());
					List<AlProduct> alproducts = alProductService.find(alproduct);
					if(alproducts.size()>0){
						alproduct = alproducts.get(0);
						//商品名称
						alCirculationShow.setTemp3(alproduct.getProductname());
						//商品类型
						alCirculationShow.setTemp4(alproduct.getProducttype().getValue());
					}
					alCirculationsShow.add(alCirculationShow);
				}
			}
		}
        return alCirculationsShow;
	}
	/**
	 * 应税核销的列表展现
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/taxCancelList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_PRODUCT_QUERY"})
	public List<AlCirculation> taxCancelList(HttpServletRequest request,HttpSession session) throws ParseException, UnsupportedEncodingException {
        AlCirculation param = new AlCirculation();
        Account account = (Account) session.getAttribute(GeckoProperties.SESSION_KEY);
        //用于前台展示的list
        List<AlCirculation> alCirculationsShow = new ArrayList<AlCirculation>();
        if(account!=null){
        	 String principal = account.getId();
             String winelabelCode = request.getParameter("winelabelCode");
             String winelabeltype = request.getParameter("winelabeltype");
             String productname = new String(request.getParameter("productname").getBytes("iso-8859-1"),"utf-8");
             String prodcttype = new String(request.getParameter("producttype").getBytes("iso-8859-1"),"utf-8");
             String belowEntId = request.getParameter("belowent");
             String startDate = request.getParameter("startDate");
             String endDate = request.getParameter("endDate");
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           
             if(!org.springframework.util.StringUtils.isEmpty(winelabelCode)){
             	//酒标编号
             	param.setTemp1(winelabelCode);
             }
             if(!org.springframework.util.StringUtils.isEmpty(winelabeltype)){
             	//酒标类型
             	//param.setTemp2(winelabeltype);
             }
             if(!org.springframework.util.StringUtils.isEmpty(productname)){
             	//对应商品名称
             	param.setTemp3(productname);
             }
             if(!org.springframework.util.StringUtils.isEmpty(prodcttype)){
             	//对应商品种类
             	param.setTemp4(prodcttype);
             }
             if(!org.springframework.util.StringUtils.isEmpty(belowEntId)){
             	param.setBelowentid(belowEntId);
             }
             if(!org.springframework.util.StringUtils.isEmpty(startDate)){
             	Date date = sdf.parse(startDate);
             	param.setStarttime(new java.sql.Date(date.getTime()));
             }
             if(!org.springframework.util.StringUtils.isEmpty(endDate)){
             	Date date = sdf.parse(endDate);
             	param.setEndtime(new java.sql.Date(date.getTime()));
             }
             List<AlCirculation> alCirculations = service.findHisAlCirculationByParam(param);
             //取最后一个销售环节的数据
             if(alCirculations.size()>0){
            	 AlCirculation alCirculation = alCirculations.get(alCirculations.size()-1);
            	 String saleLinkId = alCirculation.getId();
      			 if(!org.springframework.util.StringUtils.isEmpty(saleLinkId)){
      				AlAlcoholflow alcoholflow = new AlAlcoholflow();
      				alcoholflow.setFlowname("纳税申报");
      				List<AlAlcoholflow> alcoholflows = alcoholflowService.find(alcoholflow);
      				for (Iterator iterator2 = alcoholflows.iterator(); iterator2.hasNext();) {
    					AlAlcoholflow alAlcoholflow = (AlAlcoholflow) iterator2.next();
    					if(!org.springframework.util.StringUtils.isEmpty(winelabelCode) && !winelabelCode.equals(alAlcoholflow.getSerial())){
    						//酒标编号
    			            continue;
    			        }
    					AlCirculation alCirculationShow = new AlCirculation();
    					String entId = alCirculation.getBelowentid();
    					Account entBasic = accountService.get(entId);
    					if(null!=entBasic){
    						alCirculationShow.setBelowentid(entBasic.getRealName());
    					}
    					Date tradeDate = alCirculation.getStarttime();
    					if(null!=tradeDate){
    						alCirculationShow.setTradeDate(tradeDate.toString());
    					}
    					alCirculationShow.setEndtime(alCirculation.getEndtime());
    					//纳税申报时间
    					alCirculationShow.setStarttime(alAlcoholflow.getLastupdatetime());
    					alCirculationShow.setProductnum(alCirculation.getProductnum());
    					//酒标编号
    					alCirculationShow.setTemp1(alAlcoholflow.getSerial());
    					AlAlcohollable alcohollable = new AlAlcohollable();
    					alcohollable.setSerial(alAlcoholflow.getSerial());
    					List<AlAlcohollable> alcohollables = alcohollabelService.find(alcohollable);
    					if(alcohollables.size()>0){
    						alcohollable = alcohollables.get(0);
    						WineLablesStatus status = alcohollable.getStatus();
    						String application = alcohollable.getApplicant();
    						Account applica = accountService.get(application);
    						alCirculationShow.setCreator(applica.getRealName());
    						//不是待核销
    						if(status.getKey()!=5){
    							continue;
    						}
    						//只显示瓶标
    						if(alcohollable.getType().getKey()==2){
    							continue;
    						}
    						//酒标类型
    						alCirculationShow.setTemp2(alcohollable.getType().getValue());
    					}
    					AlProduct alproduct = new AlProduct();
    					alproduct.setId(alcohollable.getProductid());
    					List<AlProduct> alproducts = alProductService.find(alproduct);
    					if(alproducts.size()>0){
    						alproduct = alproducts.get(0);
    						//商品名称
    						alCirculationShow.setTemp3(alproduct.getProductname());
    						//商品类型
    						alCirculationShow.setTemp4(alproduct.getProducttype().getValue());
    					}
    					alCirculationsShow.add(alCirculationShow);
    				}
      			}
     		}
        }
        return alCirculationsShow;
	}    
	/**
	 * 根据ID列表批量删除对象
	 * @param ids 唯一ID列表
	 * @return R 返回类型
	 */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_PRODUCT_DELETE"})
	public ModelAndView delete(@RequestParam("ids")String[] ids) {
    	ModelAndView mad = new ModelAndView("/tax/alproduct/productionCollectionView");
		service.batchDelete(ids);
		return mad;
	}
    /**
	 * 应税核销
	 * @param ids 唯一ID列表
	 * @return R 返回类型
	 */
    @RequestMapping(value = "/taxCancel", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_PRODUCT_DELETE"})
	public ModelAndView taxCancel(@RequestBody String[] checkedIds, HttpSession session) {
		ModelAndView mad = new ModelAndView("/tax/alcirculation/taxCancelView");
		Account account = (Account) session.getAttribute(GeckoProperties.SESSION_KEY);
		if (account != null) {
			Set<String> boxSerials = new HashSet<String>();
			String accountId = account.getId();
			AlAlcohollable winelabelParam = new AlAlcohollable();
			for (int i = 0; i < checkedIds.length; i++) {
				winelabelParam.setSerial(checkedIds[i]);
				List<AlAlcohollable> winelabels = alcohollabelService.find(winelabelParam);
				AlAlcohollable winelabel = null;
				if (winelabels.size() > 0) {
					winelabel = winelabels.get(0);
				}
				if (null != winelabel) {
					// 酒标的状态设置为已核销
					winelabel.setStatus(WineLablesStatus.WRITTENOFF);
					/** 酒标流程表记录数据 **/
					AlAlcoholflow alcoholflow = new AlAlcoholflow();
					alcoholflow.setCreator(accountId);
					alcoholflow.setFlowname("应税核销");
					alcoholflow.setId(GenerateIdUtils.generateId32());
					alcoholflow.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
					alcoholflow.setSerial(checkedIds[i]);
					alcoholflowService.save(alcoholflow);
					alcohollabelService.update(winelabel);
				}
				boxSerials.add(winelabel.getBoxlable());
			}
			for (Iterator iterator = boxSerials.iterator(); iterator.hasNext();) {
				String winelabelBoxId = (String) iterator.next();
				AlAlcohollable winelabelParam1 = new AlAlcohollable();
				winelabelParam1.setSerial(winelabelBoxId);
				List<AlAlcohollable> winelabels = alcohollabelService.find(winelabelParam1);
				AlAlcohollable winelabelsBox = null;
				if (winelabels.size() > 0) {
					winelabelsBox = winelabels.get(0);
				}
				winelabelsBox.setStatus(WineLablesStatus.WRITTENOFF);
				//**酒标流程表记录数据**//
				AlAlcoholflow alcoholflow = new AlAlcoholflow();
				alcoholflow.setCreator(accountId);
				alcoholflow.setFlowname("应税核销");
				alcoholflow.setId(GenerateIdUtils.generateId32());
				alcoholflow.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
				alcoholflow.setSerial(winelabelBoxId);
				alcoholflowService.save(alcoholflow);
				alcohollabelService.update(winelabelsBox);
			}
				
		}
		return mad;
	}
}